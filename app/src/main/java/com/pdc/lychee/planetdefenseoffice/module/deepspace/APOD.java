package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lychee on 2016/6/16.
 */
public class APOD {

    /**
     * copyright : Alex Conu
     * date : 2016-06-16
     * explanation : The Aurora Borealis or northern lights are familiar visitors to night skies above the village of Reine in the Lofoten Islands, Norway, planet Earth. In this scene, captured from a mountaintop camp site, the auroral curtains do seem to create an eerie tension with the coastal lights though. A modern perspective on the world at night, the stunning image was chosen as the over all winner in The World at Night's 2016 International Earth and Sky Photo Contest. Selections were made from over 900 entries highlighting the beauty of the night sky and its battle with light pollution.
     * hdurl : http://apod.nasa.gov/apod/image/1606/TWAN6108-03LConu.jpg
     * media_type : image
     * service_version : v1
     * title : Northern Lights above Lofoten
     * url : http://apod.nasa.gov/apod/image/1606/TWAN6108-03LConu.jpg
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
