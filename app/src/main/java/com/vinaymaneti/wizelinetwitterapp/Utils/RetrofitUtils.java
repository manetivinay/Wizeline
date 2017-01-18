package com.vinaymaneti.wizelinetwitterapp.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vinay on 18/01/17.
 */

public class RetrofitUtils {

    public static Retrofit get() {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                //.client(client())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

//    private static OkHttpClient client() {
//        return new OkHttpClient.Builder()
//                .readTimeout(10, TimeUnit.SECONDS)
//                .connectTimeout(10, TimeUnit.SECONDS)
//                .build();
//    }
}
