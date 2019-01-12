package com.tae.dagger2sharedpreferences.Component;

import android.content.Context;

import com.tae.dagger2sharedpreferences.BbcInter;
import com.tae.dagger2sharedpreferences.Modules.ContextModule;
import com.tae.dagger2sharedpreferences.Modules.RetrofitModule;
import com.tae.dagger2sharedpreferences.MyApplication;
import com.tae.dagger2sharedpreferences.Qualifiers.ApplicationContext;
import com.tae.dagger2sharedpreferences.Scope.ApplicationScope;

import dagger.Component;
import retrofit2.Retrofit;

@ApplicationScope
@Component (modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    @ApplicationContext
    public Context getContext();

    public BbcInter getApiInterface();

    public void injectApplication (MyApplication myApplication);

}
