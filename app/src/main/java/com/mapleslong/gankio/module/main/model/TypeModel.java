package com.mapleslong.gankio.module.main.model;

import com.mapleslong.gankio.entity.ApiResponse;
import com.mapleslong.gankio.entity.GankDataEntity;
import com.mapleslong.gankio.module.base.model.BaseModel;
import com.mapleslong.gankio.network.NetworkApiClient;

import java.util.List;

import rx.Observable;

/**
 * Created by Mapleslong on 16/8/18.
 */
public class TypeModel extends BaseModel {
    public Observable<ApiResponse<List<GankDataEntity>>> getTypeGankList(String category, int
            pageSize, int page) {
        return NetworkApiClient.getApiService().getGankCategoryDatas(category, pageSize, page);

    }
}
