package cn.com.tcsl.mvptest.http.model;

/**
 * Created by wjx on 2016/7/19.
 */
public class LoginRequest
{
    /**
     * mcCode : GBLHPLD
     * mcPWD : 1314
     * pcCode : ********
     */

    private String mcCode;
    private String mcPWD;
    private String pcCode;

    public String getMcCode() {
        return mcCode;
    }

    public void setMcCode(String mcCode) {
        this.mcCode = mcCode;
    }

    public String getMcPWD() {
        return mcPWD;
    }

    public void setMcPWD(String mcPWD) {
        this.mcPWD = mcPWD;
    }

    public String getPcCode() {
        return pcCode;
    }

    public void setPcCode(String pcCode) {
        this.pcCode = pcCode;
    }
}
