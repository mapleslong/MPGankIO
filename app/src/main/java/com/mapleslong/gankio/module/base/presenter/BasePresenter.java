package com.mapleslong.gankio.module.base.presenter;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Mapleslong on 16/8/17.
 */
public class BasePresenter<V> {
    public V mView;
    protected CompositeSubscription mCompositeSubscription;

    public void attach(V view) {
        this.mView = view;
    }

    public void dettach() {
        this.mView = null;
        onUnsubscribe();
    }


    // RXJava取消注册,避免内存泄露
    protected void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber)
        );
    }
}
