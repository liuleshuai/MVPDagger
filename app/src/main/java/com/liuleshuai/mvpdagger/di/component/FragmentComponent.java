package com.liuleshuai.mvpdagger.di.component;

import android.app.Activity;

import com.liuleshuai.mvpdagger.di.module.FragmentModule;
import com.liuleshuai.mvpdagger.di.scope.FragmentScope;
import com.liuleshuai.mvpdagger.ui.fragment.SearchDialogFragment;
import com.liuleshuai.mvpdagger.ui.fragment.WeChatFragment;

import dagger.Component;

/**
 * Created by 67017 on 2018/4/1.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

    void inject(WeChatFragment weChatFragment);

    void inject(SearchDialogFragment searchDialogFragment);


}
