package com.vinaymaneti.wizelinetwitterapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vinaymaneti.wizelinetwitterapp.Model.Timeline;
import com.vinaymaneti.wizelinetwitterapp.Model.User;
import com.vinaymaneti.wizelinetwitterapp.R;
import com.vinaymaneti.wizelinetwitterapp.Utils.DividerItemDecoration;
import com.vinaymaneti.wizelinetwitterapp.Utils.RetrofitUtils;
import com.vinaymaneti.wizelinetwitterapp.adapter.TweetArrayAdapter;
import com.vinaymaneti.wizelinetwitterapp.listener.TimelineApi;
import com.vinaymaneti.wizelinetwitterapp.listener.UserApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.profile_image)
    ImageView profileImage;

    @BindView(R.id.plus_btn)
    ImageView plusBtn;

    @BindView(R.id.userName)
    TextView userName;

    @BindView(R.id.userDesp)
    TextView userDesp;

    @BindView(R.id.settingBtn)
    Button settingsBtn;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private UserApi mUserApi;
    private TimelineApi mTimelineApi;
    private TweetArrayAdapter mTweetArrayAdapter;
    private List<Timeline> timelineList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mUserApi = RetrofitUtils.get().create(UserApi.class);
        mUserApi.getUserDetails().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response != null) {
                    Log.d("reponse", response.body().toString());
                    String userDesp = response.body().getDescription();
                    String userName = response.body().getName();
                    String userScreenName = response.body().getScreenName();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Failure", t.getMessage().toString());
            }
        });

        mTimelineApi = RetrofitUtils.get().create(TimelineApi.class);
        mTimelineApi.getTimelineDetails().enqueue(new Callback<List<Timeline>>() {
            @Override
            public void onResponse(Call<List<Timeline>> call, Response<List<Timeline>> response) {
                if (response != null) {
                    Log.d("reponse", response.body().toString());
                    timelineList = response.body();
                    mTweetArrayAdapter = new TweetArrayAdapter(MainActivity.this, timelineList);
                    mRecyclerView.setAdapter(mTweetArrayAdapter);
                    RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL_LIST);
                    mRecyclerView.addItemDecoration(itemDecoration);
                    //set the layout type for the recycler view
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }
            }

            @Override
            public void onFailure(Call<List<Timeline>> call, Throwable t) {
                Log.d("Failure", t.getMessage().toString());
            }
        });

    }
}
