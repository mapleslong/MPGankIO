package com.mapleslong.gankio.module.main.view;

import com.mapleslong.gankio.entity.GankDataEntity;
import com.mapleslong.gankio.module.base.view.BaseView;

import java.util.List;

/**
 * Created by Mapleslong on 16/8/18.
 */
public interface TypeFragmentView extends BaseView {

    String getCategory();

    int getCurPage();

    void addOnePage();

    void makeUpDatas(List<GankDataEntity> datas);

    void notifyAdapter();

    void resetDatas();
}
