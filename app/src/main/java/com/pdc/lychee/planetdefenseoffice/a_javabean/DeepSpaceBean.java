package com.pdc.lychee.planetdefenseoffice.a_javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lychee on 2016/6/16.
 */
public class DeepSpaceBean extends DeepSpaceIllegalBean {


    /**
     * copyright : Bertrand Kulik
     * date : 2016-06-22
     * explanation : What's that over Paris?  Cirrus. Typically, cirrus clouds appear white or gray when reflecting sunlight, can appear dark at sunset (or sunrise) against a better lit sky. Cirrus are among the highest types of clouds and are usually thin enough to see stars through.  Cirrus clouds may form from moisture released above storm clouds and so may herald the arrival of a significant change in weather.  Conversely, cirrus clouds have also been seen on Mars, Jupiter, Saturn, Titan, Uranus, and Neptune.  The featured image was taken two days ago from a window in District 15, Paris, France, Earth.  The brightly lit object on the lower right is, of course, the Eiffel Tower.
     * hdurl : http://apod.nasa.gov/apod/image/1606/CirrusParis_Kulik_1080.jpg
     * media_type : image
     * title : Cirrus over Paris
     * url : http://apod.nasa.gov/apod/image/1606/CirrusParis_Kulik_1080.jpg
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
