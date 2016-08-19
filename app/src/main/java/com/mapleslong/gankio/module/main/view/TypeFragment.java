package com.mapleslong.gankio.module.main.view;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.mapleslong.gankio.R;
import com.mapleslong.gankio.adapter.GankTypeCardAdapter;
import com.mapleslong.gankio.entity.GankDataEntity;
import com.mapleslong.gankio.module.base.view.BaseMvpFragment;
import com.mapleslong.gankio.module.main.presenter.TypePresenter;
import com.mapleslong.gankio.utils.ConvertUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TypeFragment extends BaseMvpFragment<TypeFragmentView, TypePresenter> implements
        TypeFragmentView {
    private static final String ARG_PARAM1 = "type";
    @BindView(R.id.rv_list)
    XRecyclerView rvList;
    private String mCategory;
    private View rootView;
    private GankTypeCardAdapter mGankTypeCardAdapter;
    private List<GankDataEntity> mDatas;
    private int curPage = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategory = getArguments().getString(ARG_PARAM1);
        }
        initVariables();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_type, container, false);
        ButterKnife.bind(this, rootView);
        resetDatas();
        initViews();
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ARG_PARAM1, mCategory);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            mCategory = ConvertUtil.toString(savedInstanceState.getString(ARG_PARAM1), "");//避免为NULL
        }
    }

    @Override
    public void initVariables() {
        mDatas = new ArrayList<>();
    }

    @Override
    public void initViews() {
        initRecyclerView();
        presenter.getTypeGankList();
    }

    private void initRecyclerView() {
        rvList.setPullRefreshEnabled(true);
        rvList.setLoadingMoreEnabled(true);
        rvList.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                resetDatas();
                presenter.getTypeGankList();
            }

            @Override
            public void onLoadMore() {
                presenter.getTypeGankList();
            }
        });
    }

    @Override
    protected TypePresenter initPresenter() {
        return new TypePresenter();
    }

    public static TypeFragment newInstance(String type) {
        TypeFragment fragment = new TypeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String getCategory() {
        return mCategory;
    }

    @Override
    public int getCurPage() {
        return curPage;
    }

    @Override
    public void addOnePage() {
        curPage++;
    }

    @Override
    public void makeUpDatas(List<GankDataEntity> datas) {
        mDatas.addAll(datas);
    }

    @Override
    public void notifyAdapter() {
        if (mGankTypeCardAdapter == null) {
            mGankTypeCardAdapter = new GankTypeCardAdapter(mDatas);
            rvList.setLayoutManager(new LinearLayoutManager(mActivity));
            rvList.setAdapter(mGankTypeCardAdapter);
        }
        // TODO: 16/8/19 //此处可以优化成动画效果以及item逐个优化不需要整个重新排列
        mGankTypeCardAdapter.notifyDataSetChanged();
        rvList.refreshComplete();
        rvList.loadMoreComplete();
    }

    @Override
    public void resetDatas() {
        curPage = 1;
        mDatas.clear();
        if (mGankTypeCardAdapter != null) {
            mGankTypeCardAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroyView() {
        mGankTypeCardAdapter = null;
        super.onDestroyView();
    }
}
