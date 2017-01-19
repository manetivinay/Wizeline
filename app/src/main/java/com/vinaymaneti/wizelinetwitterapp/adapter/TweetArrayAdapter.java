package com.vinaymaneti.wizelinetwitterapp.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;
import com.vinaymaneti.wizelinetwitterapp.Model.Timeline;
import com.vinaymaneti.wizelinetwitterapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vinay on 18/01/17.
 */

public class TweetArrayAdapter extends RecyclerView.Adapter<TweetArrayAdapter.TweetViewHolder> {
    private List<Timeline> mTweetList;
    private Context mContext;

    public TweetArrayAdapter(Context context, List<Timeline> timelineList) {
        this.mContext = context;
        this.mTweetList = timelineList;
    }

    @Override
    public TweetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        //Inflate the custom layout
        View tweetView = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        // return the new holder instance
        TweetViewHolder tweetViewHolder = new TweetViewHolder(tweetView);
        return tweetViewHolder;
    }

    @Override
    public void onBindViewHolder(final TweetViewHolder holder, int position) {
        //get the data model based on the position
        final Timeline tweet = mTweetList.get(position);
//        holder.profileImage.setImageResource(android.R.color.transparent);
        Picasso.with(mContext)
                .load(tweet.getProfile_image_url())
                .placeholder(R.drawable.placholder_wiz)
                .into(holder.profileImage);
        holder.userNameTv.setText(tweet.getUser().getName());
        holder.bodyTv.setText(tweet.getTextDes());
        holder.likeCount.setText(tweet.getFavouritesCount());
        holder.userNameTwitter.setText("@" + tweet.getUser().getScreenName());
        holder.likeIv.setOnClickListener(new View.OnClickListener() {
            int buttonClickPosition = 0;

            @Override
            public void onClick(View v) {
                if (buttonClickPosition == 0) {
                    holder.likeIv.setImageResource(R.drawable.ic_like_enabled);
                    buttonClickPosition = 1;
//                    holder.likeCount.setText(String.valueOf(Integer.parseInt(tweet.getFavouritesCount()) + 1));
                } else {
                    holder.likeIv.setImageResource(R.drawable.ic_like);
                    buttonClickPosition = 0;
                   // holder.likeCount.setText(String.valueOf(Integer.parseInt(tweet.getFavouritesCount())));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTweetList.size();
    }

    public class TweetViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.profileImage)
        RoundedImageView profileImage;

        @BindView(R.id.userNameTv)
        AppCompatTextView userNameTv;

        @BindView(R.id.userNameTwitter)
        AppCompatTextView userNameTwitter;

        @BindView(R.id.bodyTv)
        AppCompatTextView bodyTv;

        @BindView(R.id.view)
        View view;

        @BindView(R.id.replyIv)
        AppCompatImageView replyIv;

        @BindView(R.id.reTweetIv)
        AppCompatImageView reTweetIv;

        @BindView(R.id.retweetCount)
        AppCompatTextView retweetCount;

        @BindView(R.id.likeIv)
        AppCompatImageView likeIv;

        @BindView(R.id.likeCount)
        AppCompatTextView likeCount;

        @BindView(R.id.mailIv)
        AppCompatImageView mailIv;

        @BindView(R.id.createdAtTv)
        AppCompatTextView createdAtTv;


        public TweetViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
