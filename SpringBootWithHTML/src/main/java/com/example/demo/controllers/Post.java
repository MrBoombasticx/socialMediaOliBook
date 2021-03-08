package com.example.demo.controllers;

public class Post {
    String title;
    String content;
    String date;
    String privacy;

    public Post(String title, String content, String date, String privacy){
        this.title = title;
        this.content = content;
        this.date = date;
        this.privacy = privacy;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getPrivacy() {
        return privacy;
    }

    @Override
    public String toString(){
        return "DATE: " + date + " | " +
                "TITLE: " + title + " | " +
                "CONTENT: " + content + " | " +
                "PRIVACY: " + privacy;
    }

}
