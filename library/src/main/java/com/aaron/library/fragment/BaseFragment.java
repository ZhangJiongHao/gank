package com.aaron.library.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;

/**
 * Created by Aaron on 2016/12/24.
 * Fragment 基类
 */

public abstract class BaseFragment extends Fragment {

    protected View mContentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, mContentView);
        initViews();
        initData();
        return mContentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(getPageNameForAnalysis());
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(getPageNameForAnalysis());
    }

    protected abstract void initData();

    protected abstract void initViews();

    /**
     * 获取用户统计的页面名称
     *
     * @return 默认为类名
     */
    protected String getPageNameForAnalysis() {
        return this.getClass().getName();
    }

    //get content view resource id
    abstract protected int getLayoutId();

}
