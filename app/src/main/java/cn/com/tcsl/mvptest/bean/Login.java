package cn.com.tcsl.mvptest.bean;
/**
 * 登录返回信息实体
 */
public class Login {

    private String RSAPub;

    private String dirName;

    private String ftpIP;

    private String ftpPW;

    private String ftpPort;

    private String ftpUserName;

    private String mcID;

    private String message;

    private String pushHost;

    private String pushParam;

    private String pushPort;

    private String rvCtlFlg;

    private String status;

    private boolean success;

    private String url;

    public String getRsaPub() {
        return RSAPub;
    }

    public void setRsaPub(String RSAPub) {
        this.RSAPub = RSAPub;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getFtpIP() {
        return ftpIP;
    }

    public void setFtpIP(String ftpIP) {
        this.ftpIP = ftpIP;
    }

    public String getFtpPW() {
        return ftpPW;
    }

    public void setFtpPW(String ftpPW) {
        this.ftpPW = ftpPW;
    }

    public String getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(String ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpUserName() {
        return ftpUserName;
    }

    public void setFtpUserName(String ftpUserName) {
        this.ftpUserName = ftpUserName;
    }

    public String getMcID() {
        return mcID;
    }

    public void setMcID(String mcID) {
        this.mcID = mcID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPushHost() {
        return pushHost;
    }

    public void setPushHost(String pushHost) {
        this.pushHost = pushHost;
    }

    public String getPushParam() {
        return pushParam;
    }

    public void setPushParam(String pushParam) {
        this.pushParam = pushParam;
    }

    public String getPushPort() {
        return pushPort;
    }

    public void setPushPort(String pushPort) {
        this.pushPort = pushPort;
    }

    public String getRvCtlFlg() {
        return rvCtlFlg;
    }

    public void setRvCtlFlg(String rvCtlFlg) {
        this.rvCtlFlg = rvCtlFlg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
