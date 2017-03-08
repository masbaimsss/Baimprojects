package com.baim.baimproject.pesenan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baim.baimproject.CobaLagi;
import com.baim.baimproject.R;
import com.baim.baimproject.gambar.Upload_gambar;
import com.baim.baimproject.gambarbaru.BuatGambar;
import com.baim.baimproject.lihatdatamakanan.Main2Activity;
import com.baim.baimproject.lisviu.Lengkap;
import com.baim.baimproject.lisviu.NaviBaru;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Input_dataku extends AppCompatActivity implements View.OnClickListener {
    //Mendefinisikan View Edit Text
    private EditText editTextName;
    private EditText editTextDesg;
    private EditText editTextSal;
    // Mendefinisikan View Button
    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_dataku);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDesg = (EditText) findViewById(R.id.editTextDesg);
        editTextSal = (EditText) findViewById(R.id.editTextSalary);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Berikan event listeners Klik ke Button
        buttonView.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        Button btn = (Button) findViewById(R.id.buttonAddgambar);
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Input_dataku.this,Upload_gambar.class);
                    startActivity(i);
                }
            });
        }

    }

    //Adding an employee
    private void TambahData(){
        // Ubah setiap View EditText ke tipe Data String
        final String nama = editTextName.getText().toString().trim();
        final String porsi = editTextDesg.getText().toString().trim();
        final String harga = editTextSal.getText().toString().trim();
        // Pembuatan Class AsyncTask yang berfungsi untuk koneksi ke Database Server

        class TambahData extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Input_dataku.this,"Proses Kirim Data...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Input_dataku.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                // Sesuaikan bagian ini dengan field di tabel Mahasiswa
                params.put(Config.KEY_EMP_NAMA,nama);
                params.put(Config.KEY_EMP_PORSI,porsi);
                    params.put(Config.KEY_EMP_HARGA,harga);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }
        // Jadikan Class TambahData Sabagai Object Baru
        TambahData ae = new TambahData();
        ae.execute();
    }
    // Methode untuk event penekanan Button
    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            TambahData();
        }
        if(v == buttonView){
            startActivity(new Intent(this, NaviBaru.class));
        }


    }
}
