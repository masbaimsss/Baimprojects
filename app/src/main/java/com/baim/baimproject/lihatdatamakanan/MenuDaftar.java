package com.baim.baimproject.lihatdatamakanan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by baim on 07/08/2016.
 */
public class MenuDaftar {
    @SerializedName("gambar")
    @Expose
    private String gambar;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("harga")
    @Expose
    private String harga;

    @SerializedName("diskon")
    @Expose
    private String diskon;

    @SerializedName("quantity")
    @Expose
    private String quantity;



    public String getGambar() {
        return gambar;
    }
    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getName(){
    return  name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getHarga(){
        return  harga;
    }
    public void setHarga(String harga){
        this.harga=harga;
    }

    public String getDiskon(){
        return  diskon;
    }
    public void setDiskon(String diskon){
        this.diskon=diskon;
    }

    public String getQuantity(){
        return quantity;
    }
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }



}

