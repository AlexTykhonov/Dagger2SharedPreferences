package com.tae.dagger2sharedpreferences.Modules;

import android.content.Context;

import com.tae.dagger2sharedpreferences.Scope.ActivityScope;
import com.tae.dagger2sharedpreferences.Scope.ApplicationScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    public Context getContext() {
        return context;
    }
}
