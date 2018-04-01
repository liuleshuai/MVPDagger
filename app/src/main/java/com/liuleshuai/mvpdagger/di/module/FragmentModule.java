package com.liuleshuai.mvpdagger.di.module;

import android.app.Activity;
import android.app.DialogFragment;
import android.support.v4.app.Fragment;

import com.liuleshuai.mvpdagger.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 67017 on 2018/4/1.
 */
@Module
public class FragmentModule {
    private Fragment fragment;
    private DialogFragment dialogFragment;

    public FragmentModule(Fragment fragment) {
        this.dialogFragment = null;
        this.fragment = fragment;
    }

    public FragmentModule(DialogFragment fragment) {
        this.fragment = null;
        this.dialogFragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        if (fragment == null) {
            return dialogFragment.getActivity();
        } else {
            return fragment.getActivity();
        }
    }
}
