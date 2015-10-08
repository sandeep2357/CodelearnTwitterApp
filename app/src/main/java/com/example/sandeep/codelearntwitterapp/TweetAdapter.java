package com.example.sandeep.codelearntwitterapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sandeep.codelearntwitterapp.models.Tweet;

import java.util.List;

/**
 * Created by sandeep on 23/9/15.
 */
public class TweetAdapter extends ArrayAdapter<Tweet> {

    private LayoutInflater inflater;

    public TweetAdapter(Activity activity, List<Tweet> items){
        super(activity,R.layout.row_tweet, items);
        inflater = activity.getWindow().getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent){
        View view;
        view = inflater.inflate(R.layout.row_tweet,parent,false);

        Tweet twt = getItem(position);

        TextView title = (TextView) view.findViewById(R.id.tweetTitle);
        title.setText(twt.getTitle());

        TextView body = (TextView) view.findViewById(R.id.textView2);
        body.setText(twt.getBody());

        return view;
    }
}
