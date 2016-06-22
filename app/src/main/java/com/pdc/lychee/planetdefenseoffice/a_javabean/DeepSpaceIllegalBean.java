package com.pdc.lychee.planetdefenseoffice.a_javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lychee on 2016/6/22.
 */
public class DeepSpaceIllegalBean {

    /**
     * code : 400
     * msg : Date must be between Jun 16, 1995 and Jun 22, 2016.
     * service_version : v1
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("service_version")
    private String serviceVersion;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }
}
