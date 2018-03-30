package com.liuleshuai.mvpdagger.model;

import com.liuleshuai.mvpdagger.ui.base.BaseView;

/**
 * Created by LiuKuo at 2018/3/22
 */

public interface SplashContract {

    /**
     * activity的处理
     */
    interface View extends BaseView {

    }

    /**
     * presenter的处理
     */
    interface Presenter {
        void jump();

        void jumpDelay();
    }
}
