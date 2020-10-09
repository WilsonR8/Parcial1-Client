package com.will.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.gson.Gson;
import com.will.parcial1.model.Coordenada;

public class Control extends AppCompatActivity implements OnClickListener {

    private Button lbtn;
    private Button dbtn;
    private Button ubtn;
    private Button rbtn;
    private Button cbtn;
    int posx=250;
    int posy=250;
    private String msg;
    private TCPSingleton tcp;
    private Gson gson ;
    private Coordenada coordenada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        lbtn = findViewById(R.id.lbtn);
        dbtn = findViewById(R.id.dbtn);
        ubtn = findViewById(R.id.ubtn);
        rbtn = findViewById(R.id.rbtn);
        cbtn = findViewById(R.id.cbtn);

        lbtn.setOnClickListener(this);
        dbtn.setOnClickListener(this);
        ubtn.setOnClickListener(this);
        rbtn.setOnClickListener(this);
        cbtn.setOnClickListener(this);

        tcp = TCPSingleton.getInstance();

    }

   public void onClick (View view){
        switch(view.getId()){
            case R.id.ubtn:
                gson = new Gson();
                posy-=1;

                coordenada = new Coordenada(posx,posy);
                msg=gson.toJson(coordenada);
                tcp.sendMessage(msg);

                break;

            case R.id.dbtn:
                gson = new Gson();
                posy+=1;

                coordenada = new Coordenada(posx,posy);
                msg=gson.toJson(coordenada);
                tcp.sendMessage(msg);

                break;

            case R.id.lbtn:
                gson = new Gson();
                posx-=1;

                coordenada = new Coordenada(posx,posy);
                msg=gson.toJson(coordenada);
                tcp.sendMessage(msg);

                break;

            case R.id.rbtn:
                gson = new Gson();
                posx+=1;

                coordenada = new Coordenada(posx,posy);
                msg=gson.toJson(coordenada);
                tcp.sendMessage(msg);

                break;

        }
   }




}