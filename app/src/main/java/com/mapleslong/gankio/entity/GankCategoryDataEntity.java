package com.mapleslong.gankio.entity;

import java.util.List;

/**
 * Created by Mapleslong on 16/8/17.
 */
public class GankCategoryDataEntity {

    private List<GankDataEntity> Android;
    private List<GankDataEntity> iOS;
    private List<GankDataEntity> 休息视频;
    private List<GankDataEntity> 拓展资源;
    private List<GankDataEntity> 瞎推荐;
    private List<GankDataEntity> 福利;

    public List<GankDataEntity> getAndroid() { return Android;}

    public void setAndroid(List<GankDataEntity> Android) { this.Android = Android;}

    public List<GankDataEntity> getIOS() { return iOS;}

    public void setIOS(List<GankDataEntity> iOS) { this.iOS = iOS;}

    public List<GankDataEntity> get休息视频() { return 休息视频;}

    public void set休息视频(List<GankDataEntity> 休息视频) { this.休息视频 = 休息视频;}

    public List<GankDataEntity> get拓展资源() { return 拓展资源;}

    public void set拓展资源(List<GankDataEntity> 拓展资源) { this.拓展资源 = 拓展资源;}

    public List<GankDataEntity> get瞎推荐() { return 瞎推荐;}

    public void set瞎推荐(List<GankDataEntity> 瞎推荐) { this.瞎推荐 = 瞎推荐;}

    public List<GankDataEntity> get福利() { return 福利;}

    public void set福利(List<GankDataEntity> 福利) { this.福利 = 福利;}
}
