package com.example.systemymobilnezad3;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();

    private final List<Task> tasks;

    public static TaskStorage getInstance(){
        return taskStorage;
    }

    public void addTask(Task task)
    {
        tasks.add(task);
    }
    private TaskStorage(){
        Log.d("todoapp","TaskStorage");
        tasks=new ArrayList<>();
        for(int i=1; i<=100;i++){
            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, i);
            dt = c.getTime();
            Task task = new Task(dt);
            task.setName("Zadanie "+i);
            task.setDone(i % 3 == 0);
            if(i%3==0){
                task.setCategory(Category.STUDIES);
            }
            else{
                task.setCategory(Category.HOME);
            }
            tasks.add(task);
        }
    }
    public Task getTask(UUID id){
        Task taskReturned = null;
        for(int i=0;i<tasks.size();i++){
            if(tasks.get(i).getId().equals(id)){
                taskReturned= tasks.get(i);
                break;
            }
        }
        return taskReturned;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
