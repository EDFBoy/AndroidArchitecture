package com.fly.mvpcleanarchitecture.app;

import android.support.multidex.MultiDexApplication;
import com.fly.mvpcleanarchitecture.BuildConfig;
import com.fly.mvpcleanarchitecture.app.config.Constants;
import com.fly.mvpcleanarchitecture.app.dependencyinjection.ApiServiceModule;
import com.fly.mvpcleanarchitecture.app.dependencyinjection.ApplicationComponent;
import com.fly.mvpcleanarchitecture.app.dependencyinjection.ApplicationModule;
import com.fly.mvpcleanarchitecture.app.dependencyinjection.DaggerApplicationComponent;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import org.litepal.LitePal;

/**
 * Created by Administrator on 2016/8/3.
 */
public class MvpCleanApplication extends MultiDexApplication {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).apiServiceModule(new
                ApiServiceModule(Constants.ServerUrl)).build();
        LitePal.initialize(this);
        if (BuildConfig.IS_DEBUG) {
            Logger.init(BuildConfig.LOG_TAG).logLevel(LogLevel.FULL);
        } else {
            Logger.init(BuildConfig.LOG_TAG).logLevel(LogLevel.NONE);
        }
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
