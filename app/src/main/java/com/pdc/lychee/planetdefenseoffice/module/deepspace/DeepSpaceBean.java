package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lychee on 2016/6/16.
 */
public class DeepSpaceBean {


    /**
     * date : 2016-06-21
     * explanation : In the center of this serene stellar swirl is likely a harrowing black-hole beast. The surrounding swirl sweeps around billions of stars which are highlighted by the brightest and bluest. The breadth and beauty of the display give the swirl the designation of a grand design spiral galaxy. The central beast shows evidence that it is a supermassive black hole about 10 million times the mass of our Sun. This ferocious creature devours stars and gas and is surrounded by a spinning moat of hot plasma that emits blasts of X-rays. The central violent activity gives it the designation of a Seyfert galaxy. Together, this beauty and beast are cataloged as NGC 6814 and have been appearing together toward the constellation of the Eagle (Aquila) for roughly the past billion years.
     * hdurl : http://apod.nasa.gov/apod/image/1606/NGC6814_hubble_3970.jpg
     * media_type : image
     * service_version : v1
     * title : NGC 6814: Grand Design Spiral Galaxy from Hubble
     * url : http://apod.nasa.gov/apod/image/1606/NGC6814_hubble_960.jpg
     */

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
