package com.nsikakthompson.andelacrytocompare.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/**
 * Created by Nsikak on 10/16/17.
 */

public class CoinResponse {
    @SerializedName("BTC")
    private HashMap<String, Double> btc;
    @SerializedName("ETH")
    private HashMap<String, Double> eth;

    public HashMap<String, Double> getBtc() {
        return btc;
    }

    public HashMap<String, Double> getEth() {
        return eth;
    }
}
