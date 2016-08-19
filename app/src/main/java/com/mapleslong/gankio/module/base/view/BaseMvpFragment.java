package com.mapleslong.gankio.module.base.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.mapleslong.gankio.module.base.presenter.BasePresenter;
import com.mapleslong.gankio.utils.HUDUtil;
import com.mapleslong.gankio.utils.ToastUtil;

/**
 * Created by Mapleslong on 16/8/18.
 */
public abstract class BaseMvpFragment<V extends BaseView, P extends BasePresenter<V>> extends
        Fragment implements BaseView {
    public P presenter;
    public Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.attach((V) this);
    }

    ///================等待实现的方法集合==========================
    public abstract void initVariables();//初始化变量,包括Intent带的数据和Activity内的变量

    public abstract void initViews(); // 加载layout布局文件,初始化控件


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        presenter = initPresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDetach() {
        presenter.dettach();
        super.onDetach();
    }

    protected abstract P initPresenter();

    @Override
    public void showLoading() {
        HUDUtil.showLoading(mActivity);
    }

    @Override
    public void hideLoading() {
        HUDUtil.hideLoading();
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.show(mActivity, msg);
    }

    @Override
    public void showMessage(String msg, int duration) {

    }

}
