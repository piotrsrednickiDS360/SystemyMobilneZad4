package com.example.systemymobilnezad3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {
    public Fragment fragment;
    public TextView taskItemName;
    public TextView taskItemDate;
    public List<Task> taskStorage;
    @Override
    public Fragment createFragment() {
        UUID taskId=(UUID)getIntent().getSerializableExtra(TaskListFragment.KEY_EXTRA_TASK_ID);
        return super.createFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("todoapp","MainActivity");
        taskStorage=TaskStorage.getInstance().getTasks();

        setContentView(R.layout.fragment_task_list);
        for(int i=0;i<taskStorage.size();i++){

            taskItemName=findViewById(R.id.task_item_name);
            taskItemDate=findViewById(R.id.task_item_date);
        }
    }
}