package com.liuleshuai.mvpdagger.model;

import com.liuleshuai.mvpdagger.ui.base.BaseView;

/**
 * Created by LiuKuo at 2018/3/23
 */

public interface SearchDialogContract {
    interface View extends BaseView {
        void showMovieData(String data);
        void showUsefulSites(String data);
    }

    interface Presenter {
        void getMovieData(int start, int count);
        void getUsefulSites();
    }
}
