package com.baim.baimproject.MenuAwal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.baim.baimproject.CobaLagi2;
import com.baim.baimproject.R;
import com.baim.baimproject.lihatdatamakanan.MainActivitytest;
import com.baim.baimproject.lihatdatamakanan.Testerlihat;

public class Menusatu extends AppCompatActivity {
    AppCompatButton btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menusatu);
        btn2 = (AppCompatButton) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menusatu.this, Testerlihat.class);
                startActivity(i);
            }
        });
        btn1 = (AppCompatButton) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menusatu.this, CobaLagi2.class);
                startActivity(i);
            }
        });

    }
}
