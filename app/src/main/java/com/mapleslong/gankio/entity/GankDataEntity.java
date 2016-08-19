package com.mapleslong.gankio.entity;

/**
 * Created by Mapleslong on 16/8/17.
 */
public class GankDataEntity {

    /**
     * _id : 57b31e7d421aa93a804bea0b
     * createdAt : 2016-08-16T22:09:01.858Z
     * desc : 又一款 MD 风格的 Android 文件选择器组件，支持文件分类选取，交互不错。
     * publishedAt : 2016-08-17T11:38:52.656Z
     * source : chrome
     * type : Android
     * url : https://github.com/DroidNinja/Android-FilePicker
     * used : true
     * who : 代码家
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String get_id() { return _id;}

    public void set_id(String _id) { this._id = _id;}

    public String getCreatedAt() { return createdAt;}

    public void setCreatedAt(String createdAt) { this.createdAt = createdAt;}

    public String getDesc() { return desc;}

    public void setDesc(String desc) { this.desc = desc;}

    public String getPublishedAt() { return publishedAt;}

    public void setPublishedAt(String publishedAt) { this.publishedAt = publishedAt;}

    public String getSource() { return source;}

    public void setSource(String source) { this.source = source;}

    public String getType() { return type;}

    public void setType(String type) { this.type = type;}

    public String getUrl() { return url;}

    public void setUrl(String url) { this.url = url;}

    public boolean isUsed() { return used;}

    public void setUsed(boolean used) { this.used = used;}

    public String getWho() { return who;}

    public void setWho(String who) { this.who = who;}
}
