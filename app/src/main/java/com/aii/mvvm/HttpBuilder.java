package com.aii.mvvm;

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
}
