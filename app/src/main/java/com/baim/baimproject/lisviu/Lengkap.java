package com.baim.baimproject.lisviu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import com.baim.baimproject.R;
import com.baim.baimproject.pesenan.Config;
import com.baim.baimproject.pesenan.RequestHandler;

public class Lengkap extends AppCompatActivity {
    private ListView listView;
    // Variabel untuk format String JSON
    private String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lengkap);
        listView = (ListView) findViewById(R.id.mdlistview);
        //   Method GetJSON
        getJSON();
    }

        // Buat Methode untuk ambil data dari Server
    private void TampilData(){
        // Data dalam bentuk Array kemudian akan kita ubah menjadi JSON Object
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            // FOR untuk ambil data
            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                // TAG_ID dan TAG_NAME adalah variabel yang ada di Class Config.java,
                String id = jo.getString(Config.TAG_ID);
                String nama = jo.getString(Config.TAG_NAMA);
                String porsi = jo.getString(Config.TAG_PORSI);
                String harga = jo.getString(Config.TAG_HARGA);

                HashMap<String,String> pesan = new HashMap<>();
                pesan.put(Config.TAG_ID,id);
                pesan.put(Config.TAG_NAMA,nama);
                pesan.put(Config.TAG_PORSI,porsi);
                pesan.put(Config.TAG_HARGA,harga);
                list.add(pesan);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Tampilkan datanya dalam Layout Lihat Data
        ListAdapter adapter = new SimpleAdapter(
                Lengkap.this, list, R.layout.listview,
                new String[]{Config.TAG_ID,Config.TAG_NAMA,Config.TAG_PORSI,Config.TAG_HARGA},
                new int[]{R.id.ids, R.id.nama, R.id.porsi, R.id.harga});
        // Tampilkan dalam bentuk ListView
        listView.setAdapter(adapter);
    }

    // Methode ambil data JSON yang kita definisikan dalam bentuk AsyncTask
    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Lengkap.this,"Pengambilan Data","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                // Panggil method tampil data
                TampilData();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                // Proses nya sesuai alamat URL letak script PHP yang kita set di Class Config.java
                String s = rh.sendGetRequest(Config.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

}
