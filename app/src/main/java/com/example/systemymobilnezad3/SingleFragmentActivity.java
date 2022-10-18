package com.example.systemymobilnezad3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    public Fragment createFragment(){

        setContentView(R.layout.fragment_task);
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if(fragment==null){
            fragment= new TaskFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
        return fragment;
    }
}
