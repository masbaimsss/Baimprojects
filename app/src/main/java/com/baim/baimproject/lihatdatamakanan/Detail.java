package com.baim.baimproject.lihatdatamakanan;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baim.baimproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail extends AppCompatActivity {

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
        setContentView(R.layout.contoh_detail);

        imageView = (ImageView) findViewById(R.id.imageView);
        textViewMenu = (TextView) findViewById(R.id.textViewMenu);
        textViewHrga = (TextView) findViewById(R.id.textViewHrga);
        textViewPorsi = (TextView) findViewById(R.id.textViewPorsi);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);
       textViewDeskr = (TextView)findViewById(R.id.discription1);

        Intent i = getIntent();
        textViewMenu.setText(String.valueOf(i.getStringExtra(Main2Activity.name)));
        textViewHrga.setText(String.valueOf(i.getStringExtra(Main2Activity.harga)));
        textViewPorsi.setText(String.valueOf(i.getStringExtra(Main2Activity.porsi)));
        textViewStatus.setText(String.valueOf(i.getStringExtra(Main2Activity.status)));
        textViewDeskr.setText(String.valueOf(i.getStringExtra(Main2Activity.deskripsi)));

        linear1 = (LinearLayout)findViewById(R.id.linear1);
        linear2 = (LinearLayout)findViewById(R.id.linear2);
        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear2.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);
                textViewDeskr.setVisibility(View.VISIBLE);

            }
        });
        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear2.setVisibility(View.GONE);
                linear1.setVisibility(View.VISIBLE);
                textViewDeskr.setVisibility(View.GONE);


            }
        });
        Picasso.with(Detail.this).load(String.valueOf(i.getStringExtra(Main2Activity.gambar))).placeholder(R.drawable.baruan).error(R.drawable.enggaah).into(imageView);
    }
    }







