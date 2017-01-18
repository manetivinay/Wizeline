package com.vinaymaneti.wizelinetwitterapp.listener;

import com.vinaymaneti.wizelinetwitterapp.Model.Timeline;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vinay on 18/01/17.
 */

public interface TimelineApi {
    //api/statuses/user_timeline
    @GET("statuses/user_timeline")
    Call<List<Timeline>> getTimelineDetails();
}
