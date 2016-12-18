package com.example.parkzan.finalexam;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parkzan.finalexam.DB.DatabaseHelper;

public class Res extends AppCompatActivity {
DatabaseHelper Database;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        final EditText name = (EditText)findViewById(R.id.editText_namef);
        final EditText username = (EditText)findViewById(R.id.editText2_username);
        final EditText pass = (EditText)findViewById(R.id.editText3_pass);
        Database = new DatabaseHelper(this);
        Database.open();

            Button button =(Button)findViewById(R.id.button_Aaaaaa) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namepp = name.getText().toString();
                String usernamea= username.getText().toString();
                String passwword = pass.getText().toString();


                db.execSQL("INSERT INTO " + Database.TABLE_NAME + " ("
                        + Database.COL_NAME + ", " + Database.COL_UserNAME
                        + ", " + Database.COL_PASS + ") VALUES ('" + namepp
                        + "', '" + usernamea + "', '" + passwword + "');");


            }
        });



    }
}
