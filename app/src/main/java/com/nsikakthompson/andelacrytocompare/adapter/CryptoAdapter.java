package com.nsikakthompson.andelacrytocompare.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nsikakthompson.andelacrytocompare.R;
import java.util.List;
import java.util.Map.Entry;

public class CryptoAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int HEADER = 0;
    public static final int CURRENCY = 1;

    private List<Entry<String, Double>> values;

    public CryptoAdapter(List<Entry<String, Double>> values) {
        this.values = values;
    }

    @Override
    public int getItemViewType(int position) {
        if (values.get(position).getValue() == null) {
            return HEADER;
        } else {
            return CURRENCY;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER:
                return new CryptoHeader(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.item_header, null));
            case CURRENCY:
                return new CryptoHolder(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.item_currency, null));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Entry<String, Double> value = values.get(position);
        if (holder instanceof CryptoHolder) {
            CryptoHolder cryptoHolder = (CryptoHolder) holder;
            cryptoHolder.currencyText.setText(value.getKey());
            cryptoHolder.priceText.setText(String.format(value.getValue().toString(), "%d"));
        } else if (holder instanceof CryptoHeader) {
            CryptoHeader header = (CryptoHeader) holder;
            header.header.setText(value.getKey());
        }
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class CryptoHeader extends RecyclerView.ViewHolder {
        TextView header;

        public CryptoHeader(View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.header_text);
        }
    }

    class CryptoHolder extends RecyclerView.ViewHolder {
        TextView currencyText;
        TextView priceText;

        CryptoHolder(View itemView) {
            super(itemView);
            currencyText = itemView.findViewById(R.id.currency_text);
            priceText = itemView.findViewById(R.id.exchange_price);
        }
    }
}
