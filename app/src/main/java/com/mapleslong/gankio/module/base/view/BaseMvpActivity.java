package com.mapleslong.gankio.module.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mapleslong.gankio.module.base.presenter.BasePresenter;

/**
 * Created by Mapleslong on 16/8/17.
 */
public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter> extends
        AppCompatActivity implements BaseView {
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    ///================等待实现的方法集合==========================
    public abstract void initVariables();//初始化变量,包括Intent带的数据和Activity内的变量

    public abstract void initViews(); // 加载layout布局文件,初始化控件

    //    public void initEvents() {} // 为控件加载事件

    protected abstract P initPresenter();


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showMessage(String msg, int duration) {

    }
}
