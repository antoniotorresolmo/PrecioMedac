package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    RadioButton rBtnDam;
    RadioButton rBtnDaw;
    RadioButton rBtnMorning;
    RadioButton rBtnTarde;
    Switch swIva;
    TextView lblPrecio;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rBtnDam = findViewById(R.id.rBtnDam);
        rBtnDaw = findViewById(R.id.rBtnDaw);
        rBtnMorning = findViewById(R.id.rBtnMorning);
        rBtnTarde = findViewById(R.id.rBtnTarde);
        swIva = findViewById(R.id.swIva);
        lblPrecio = findViewById(R.id.lblPrecio);

        calcular();

        // RG Modulo
        rBtnDam.setOnClickListener(v -> {
            calcular();
        });
        rBtnDaw.setOnClickListener(v -> {
            calcular();
        });
        findViewById(R.id.rBtnAsir).setOnClickListener(v -> {
            calcular();
        });

        // RG Turno
        rBtnMorning.setOnClickListener(v -> {
            calcular();
        });
        rBtnTarde.setOnClickListener(v -> {
            calcular();
        });
        findViewById(R.id.rBtnOnline).setOnClickListener(v -> {
            calcular();
        });

        // IVA
        swIva.setOnClickListener(v -> {
            calcular();
        });

    }

    private void calcular(){

        float fPrecio = 0;

        // RadioGroup Modulo
        if(rBtnDam.isChecked()){
            fPrecio += 1000;
        }else if(rBtnDaw.isChecked()){
            Toast.makeText(this, "Vaya tieso", Toast.LENGTH_SHORT).show();
            fPrecio += 1200;
        }else{
            fPrecio += 750;
        }

        // RadioGroup Turno
        if(rBtnMorning.isChecked()){
            fPrecio += 600;
        }else if(rBtnTarde.isChecked()){
            fPrecio += 400;
        }else{
            fPrecio += 200;
        }

        // Comprobar IVA
        if(swIva.isChecked()){
            fPrecio *= 1.21;
        }

        lblPrecio.setText(String.valueOf(fPrecio) + "€");

    }
}