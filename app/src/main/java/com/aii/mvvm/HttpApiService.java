package com.aii.mvvm;


import com.rx.retrofit.api.BaseResultEntity;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

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

public interface HttpApiService {


    /**
     * get请求
     *
     * @param url     地址
     * @param headers 头部
     * @param params
     * @return
     */
    @Streaming
    @GET
    Observable<BaseResultEntity<String>> get(@Url String url, @HeaderMap Map<String, String> headers, @QueryMap Map<String, String> params);
    /**
     * get请求
     *
     * @param url     地址
     * @param headers 头部
     * @param params
     * @return
     */
    @Streaming
    @GET
    Observable<BaseResultEntity<String>> download(@Url String url, @HeaderMap Map<String, String> headers, @QueryMap Map<String, String> params);

    @FormUrlEncoded
    @POST
    Observable<BaseResultEntity<String>> post(@Url String url, @HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST
    Observable<BaseResultEntity<String>> postBody(@Url String url, @HeaderMap Map<String, String> headers, @Body String body);

    @FormUrlEncoded
    @POST
    Observable<BaseResultEntity<String>> postFile(@Url String url, @HeaderMap Map<String, String> headers, @Part MultipartBody.Part file);

}
