package com.baim.baimproject.lisviu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.baim.baimproject.R;
import com.baim.baimproject.lihatdatamakanan.ApiService;
import com.baim.baimproject.lihatdatamakanan.Detail;
import com.baim.baimproject.lihatdatamakanan.MenuMakanan;
import com.baim.baimproject.lihatdatamakanan.MenuMakanan1;
import com.baim.baimproject.lihatdatamakanan.MyContactAdapter;
import com.baim.baimproject.lihatdatamakanan.MyContactAdapter2;
import com.baim.baimproject.lihatdatamakanan.RetroClient;
import com.baim.baimproject.lihatdatamakanan.datamakanan.ExpandableHeightGridView;
import com.baim.baimproject.lihatdatamakanan.datamakanan.GridviewAdapter;

import java.util.ArrayList;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Ravi on 29/07/15.
 */
public class FriendsFragment extends Fragment {
    private ExpandableHeightGridView gridview;
    private View parentView;
    private SpotsDialog pDialog;
    private ArrayList<MenuMakanan> contactList;
    private GridviewAdapter adapter;
    public static  final String gambar = "gambar";
    public static  final String name = "name";
    public static  final String harga = "harga";
    public static  final String porsi = "porsi";
    public static  final String status = "status";
    public static  final String deskripsi = "deskripsi";

    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_friends, container, false);


        pDialog = new SpotsDialog(getActivity(),R.style.Proses);
        contactList = new ArrayList<>();

        parentView = v.findViewById(R.id.parentLayout);
        gridview = (ExpandableHeightGridView) v.findViewById(R.id.gridview);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), Detail.class);
                MenuMakanan mm = contactList.get(position);
                i.putExtra(gambar, mm.getGambar());
                i.putExtra(name, mm.getName());
                i.putExtra(harga, mm.getHarga());
                i.putExtra(porsi, mm.getPorsi());
                i.putExtra(status,mm.getStatus());
                i.putExtra(deskripsi,mm.getDeskripsi());
                startActivity(i);
            }
        });
        ambilMenu();
        return v;
    }
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
                    adapter = new GridviewAdapter(getActivity(), contactList);
                    gridview.setAdapter(adapter);
                    gridview.setExpanded(true);
                } else {
                    Snackbar.make(parentView, "Silahkan refresh..", Snackbar.LENGTH_LONG).show();
                }
            }

            public void onFailure(Call<MenuMakanan1> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
