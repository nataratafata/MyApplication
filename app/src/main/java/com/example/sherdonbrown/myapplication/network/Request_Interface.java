package com.example.sherdonbrown.myapplication.network;

import com.example.sherdonbrown.myapplication.Model.Example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Request_Interface {

    @GET(API_Request.CONTACTS_URL)
    Call<Example> getContacts();
}
