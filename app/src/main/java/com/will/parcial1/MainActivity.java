package com.will.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import com.will.parcial1.model.User;


public class MainActivity extends AppCompatActivity {




    private EditText usertxt;
    private Button signinbtn;
    private TCPSingleton tcp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usertxt = findViewById(R.id.usertxt);
        signinbtn = findViewById(R.id.signinbtn);

        tcp = TCPSingleton.getInstance();
        tcp.start();

        signinbtn.setOnClickListener(
                (v) -> {

                    Gson gson = new Gson();

                    String id = usertxt.getText().toString();
                    String description = "Ellipse name";

                    User name = new User(id);

                    String json = gson.toJson(name);
                    Log.e(">>>",""+json);
                    tcp.sendMessage(json);

                    Intent i = new Intent(this,Control.class);
                    startActivity(i);

                }
        );


    }








}
