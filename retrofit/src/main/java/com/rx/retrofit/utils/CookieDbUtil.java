package com.rx.retrofit.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.rx.retrofit.RxRetrofitApp;
import com.rx.retrofit.http.cookie.CookieResulte;
import com.rx.retrofit.http.cookie.CookieResulteDao;
import com.rx.retrofit.http.cookie.DaoMaster;
import com.rx.retrofit.http.cookie.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by ChenNengHui on 2018/7/10.
 *
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@ @@@@@@    @@     @@   @@   @@
 * @@@@ @@@        @@ @   @@   @@   @@
 * @@@@ @@         @@  @  @@   @@@@@@@
 * @@@@ @@@        @@   @ @@   @@   @@
 * @@@@ @@@@@@    @@     @@   @@   @@
 * 数据缓存
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 */

public class CookieDbUtil {
    private static CookieDbUtil db;
    private final static String dbName = "okhttp_db";
    private Context context;
    private DaoMaster.DevOpenHelper openHelper;

    public CookieDbUtil() {
        context = RxRetrofitApp.getApplication();
        openHelper = new DaoMaster.DevOpenHelper(context, dbName);
    }


    public static CookieDbUtil getInstance() {
        if (db == null)
            synchronized (CookieDbUtil.class) {
                if (db == null) db = new CookieDbUtil();
            }
        return db;
    }

    /**
     *   获取可读数据库
     * @return
     */
    private SQLiteDatabase getReadableDatabase(){
        if (openHelper==null) openHelper = new DaoMaster.DevOpenHelper(context,dbName);
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }
    private SQLiteDatabase getWritableDatabase(){
        if (openHelper==null) openHelper = new DaoMaster.DevOpenHelper(context,dbName);
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }


    public void saveCookie(CookieResulte info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieResulteDao downInfoDao = daoSession.getCookieResulteDao();
        downInfoDao.insert(info);
    }

    public void updateCookie(CookieResulte info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieResulteDao downInfoDao = daoSession.getCookieResulteDao();
        downInfoDao.update(info);
    }

    public void deleteCookie(CookieResulte info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieResulteDao downInfoDao = daoSession.getCookieResulteDao();
        downInfoDao.delete(info);
    }


    public CookieResulte queryCookieBy(String  url) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieResulteDao downInfoDao = daoSession.getCookieResulteDao();
        QueryBuilder<CookieResulte> qb = downInfoDao.queryBuilder();
        qb.where(CookieResulteDao.Properties.Url.eq(url));
        List<CookieResulte> list = qb.list();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    public List<CookieResulte> queryCookieAll() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieResulteDao downInfoDao = daoSession.getCookieResulteDao();
        QueryBuilder<CookieResulte> qb = downInfoDao.queryBuilder();
        return qb.list();
    }
}