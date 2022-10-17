package com.example.systemymobilnezad3;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.UUID;

public class TaskFragment extends Fragment {
    private static final String ARG_TASK_ID = "id";
    private Task task;
    private EditText nameField;
    private Button dateButton;
    private CheckBox doneCheckBox;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.task=new Task();
        UUID taskId=(UUID)getArguments().getSerializable(ARG_TASK_ID);
        task=TaskStorage.getInstance().getTask(taskId);

        dateButton=getView().findViewById(R.id.task_date);
        nameField= getView().findViewById(R.id.task_name);
        doneCheckBox= getView().findViewById(R.id.task_done);
        nameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                task.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dateButton.setText(task.getDate().toString());
        dateButton.setEnabled(false);
        doneCheckBox.setText(task.getDate().toString());
        doneCheckBox.setOnCheckedChangeListener((buttonView,isChecked) -> task.setDone(isChecked));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container != null) {
            EditText nameField = container.findViewById(R.id.task_name);
            if (nameField != null) {

                nameField.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        task.setName(s.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
            Button dateButton = container.findViewById(R.id.task_date);
            if (dateButton != null) {
                dateButton.setText(task.getDate().toString());
                dateButton.setEnabled(false);
            }
            CheckBox doneCheckbox = container.findViewById(R.id.task_done);
            if (doneCheckbox != null) {
                doneCheckbox.setChecked(task.isDone());
                doneCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    task.setDone(isChecked);
                });
            }
        }
        return inflater.inflate(R.layout.fragment_task,container,false);
    }
    public static TaskFragment newInstance(UUID taskId){
        Bundle bundle=new Bundle();
        bundle.putSerializable(ARG_TASK_ID,taskId);
        TaskFragment taskFragment = new TaskFragment();
        taskFragment.setArguments(bundle);
        return taskFragment;
    }

}
