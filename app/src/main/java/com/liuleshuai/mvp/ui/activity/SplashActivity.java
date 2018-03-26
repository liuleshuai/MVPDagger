package com.liuleshuai.mvp.ui.activity;

import android.graphics.Color;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.liuleshuai.common.base.BaseActivity;
import com.liuleshuai.mvp.R;
import com.liuleshuai.mvp.model.SplashContract;
import com.liuleshuai.mvp.presenter.SplashPresenter;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/activity/splash")
public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.button)
    Button button;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
    }

    @Override
    protected void initEventAndData() {
        mPresenter.jump();
        finish();
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        Log.d("LK", "111");
        mPresenter.changeColor();
        ARouter.getInstance().build("/activity/main").navigation();
    }

    @Override
    public void setColor() {
        button.setBackgroundColor(Color.BLUE);
    }
}
