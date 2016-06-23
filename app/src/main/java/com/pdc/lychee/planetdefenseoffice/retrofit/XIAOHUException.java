package com.pdc.lychee.planetdefenseoffice.retrofit;

/**
 * Created by lychee on 2016/6/23.
 */
public class XIAOHUException extends Exception {
    private final int code;
    private String displayMessage;

    //状态码
    public static final int UNKNOWN = 1000;
    public static final int DB_QUERY = 666;
    public static final int DB_INSERT = 667;

    public XIAOHUException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String msg) {
        this.displayMessage = msg + "(code:" + code + ")";
    }
}
