package com.example.parkzan.finalexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.parkzan.finalexam.User.User;
import com.example.parkzan.finalexam.User.UserDB;
import com.example.parkzan.finalexam.adapter.UserListAdapter;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

    }
}
