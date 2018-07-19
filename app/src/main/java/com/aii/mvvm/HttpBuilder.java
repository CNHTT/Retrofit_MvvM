package com.aii.mvvm;

import android.content.Context;

import com.rx.retrofit.listener.Error;
import com.rx.retrofit.listener.Progress;
import com.rx.retrofit.listener.Success;

import java.util.HashMap;
import java.util.Map;

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

public class HttpBuilder {
    private Map<String,String> headers = new HashMap<>();   //头部
    private Map<String,String> params = new HashMap<>();    //初
    private String url ;
    private String body;
    private Error errorCallBack;
    private Success successCallBack;
    private Progress progressListener;
    Object tah;
    Context mContext;
    boolean checkNetConnected =false;


    public HttpBuilder(String url) {
        setParams(url);
    }

    public void setParams(String params) {
    }
}

