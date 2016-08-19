package com.mapleslong.gankio.module.main.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;

import com.mapleslong.gankio.R;
import com.mapleslong.gankio.manager.ActivityStackManager;
import com.mapleslong.gankio.module.base.view.BaseMvpActivity;
import com.mapleslong.gankio.module.main.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity<MainView, MainPresenter> implements MainView {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initVariables();
        initViews();
    }

    @Override
    public void initVariables() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        ActivityStackManager.getInstance().addActivity(this);
    }

    @Override
    public void initViews() {
        mFragmentTransaction.replace(R.id.fl_content, new MainFragment());
        mFragmentTransaction.commit();
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onDestroy() {
        ActivityStackManager.getInstance().finishActivity();
        super.onDestroy();
    }

}
