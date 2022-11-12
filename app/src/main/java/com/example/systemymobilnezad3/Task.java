package com.example.systemymobilnezad3;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private Date date;
    private boolean done;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Task(Date new_date){
        //Log.d("todoapp","Task");
        id= UUID.randomUUID();
        date=new_date;
        done=false;
        name="";
        category=Category.HOME;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", done=" + done +
                ", category=" + category +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
