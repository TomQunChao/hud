package com.autonavi.ae.data;

public final class InitParams {
    private String configFileContent;
    private String configFilePath;
    private String dataFilePath;
    private String p3dCrossPath;
    private String rootPath;

    public final void setRootPath(String str) {
        this.rootPath = str;
    }

    public final String getConfigFilePath() {
        String str = this.configFilePath;
        return str == null ? "" : str;
    }

    public final void setConfigFilePath(String str) {
        this.configFilePath = str;
    }

    public final void setConfigFileContent(String str) {
        this.configFileContent = str;
    }

    public final void setDataFilePath(String str) {
        this.dataFilePath = str;
    }

    public final void set3dCrossPath(String str) {
        this.p3dCrossPath = str;
    }

    public final String getRootPath() {
        String str = this.rootPath;
        return str == null ? "" : str;
    }

    public final String getConfigFileContent() {
        String str = this.configFileContent;
        return str == null ? "" : str;
    }

    public final String getDataFilePath() {
        String str = this.dataFilePath;
        return str == null ? "" : str;
    }

    public final String get3dCrossPath() {
        String str = this.p3dCrossPath;
        return str == null ? "" : str;
    }
}
