package com.aii.mvvm;

import android.app.Application;

import com.rx.retrofit.RxRetrofitApp;

/**
 * Created by ChenNengHui on 2018/7/13.
 *
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@ @@@@@@    @@     @@   @@   @@
 * @@@@ @@@        @@ @   @@   @@   @@
 * @@@@ @@         @@  @  @@   @@@@@@@
 * @@@@ @@@        @@   @ @@   @@   @@
 * @@@@ @@@@@@    @@     @@   @@   @@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 */

public class App  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RxRetrofitApp.init(this,BuildConfig.DEBUG);
    }
}
