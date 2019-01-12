package com.tae.dagger2sharedpreferences;

import android.app.Activity;
import android.app.Application;

import com.tae.dagger2sharedpreferences.Component.ApplicationComponent;
import com.tae.dagger2sharedpreferences.Component.DaggerApplicationComponent;
import com.tae.dagger2sharedpreferences.Modules.ContextModule;

public class MyApplication extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    // используется для сборки модулей присутствующих в компоненте
        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);
    }

    //
    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }
    // используется для внедрения ApplicationComponent into Activity

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
