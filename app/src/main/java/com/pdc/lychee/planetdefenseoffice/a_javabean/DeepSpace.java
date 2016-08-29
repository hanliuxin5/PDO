package com.pdc.lychee.planetdefenseoffice.a_javabean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lychee on 2016/8/29.
 */

@Entity
public class DeepSpace {
//    public static final String TABLE_NAME = "DP";
//    public static final String COLUMN_NAME_DATE = "date";
//    public static final String COLUMN_NAME_EXPLANATION = "explanation";
//    public static final String COLUMN_NAME_HDURL = "hdurl";
//    public static final String COLUMN_NAME_TITLE = "title";
//    public static final String COLUMN_NAME_URL = "url";
//    public static final String COLUMN_NAME_MEDIATYPE = "media_type";

    @Id(autoincrement = true)
    private Long id;

    private String date;
    private String explanation;
    private String hdurl;
    private String title;
    private String url;
    private String media_type;


    @Generated(hash = 674494595)
    public DeepSpace(Long id, String date, String explanation, String hdurl,
            String title, String url, String media_type) {
        this.id = id;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.title = title;
        this.url = url;
        this.media_type = media_type;
    }

    @Generated(hash = 1269858282)
    public DeepSpace() {
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

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
