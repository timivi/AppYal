package com.yalantisapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private ArrayList<String> arrayListUrls;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayListUrls = arrayList;

    }

    @Override
    public int getItemCount() {
        return arrayListUrls.size();

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final String url = arrayListUrls.get(position);
        Log.d("DEBUG", url);
        Picasso.with(context)
                .load(url)
                .into(holder.imageview);

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_row, viewGroup, false);
        return new RecyclerViewHolder(mainGroup);
    }

}
