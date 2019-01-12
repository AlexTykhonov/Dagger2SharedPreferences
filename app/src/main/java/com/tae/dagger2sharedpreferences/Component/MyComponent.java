package com.tae.dagger2sharedpreferences.Component;

import android.content.Context;

import com.tae.dagger2sharedpreferences.MainActivity;
import com.tae.dagger2sharedpreferences.Modules.RetrofitModule;
import com.tae.dagger2sharedpreferences.Qualifiers.ActivityContext;
import com.tae.dagger2sharedpreferences.Scope.ActivityScope;
import com.tae.dagger2sharedpreferences.Modules.SharedPrefModule;

import dagger.Component;

@ActivityScope
@Component (modules = {SharedPrefModule.class})

public interface MyComponent {

    @ActivityContext
    Context getContext();

void inject (MainActivity mainActivity);
        }
