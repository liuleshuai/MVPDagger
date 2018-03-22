package com.example.common.base;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.common.tools.ClassUtil;

/**
 * Created by LiuKuo at 2018/3/21
 */

public class BaseDialogFragment<T extends BasePresenter> extends DialogFragment implements BaseView {
    protected T mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        inject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    /**
     * 调用映射代码（此处无法使用Dagger，因为不在一个包下）
     */
    protected void inject() {
        mPresenter = ClassUtil.getT(this, 0);
    }
}
