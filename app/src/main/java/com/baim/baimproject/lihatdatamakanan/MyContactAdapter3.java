package com.baim.baimproject.lihatdatamakanan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baim.baimproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by baim on 07/08/2016.
 */
public class MyContactAdapter3 extends ArrayAdapter<MenuDaftar> {

    List<MenuDaftar> contactList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public MyContactAdapter3(Context context, List<MenuDaftar> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }

    @Override
    public MenuDaftar getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.list, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }


        MenuDaftar item = getItem(position);

        vh.textViewMenu.setText(item.getName());
        vh.textViewHrga.setText(item.getHarga());
        vh.textViewPorsi.setText(item.getDiskon());


        Picasso.with(context).load(item.getGambar()).placeholder(R.drawable.baruan).error(R.drawable.enggaah).into(vh.imageView);

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewMenu;
        public final TextView textViewHrga;
        public final TextView textViewPorsi;



        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewMenu, TextView textViewHrga
                ,TextView textViewPorsi) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewMenu = textViewMenu;
            this.textViewHrga = textViewHrga;
            this.textViewPorsi= textViewPorsi;


        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            TextView textViewMenu = (TextView) rootView.findViewById(R.id.textViewMenu);
            TextView textViewHrga = (TextView) rootView.findViewById(R.id.textViewHrga);
            TextView textViewPorsi = (TextView) rootView.findViewById(R.id.textViewPorsi);

            return new ViewHolder(rootView, imageView, textViewMenu, textViewHrga,textViewPorsi);
        }
    }

}