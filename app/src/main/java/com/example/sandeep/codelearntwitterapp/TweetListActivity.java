package com.example.sandeep.codelearntwitterapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.sandeep.codelearntwitterapp.models.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetListActivity extends ListActivity {

    //private ListView tweetListView;
    private String[] stringArray;
    private ArrayAdapter tweetItemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);

        /*stringArray = new String[10];
        for(int i=0;i<10;i++){
            stringArray[i] = "String " + i;
        }*/
        //tweetItemArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,stringArray);

        List<Tweet> tweets= new ArrayList<Tweet>();

        for(int i = 0; i < 20; i++){
            Tweet tweet = new Tweet();
            tweet.setTitle("Header for Tweet "+i);
            tweet.setBody("Some random text for the body of tweet "+i);
            tweets.add(tweet);
        }

        tweetItemArrayAdapter = new TweetAdapter(this,tweets);

        //tweetListView = (ListView) findViewById(R.id.tweetList);
        //tweetListView.setAdapter(tweetItemArrayAdapter);
        setListAdapter(tweetItemArrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position,long id){
        //TextView t = (TextView) v.findViewById(R.id.tweetTitle);
        //t.setText("Tweet Clicked");

        Intent intent = new Intent(this, TweetDetailActivity.class);
        startActivity(intent);
    }


}
