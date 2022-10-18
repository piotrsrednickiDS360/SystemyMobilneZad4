package com.example.systemymobilnezad3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {
    public Fragment fragment;
    @Override
    public Fragment createFragment() {
        UUID taskId=(UUID)getIntent().getSerializableExtra(TaskListFragment.KEY_EXTRA_TASK_ID);
        return super.createFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_task_list);
    }
}