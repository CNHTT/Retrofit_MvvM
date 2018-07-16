package com.rx.retrofit.listener;

/**
 * Created by ChenNengHui on 2018/7/16.
 *      下载进度返回
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@ @@@@@@    @@     @@   @@   @@
 * @@@@ @@@        @@ @   @@   @@   @@
 * @@@@ @@         @@  @  @@   @@@@@@@
 * @@@@ @@@        @@   @ @@   @@   @@
 * @@@@ @@@@@@    @@     @@   @@   @@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 */
@FunctionalInterface
public interface Progress {
    void progress(float p);
}
