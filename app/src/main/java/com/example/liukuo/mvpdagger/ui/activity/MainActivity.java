package com.example.liukuo.mvpdagger.ui.activity;

import android.graphics.Color;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.common.base.BaseActivity;
import com.example.liukuo.mvpdagger.R;
import com.example.liukuo.mvpdagger.model.MainContract;
import com.example.liukuo.mvpdagger.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.button)
    Button button;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        Log.d("LK", "111");
        mPresenter.changeColor();
    }

    @Override
    public void setColor() {
        button.setBackgroundColor(Color.BLUE);
    }
}
