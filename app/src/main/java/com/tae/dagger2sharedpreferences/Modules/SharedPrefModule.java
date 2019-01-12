package com.tae.dagger2sharedpreferences.Modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.tae.dagger2sharedpreferences.Scope.ActivityScope;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefModule {

    Context context;

    public SharedPrefModule(Context context) {
        this.context = context;
    }

    @Provides
    @ActivityScope
    public Context providesContext(){
        return this.context;

    }

    @Provides
    @ActivityScope
    public SharedPreferences providesSharedPreferences(Context context)
    { return PreferenceManager.getDefaultSharedPreferences(context);

}
}
