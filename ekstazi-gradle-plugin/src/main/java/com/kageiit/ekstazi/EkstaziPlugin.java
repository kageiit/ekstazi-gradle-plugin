package com.kageiit.ekstazi;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency;
import org.gradle.api.tasks.testing.Test;

import java.io.File;

public class EkstaziPlugin implements Plugin<Project> {

    private static final String EKSTAZI = "ekstazi";
    private static final String EKSTAZI_GROUP = "org.ekstazi";
    private static final String EKSTAZI_NAME = "org.ekstazi.core";

    @Override
    public void apply(Project project) {
        EkstaziExtension extension = project.getExtensions().create(EKSTAZI, EkstaziExtension.class);
        project.afterEvaluate(p ->
                {
                    Configuration ekstazi = project.getConfigurations().detachedConfiguration(
                            new DefaultExternalModuleDependency(EKSTAZI_GROUP, EKSTAZI_NAME, extension.getVersion())
                    );
                    p.getTasks().withType(Test.class).forEach(task ->
                            {
                                task.dependsOn(ekstazi);
                                System.out.println( extension.toString());
                                task.jvmArgs(
                                        String.format("-javaagent:%s=root.dir=%s,%s",
                                                ekstazi.getFiles().iterator().next().getAbsolutePath(),
                                                task.getProject().getBuildDir().getAbsolutePath() + File.separator +
                                                        ".ekstazi" + File.separator + task.getName(),
                                                extension.toString())
                                );
                            }
                    );
                }
        );
    }
}
