package com.example.sherdonbrown.myapplication.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;


import com.example.sherdonbrown.myapplication.Model.Example;
import com.example.sherdonbrown.myapplication.network.API_Request;
import com.example.sherdonbrown.myapplication.network.Request_Interface;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewModel extends android.arch.lifecycle.ViewModel {


    private MutableLiveData<Example> list;

    public LiveData<Example> getContacts(){
        if(list == null){
            list = new MutableLiveData<Example>();
            loadContacts();
        }
        return list;
    }


    private void loadContacts(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Request.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Request_Interface api = retrofit.create(Request_Interface.class);
        Call<Example> call = api.getContacts();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                list.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }

}
