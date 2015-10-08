package com.example.sandeep.codelearntwitterapp.models;

/**
 * Created by sandeep on 29/9/15.
 */
public class Tweet {
    private String id;
    private String body;
    private String title;

    public String getId(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setBody(String body){
        this.body = body;
    }

    public String getBody(){
        return this.body;
    }
}
