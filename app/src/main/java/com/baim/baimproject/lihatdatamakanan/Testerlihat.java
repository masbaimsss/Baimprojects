package com.baim.baimproject.lihatdatamakanan;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baim.baimproject.R;

import java.util.ArrayList;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Testerlihat extends AppCompatActivity {
    private ListView listView;
    private View parentView;
    private SpotsDialog pDialog;
    private ArrayList<MenuDaftar> contactList;
    private MyContactAdapter3 adapter;
    public static  final String gambar = "gambar";
    public static  final String name = "name";
    public static  final String harga = "harga";
    public static  final String diskon = "diskon";
    public static  final String quantity = "quantity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testerlihat);
        pDialog = new SpotsDialog(Testerlihat.this,R.style.Proses);
        contactList = new ArrayList<>();

        parentView = findViewById(R.id.parentLayout);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Testerlihat.this, Detail2.class);
                MenuDaftar mm = contactList.get(position);
                i.putExtra(gambar, mm.getGambar());
                i.putExtra(name, mm.getName());
                i.putExtra(harga, mm.getHarga());
                i.putExtra(diskon, mm.getDiskon());
                i.putExtra(quantity, mm.getQuantity());

                startActivity(i);

            }
        });
        ambilMenu();
    }
    private void ambilMenu() {
        pDialog.show();

        ApiService2 api = (ApiService2) RetroClient.getApiService();
        Call<MenuDaftar2> call = api.getMyJSON();
        call.enqueue(new Callback<MenuDaftar2>() {
            @Override
            public void onResponse(Call<MenuDaftar2> call, Response<MenuDaftar2> response) {
                pDialog.dismiss();

                if (response.isSuccessful()) {
                    contactList = response.body().getContacts();
                    adapter = new MyContactAdapter3(Testerlihat.this, contactList);
                    listView.setAdapter(adapter);

                } else {
                    Snackbar.make(parentView, "Silahkan refresh..", Snackbar.LENGTH_LONG).show();
                }
            }

            public void onFailure(Call<MenuDaftar2> call, Throwable t) {
                pDialog.dismiss();
            }
        });

    }

}
