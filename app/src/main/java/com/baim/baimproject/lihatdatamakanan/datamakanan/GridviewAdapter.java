package com.baim.baimproject.lihatdatamakanan.datamakanan;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baim.baimproject.R;
import com.baim.baimproject.lihatdatamakanan.MenuMakanan;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class GridviewAdapter extends ArrayAdapter<MenuMakanan> {

    Context context;
    private LayoutInflater mInflater;
    List<MenuMakanan> contactList;
//    Typeface fonts1, fonts2;


    public GridviewAdapter(Context context, List<MenuMakanan> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public MenuMakanan getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        fonts1 = Typeface.createFromAsset(context.getAssets(),
//                "fonts/Lato-Light.ttf");
//
//        fonts2 = Typeface.createFromAsset(context.getAssets(),
//                "fonts/Lato-Regular.ttf");

        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview_main, null);

            viewHolder = new ViewHolder();

            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.textViewMenu= (TextView) convertView.findViewById(R.id.textViewMenu);
            viewHolder.textViewHrga = (TextView) convertView.findViewById(R.id.textViewHrga);


//            viewHolder.title1.setTypeface(fonts2);
//            viewHolder.discription1.setTypeface(fonts1);
//            viewHolder.date1.setTypeface(fonts2);

            convertView.setTag(viewHolder);


        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }


        MenuMakanan item = (MenuMakanan) getItem(position);

        viewHolder.textViewMenu.setText(item.getName());
        viewHolder.textViewHrga.setText(item.getHarga());



        Picasso.with(context).load(item.getGambar()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.imageView);


        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textViewMenu;
        TextView textViewHrga;


    }
}







//package ws.wolfsoft.get_detail;
//
//import android.app.Activity;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//
//import java.util.ArrayList;
//
///**
// * Created by Rp on 3/30/2016.
// */
//public class GridviewAdapter extends BaseAdapter {
//
//    Context context;
//    ArrayList<Beanclass> beans;
//
//    public GridviewAdapter(Context context,ArrayList<Beanclass> beans) {
//        this.beans = beans;
//        this.context = context;
//    }
//
//
//
//
//    @Override
//    public int getCount() {
//        return beans.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return beans.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        ViewHolder viewHolder = null;
//        if (convertView == null){
//
//            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//
//            viewHolder = new ViewHolder();
//
//            convertView = layoutInflater.inflate(R.layout.gridview,null);
//
//
//            viewHolder.image= (ImageView)convertView.findViewById(R.id.image);
//
//
//
//
//            convertView.setTag(viewHolder);
//
//
//        }else {
//
//            viewHolder = (ViewHolder)convertView.getTag();
//
//        }
//
//
//        Beanclass beans = (Beanclass)getItem(position);
//
//        viewHolder.image.setImageResource(beans.getImage());
//        return convertView;
//    }
//
//    private class ViewHolder{
//        ImageView image;
//
//
//    }
//
//}
