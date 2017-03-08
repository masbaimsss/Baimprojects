package com.baim.baimproject.lihatdatamakanan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by baim on 07/08/2016.
 */
public class MenuDaftar2 {
    @SerializedName("testdong")
    @Expose
    private ArrayList<MenuDaftar> menuDaftars = new ArrayList<>();

    /**
     * @return The contacts
     */
    public ArrayList<MenuDaftar> getContacts() {
        return menuDaftars;
    }

    /**

     */

    public void setMenuDaftars(ArrayList<MenuDaftar> menuDaftarsa) {
        this.menuDaftars = menuDaftarsa;
    }

}
