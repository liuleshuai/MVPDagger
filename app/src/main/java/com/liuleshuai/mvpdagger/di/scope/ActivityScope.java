package com.liuleshuai.mvpdagger.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author liukuo
 * @date 2018/3/30
 */

@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
