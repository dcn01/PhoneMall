package com.zhiji.phonemall.di.qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import javax.inject.Scope;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/27
 *     desc   :
 * </pre>
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface PreferencesInfo {

}
