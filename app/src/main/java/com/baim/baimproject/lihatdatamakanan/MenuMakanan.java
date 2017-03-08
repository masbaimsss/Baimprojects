package com.baim.baimproject.lihatdatamakanan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by baim on 07/08/2016.
 */
public class MenuMakanan {
    @SerializedName("gambar")
    @Expose
    private String gambar;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("harga")
    @Expose
    private String harga;

    @SerializedName("porsi")
    @Expose
    private String porsi;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;



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

    public String getPorsi(){
        return  porsi;
    }
    public void setPorsi(String porsi){
        this.porsi=porsi;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getDeskripsi(){
        return  deskripsi;
    }
    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }

}

