package com.aii.mvvm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.igexin.sdk.PushManager;

/**
 * Created by ChenNengHui on 2018/7/20.
 *
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@ @@@@@@    @@     @@   @@   @@
 * @@@@ @@@        @@ @   @@   @@   @@
 * @@@@ @@         @@  @  @@   @@@@@@@
 * @@@@ @@@        @@   @ @@   @@   @@
 * @@@@ @@@@@@    @@     @@   @@   @@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 */

public class BootBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("BootBroadcastReceiver","BootBroadcastReceiver");
        PushManager.getInstance().initialize(context, com.aii.mvvm.MPushService.class);
        PushManager.getInstance().registerPushIntentService(context, MIntentService.class);
    }
}
