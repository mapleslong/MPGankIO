package com.mapleslong.gankio.module.main.presenter;

import com.mapleslong.gankio.config.GankConfig;
import com.mapleslong.gankio.entity.ApiResponse;
import com.mapleslong.gankio.entity.GankDataEntity;
import com.mapleslong.gankio.module.base.presenter.BasePresenter;
import com.mapleslong.gankio.module.main.model.TypeModel;
import com.mapleslong.gankio.module.main.view.TypeFragmentView;
import com.mapleslong.gankio.network.ApiCallback;
import com.mapleslong.gankio.network.SubscriberCallback;
import com.mapleslong.gankio.utils.log.L;

import java.util.List;

/**
 * Created by Mapleslong on 16/8/18.
 */
public class TypePresenter extends BasePresenter<TypeFragmentView> {
    private TypeModel mTypeModelnew = new TypeModel();

    public void getTypeGankList() {
        addSubscription(mTypeModelnew.getTypeGankList(mView.getCategory(), GankConfig.PAGE_SIZE,
                mView.getCurPage()), new SubscriberCallback(new ApiCallback<ApiResponse<List
                <GankDataEntity>>>() {
            @Override
            public void onSuccess(ApiResponse<List<GankDataEntity>> model) {
                if (!model.isError() && model.getResults().size() > 0) {
                    mView.makeUpDatas(model.getResults());
                    mView.addOnePage();
                }
                mView.notifyAdapter();
            }

            @Override
            public void onFailure(int code, String msg) {
                L.e("错误码:" + code + "------错误消息:" + msg);
                mView.showToast(msg);
            }

            @Override
            public void onCompleted() {
                mView.hideLoading();
            }
        }

        ));
    }
}
