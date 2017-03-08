package com.baim.baimproject.lihatdatamakanan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baim.baimproject.Databaruu2;
import com.baim.baimproject.R;
import com.squareup.picasso.Picasso;

public class Detail2 extends AppCompatActivity {

 private ImageView imageView;
    private TextView textViewMenu;
    private TextView textViewHrga;
    private TextView textViewPorsi;
    private TextView textViewStatus;
    private TextView textViewDeskr;

    LinearLayout linear1,linear2, linear3, linear4, linear5, linear6;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contoh_detail2);

        imageView = (ImageView) findViewById(R.id.imageView);
        textViewMenu = (TextView) findViewById(R.id.textViewMenu);
        textViewHrga = (TextView) findViewById(R.id.textViewHrga);
        textViewPorsi = (TextView) findViewById(R.id.textViewPorsi);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);
       textViewDeskr = (TextView) findViewById(R.id.buy);
        Intent i = getIntent();
        textViewMenu.setText(String.valueOf(i.getStringExtra(Testerlihat.name)));
        textViewHrga.setText(String.valueOf(i.getStringExtra(Testerlihat.harga)));
        textViewPorsi.setText(String.valueOf(i.getStringExtra(Testerlihat.diskon)));
        textViewStatus.setText(String.valueOf(i.getStringExtra(Testerlihat.quantity)));


        Picasso.with(Detail2.this).load(String.valueOf(i.getStringExtra(Testerlihat.gambar))).placeholder(R.drawable.baruan).error(R.drawable.enggaah).into(imageView);
    textViewDeskr.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent o = new Intent(Detail2.this, Databaruu2.class);
            startActivity(o);
        }
    });
    }
    }







