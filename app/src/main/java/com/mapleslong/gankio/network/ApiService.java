package com.mapleslong.gankio.network;

import com.mapleslong.gankio.entity.ApiResponse;
import com.mapleslong.gankio.entity.GankDataEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Mapleslong on 16/8/17.
 */
public interface ApiService {

    /**
     * 获取分类资源
     *
     * @param category
     * @param pageSize
     * @param page
     * @return
     */
    @GET("data/{category}/{pagesize}/{page}")
    Observable<ApiResponse<List<GankDataEntity>>> getGankCategoryDatas(@Path("category") String
                                                                               category,
                                                                       @Path("pagesize") int
                                                                               pageSize,
                                                                       @Path("page") int page);

    /**
     * 获取随机分类资源
     *
     * @param category
     * @param pageSize
     * @param page
     * @return
     */
    @GET("random/data/{category}/{pagesize}/{page}")
    Observable<ApiResponse<List<GankDataEntity>>> getGankRandomCategoryDatas(@Path("category")
                                                                             String category,
                                                                             @Path("pagesize")
                                                                             int pageSize,
                                                                             @Path("page") int page);


}
