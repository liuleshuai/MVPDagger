package com.liuleshuai.mvp.model;

import com.liuleshuai.common.base.BaseView;

/**
 * Created by LiuKuo at 2018/3/22
 */

public interface SplashContract {

    /**
     * activity的处理
     */
    interface View extends BaseView {
        void setColor();

    }

    /**
     * presenter的处理
     */
    interface Presenter {
        void changeColor();
    }
}
