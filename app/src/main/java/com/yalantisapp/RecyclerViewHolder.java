package com.yalantisapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageview;
    public RecyclerViewHolder(View view) {
        super(view);
        imageview = (ImageView) view.findViewById(R.id.picture);
    }
}
