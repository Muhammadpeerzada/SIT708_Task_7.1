package com.example.lostandfound.model;

public class Post {
    private int post_id;
    private String postName;
    private String phoneNumber;
    private String description;
    private String state;
    private String date;
    private String location;

    public Post() {
    }

    public Post(String postName, String phoneNumber, String description, String state, String date, String location) {

        this.postName = postName;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.state = state;
        this.date = date;
        this.location = location;
    }

    public Post(int post_id, String postName, String phoneNumber, String description, String state, String date, String location) {
        this.post_id = post_id;
        this.postName = postName;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.state = state;
        this.date = date;
        this.location = location;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
