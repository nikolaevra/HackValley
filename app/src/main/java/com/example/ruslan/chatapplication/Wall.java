package com.example.ruslan.chatapplication;

/**
 * Created by Lincoln on 18/05/16.
 */
public class Wall {
    private String name;
    private String text_data;
    private int thumbnail;
    
    // TODO: change to proper date format
    private String time;

    public Wall() {}

    public Wall(String name, String text_data, int thumbnail, String time) {
        this.name = name;
        this.text_data = text_data;
        this.thumbnail = thumbnail;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText_data() {
        return text_data;
    }

    public void setText_data(String text_data) {
        this.text_data = text_data;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
