package com.example.systemymobilnezad3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.UUID;

public class TaskListActivity extends SingleFragmentActivity {
    private EditText nameField;
    private Button dateButton;
    private CheckBox doneCheckBox;
    private Fragment fragment;
    public final String KEY_1="task_id";
    @Override
    public Fragment createFragment() {
        UUID taskId=(UUID)getIntent().getSerializableExtra(TaskListFragment.KEY_EXTRA_TASK_ID);
        return super.createFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fragment=createFragment();
        Log.d("todoapp","TaskListActivity");
        setContentView(R.layout.fragment_task);
        dateButton=findViewById(R.id.task_date);
        nameField=findViewById(R.id.task_name);
        doneCheckBox=findViewById(R.id.task_done);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskListActivity.this,MainActivity.class);
                int variable=0;
                intent.putExtra(KEY_1,variable);
                startActivity(intent);
            }
        });
    }
}