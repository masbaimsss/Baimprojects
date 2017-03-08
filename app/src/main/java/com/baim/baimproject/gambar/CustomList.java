package com.baim.baimproject.gambar;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.baim.baimproject.R;

import java.util.ArrayList;

/**
 * Created by baim on 03/12/2016.
 */
public class CustomList extends ArrayAdapter<String> {
private String[] urls;
private Bitmap[] bitmaps;
private Activity context;
        private ArrayList<String> gambar;
        private ArrayList<String> name;
public CustomList(Activity context, String[] urls, Bitmap[] bitmaps) {
        super(context, R.layout.listview);
        this.context = context;
        this.urls= urls;
        this.bitmaps= bitmaps;
        this.gambar = gambar;
        this.name = name;
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.listview, null, true);
        TextView textViewURL = (TextView) listViewItem.findViewById(R.id.pp);
        ImageView image = (ImageView) listViewItem.findViewById(R.id.mdimage);
    NetworkImageView networkImageView = new NetworkImageView(context);

        textViewURL.setText(name.get(position));
        image.setImageBitmap(Bitmap.createScaledBitmap(bitmaps[position],100,50,false));


    return  listViewItem;
        }
        }
