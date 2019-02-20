package com.example.sherdonbrown.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sherdonbrown.myapplication.Adapter.AdapterHolder;
import com.example.sherdonbrown.myapplication.Model.Example;
import com.example.sherdonbrown.myapplication.ViewModel.ViewModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecycler;
    Example exam_list;
    AdapterHolder mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = findViewById(R.id.myRecycle);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        loadcontacts();
       // mRecycler = findViewById(R.id.myRecycle);
       // mRecycler.setHasFixedSize(true);
       // mRecycler.setLayoutManager(new LinearLayoutManager(this));
       // loadcontacts();
    }

    private void loadcontacts(){
        ViewModel model = ViewModelProviders.of(this).get(ViewModel.class);


        model.getContacts().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(@Nullable Example example) {
                exam_list = example;
                mAdapter = new AdapterHolder(getBaseContext(),example);
                mRecycler.setAdapter(mAdapter);
            }
        });
















        //ViewModel model = ViewModelProviders.of(this).get(ViewModel.class);

       /* model.getContacts().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(@Nullable Example example) {
                exam_list = example;
                mAdapter = new AdapterHolder(getBaseContext(),example);
                mRecycler.setAdapter(mAdapter);
            }
        });*/
    }
}
