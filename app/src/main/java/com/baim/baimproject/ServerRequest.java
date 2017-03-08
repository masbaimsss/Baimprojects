package com.baim.baimproject;

/**
 * Created by baim on 02/12/2016.
 */
public class ServerRequest {
    private String operation;
    private User user;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
