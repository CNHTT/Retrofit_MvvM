package com.rx.retrofit.http.cookie;

import com.rx.retrofit.utils.CookieDbUtil;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

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

public class CookieInterceptor implements Interceptor {

    private CookieDbUtil dbUtil;

    //是否缓存
    private  boolean cache;

    //url
    private String url;

    public CookieInterceptor(boolean cache, String url) {
        dbUtil = CookieDbUtil.getInstance();
        this.cache = cache;
        this.url = url;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if(cache){
            ResponseBody body = response.body();
            BufferedSource source = body.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            Charset charset = Charset.defaultCharset();
            MediaType contentType = body.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            String bodyString = buffer.clone().readString(charset);
            CookieResulte resulte= dbUtil.queryCookieBy(url);
            long time=System.currentTimeMillis();
            /*保存和更新本地数据*/
            if(resulte==null){
                resulte  =new CookieResulte(url,bodyString,time);
                dbUtil.saveCookie(resulte);
            }else{
                resulte.setResulte(bodyString);
                resulte.setTime(time);
                dbUtil.updateCookie(resulte);
            }
        }
        return response;
    }
}
