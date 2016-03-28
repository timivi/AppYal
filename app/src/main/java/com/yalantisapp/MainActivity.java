package com.yalantisapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//[Comment] Bad design: Wrong toolbar and status bar colors. Wrong cell size. Wrong paddings.
//[Comment] Missing view clicks
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter aRecyclerViewAdapter; //[Comment] All of these objects should be local. Use google code style for names
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ArrayList<String> urls = new ArrayList<>(); //[Comment] Use abstraction instead of realization
        urls.add("http://i.telegraph.co.uk/multimedia/archive/03570/potd-grass_3570487k.jpg"); //[Comment] Hardcode
        urls.add("http://i.telegraph.co.uk/multimedia/archive/03571/potd-squirrel_3571152k.jpg");
        urls.add("http://i.telegraph.co.uk/multimedia/archive/03519/potd-squirrel_3519920k.jpg");

        aRecyclerViewAdapter = new RecyclerViewAdapter(this, urls);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setAdapter(aRecyclerViewAdapter);
        aRecyclerViewAdapter.notifyDataSetChanged();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) { //[Comment] Bad code. You should check getSupportActionBar, not toolbar
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}
