package com.nsikakthompson.andelacrytocompare.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nsikak on 10/16/17.
 */

public class CoinResponse {

    @SerializedName("BTC")
    private BTC btc;
    @SerializedName("ETH")
    private ETH eth;

    public BTC getBtc() {
        return btc;
    }

    public void setBtc(BTC btc) {
        this.btc = btc;
    }

    public ETH getEth() {
        return eth;
    }

    public void setEth(ETH eth) {
        this.eth = eth;
    }
}
