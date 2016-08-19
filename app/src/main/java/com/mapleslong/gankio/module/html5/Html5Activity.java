package com.mapleslong.gankio.module.html5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mapleslong.gankio.R;
import com.mapleslong.gankio.manager.ActivityStackManager;
import com.mapleslong.gankio.module.base.presenter.BasePresenter;
import com.mapleslong.gankio.module.base.view.BaseMvpActivity;
import com.mapleslong.gankio.module.base.view.BaseView;
import com.mapleslong.gankio.utils.ConvertUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Html5Activity extends BaseMvpActivity<BaseView, BasePresenter<BaseView>> {
    @BindView(R.id.webview)
    WebView webview;
    private Intent mIntent;
    private String url;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html5);
        ButterKnife.bind(this);
        initVariables();
        initViews();
        initLoadUrl();
    }

    @Override
    protected void onDestroy() {
        webview.removeAllViews();
        webview.destroy();
        ActivityStackManager.getInstance().finishActivity();
        super.onDestroy();
    }

    @Override
    public void initVariables() {
        ActivityStackManager.getInstance().addActivity(this);
        mIntent = getIntent();
        url = ConvertUtil.toString(mIntent.getStringExtra("url"), "");
        title = ConvertUtil.toString(mIntent.getStringExtra("title"), "视频");
    }

    @Override
    public void initViews() {
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);//设置使支持缩放
        webSettings.setUseWideViewPort(true);  //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        webSettings.setLoadsImagesAutomatically(true);  //支持自动加载图片
        webSettings.setAllowFileAccess(true);//设置可以访问文件
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hideLoading();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        //WebView加载web资源

    }

    private void initLoadUrl() {
        showLoading();
        webview.loadUrl(url);
    }


    @Override
    protected BasePresenter<BaseView> initPresenter() {
        return new BasePresenter<>();
    }

}
