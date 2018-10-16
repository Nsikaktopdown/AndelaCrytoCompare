package com.nsikakthompson.andelacrytocompare.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Created by Nsikak on 10/16/17.
 */

public class CoinResponse {
    @SerializedName("BTC")
    private Map<String, Double> btc;
    @SerializedName("ETH")
    private Map<String, Double> eth;

    public Map<String, Double> getBtc() {
        return btc;
    }

    public Map<String, Double> getEth() {
        return eth;
    }
}
