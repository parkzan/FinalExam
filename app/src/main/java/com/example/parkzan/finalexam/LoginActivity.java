package com.example.parkzan.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parkzan.finalexam.DB.DatabaseHelper;
import com.example.parkzan.finalexam.adapter.UserListAdapter;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    UserListAdapter userListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       mDatabaseHelper = new DatabaseHelper(this);
       mDatabaseHelper.open();



        final EditText Username = (EditText) findViewById(R.id.e_user);
       final  EditText PassWord = (EditText) findViewById(R.id.e_pass);
        Button button =(Button)findViewById(R.id.button_LOG);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=Username.getText().toString();
                String password=PassWord.getText().toString();
                String ch = mDatabaseHelper.getSinlgeEntry(userName);
                if(password.equals(ch))
                {
                    Toast.makeText(LoginActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("USER",userName);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(LoginActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }

            }
        });
        Button buttons =(Button)findViewById(R.id.button_RES);
        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,Res.class);
                startActivity(intent);
            }
        });








    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_show_list) {
            Intent intent = new Intent(this, UserListActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
