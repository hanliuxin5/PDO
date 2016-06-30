package com.pdc.lychee.planetdefenseoffice.a_javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lychee on 2016/6/16.
 */
public class DeepSpaceBean {


    /**
     * copyright : Regina Kelly
     * date : 2016-06-27
     * explanation : What's happening over the horizon?  Although the scene may appear somehow supernatural, nothing more unusual is occurring than a setting Sun and some well placed clouds.  Pictured above are anticrepuscular rays.  To understand them, start by picturing common crepuscular rays that are seen any time that sunlight pours though scattered clouds. Now although sunlight indeed travels along straight lines, the projections of these lines onto the spherical sky are great circles.  Therefore, the crepuscular rays from a setting (or rising) sun will appear to re-converge on the other side of the sky.  At the anti-solar point 180 degrees around from the Sun, they are referred to as anticrepuscular rays.  Featured here is a particularly striking display of anticrepuscular rays photographed earlier this month in Westminster, Colorado, USA.   Deja vu: Anticrepuscular Rays over Colorado (I)
     * hdurl : http://apod.nasa.gov/apod/image/1606/Anticrep02_Kelly_3264.jpg
     * media_type : image
     * service_version : v1
     * title : Anticrepuscular Rays over Colorado (II)
     * url : http://apod.nasa.gov/apod/image/1606/Anticrep02_Kelly_960.jpg
     */

    @SerializedName("copyright")
    private String copyright;
    @SerializedName("date")
    private String date;
    @SerializedName("explanation")
    private String explanation;
    @SerializedName("hdurl")
    private String hdurl;
    @SerializedName("media_type")
    private String mediaType;
    @SerializedName("service_version")
    private String serviceVersion;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
