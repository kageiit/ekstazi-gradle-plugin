package com.kageiit.ekstazi;

public class EkstaziExtension {

    private static final String DEFAULT_VERSION = "4.6.3";

    private String version = DEFAULT_VERSION;
    private String mode = "junit";
    private boolean forceFailing = true;
    private String extraOptions = "";

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isForceFailing() {
        return forceFailing;
    }

    public void setForceFailing(boolean forceFailing) {
        this.forceFailing = forceFailing;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getExtraOptions() {
        return extraOptions;
    }

    public void setExtraOptions(String extraOptions) {
        this.extraOptions = extraOptions;
    }

    @Override
    public String toString() {
        return String.join(",",
                "mode=" + mode,
                "force.failing=" + String.valueOf(forceFailing),
                extraOptions);
    }
}
