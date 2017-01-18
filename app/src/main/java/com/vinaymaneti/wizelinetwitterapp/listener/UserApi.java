package com.vinaymaneti.wizelinetwitterapp.listener;

import com.vinaymaneti.wizelinetwitterapp.Model.User;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vinay on 18/01/17.
 */

public interface UserApi {
    @GET("user")
    Call<User> getUserDetails();
}
