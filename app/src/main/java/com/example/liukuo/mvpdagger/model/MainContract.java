package com.example.liukuo.mvpdagger.model;

import com.example.common.base.BaseView;

/**
 * Created by LiuKuo at 2018/3/22
 */

public interface MainContract {

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
