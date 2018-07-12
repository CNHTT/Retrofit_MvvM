package com.rx.retrofit.http;

/**
 * Created by ChenNengHui on 2018/7/12.
 * http交互处理类
 *
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@ @@@@@@    @@     @@   @@   @@
 * @@@@ @@@        @@ @   @@   @@   @@
 * @@@@ @@         @@  @  @@   @@@@@@@
 * @@@@ @@@        @@   @ @@   @@   @@
 * @@@@ @@@@@@    @@     @@   @@   @@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 */

public class HttpManager {
    private volatile static HttpManager INSTANCE;

    public HttpManager() {
    }

    private static HttpManager getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpManager.class) {
                INSTANCE = new HttpManager();
            }
        }
        return INSTANCE;
    }


}
