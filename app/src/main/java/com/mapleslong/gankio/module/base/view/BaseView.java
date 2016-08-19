package com.mapleslong.gankio.module.base.view;

/**
 * Created by Mapleslong on 16/8/17.
 */
public interface BaseView {

    /**
     * 显示Loading
     */
    void showLoading();

    /**
     * 隐藏loading
     */
    void hideLoading();

    /**
     * 显示Toast
     *
     * @param msg
     */
    void showToast(String msg);

    /**
     * 显示消息(可以做成dialog)效果
     *
     * @param msg      提示的信息
     * @param duration 持续的时间自动消失或者按钮消失
     */
    void showMessage(String msg, int duration);
}
