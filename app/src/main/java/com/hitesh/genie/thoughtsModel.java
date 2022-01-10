package com.hitesh.genie;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Thoughts")
public class thoughtsModel {

    @PrimaryKey(autoGenerate = true)

    private int id;

    private String title;

    private String date;

    private String desc;

    public thoughtsModel(String title, String date, String desc) {
        this.title = title;
        this.date = date;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
