package com.nsikakthompson.andelacrytocompare.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import java.util.Map;

public class CryptoAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private Map<String, Double> values;

    public CryptoAdapter(Context context, Map<String, Double> values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
