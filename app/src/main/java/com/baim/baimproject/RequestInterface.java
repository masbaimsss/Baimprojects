package com.baim.baimproject;

/**
 * Created by baim on 02/12/2016.
 */
import com.baim.baimproject.ServerRequest;
import com.baim.baimproject.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("logins/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
