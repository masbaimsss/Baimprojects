package com.baim.baimproject.lihatdatamakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baim.baimproject.R;
import com.baim.baimproject.lihatdatamakanan.tambahan.ChildAnimationExample;
import com.baim.baimproject.lihatdatamakanan.tambahan.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivitytest extends Fragment {
    private ListView listView;
    private View parentView;
    private SpotsDialog pDialog;
    private ArrayList<MenuMakanan> contactList;
    private MyContactAdapter adapter;
    public static  final String gambar = "gambar";
    public static  final String name = "name";
    public static  final String harga = "harga";
    public static  final String porsi = "porsi";
    public static  final String status = "status";
    public static  final String deskripsi = "deskripsi";

    SliderLayout mDemoSlider;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.activity_main2, container, false);


        // Inflate the layout for this fragment


        pDialog = new SpotsDialog(getActivity(),R.style.Proses);
        contactList = new ArrayList<>();

        parentView = v.findViewById(R.id.parentLayout);
        listView = (ListView) v.findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), Detail.class);
                MenuMakanan mm = contactList.get(position);
                i.putExtra(gambar, mm.getGambar());
                i.putExtra(name, mm.getName());
                i.putExtra(harga, mm.getHarga());
                i.putExtra(porsi, mm.getPorsi());
                i.putExtra(status, mm.getStatus());
                i.putExtra(deskripsi, mm.getDeskripsi());
                startActivity(i);

            }
        });
        ambilMenu();

        return v;
    }




        /**
         * Just to know onClick and Printing Hello Toast in Center.
         */
    private void ambilMenu() {
        pDialog.show();

        ApiService api = RetroClient.getApiService();
        Call<MenuMakanan1> call = api.getMyJSON();
        call.enqueue(new Callback<MenuMakanan1>() {
            @Override
            public void onResponse(Call<MenuMakanan1> call, Response<MenuMakanan1> response) {
                pDialog.dismiss();

                if (response.isSuccessful()) {
                    contactList = response.body().getContacts();
                    adapter = new MyContactAdapter(getActivity(), contactList);
                    listView.setAdapter(adapter);

                } else {
                    Snackbar.make(parentView, "Silahkan refresh..", Snackbar.LENGTH_LONG).show();
                }
            }

            public void onFailure(Call<MenuMakanan1> call, Throwable t) {
                pDialog.dismiss();
            }
        });

    }

}
