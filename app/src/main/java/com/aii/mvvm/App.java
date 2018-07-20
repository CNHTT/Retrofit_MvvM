package com.aii.mvvm;

import android.app.Application;

import com.igexin.sdk.PushManager;
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

        // 注册 intentService 后 PushDemoReceiver 无效, sdk 会使用 DemoIntentService 传递数据,
        // AndroidManifest 对应保留一个即可(如果注册 DemoIntentService, 可以去掉 PushDemoReceiver, 如果注册了
        // IntentService, 必须在 AndroidManifest 中声明)
        PushManager.getInstance().initialize(this, com.aii.mvvm.MPushService.class);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), MIntentService.class);
    }
}
