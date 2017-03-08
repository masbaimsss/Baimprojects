package com.baim.baimproject.lihatdatamakanan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by baim on 07/08/2016.
 */
public class MenuMakanan1 {
    @SerializedName("waws")
    @Expose
    private ArrayList<MenuMakanan> menuMakanans = new ArrayList<>();

    /**
     * @return The contacts
     */
    public ArrayList<MenuMakanan> getContacts() {
        return menuMakanans;
    }

    /**

     */

    public void setMenuMakanans(ArrayList<MenuMakanan> menuMakanans) {
        this.menuMakanans = menuMakanans;
    }

}
