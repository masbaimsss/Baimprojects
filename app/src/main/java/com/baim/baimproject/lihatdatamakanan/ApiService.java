package com.baim.baimproject.lihatdatamakanan;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by baim on 07/08/2016.
 */
public interface ApiService {
    @GET("/gambartes/lihatkitadoang.php")
    Call<MenuMakanan1> getMyJSON();
}
