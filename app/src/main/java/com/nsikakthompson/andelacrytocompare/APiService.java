package com.nsikakthompson.andelacrytocompare;

import com.nsikakthompson.andelacrytocompare.model.CoinResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nsikak on 10/16/17.
 */

public interface APiService {

    @GET("data/pricemulti?")
    Call<CoinResponse> getCoins(@Query("fsyms") String coins, @Query("tsyms") String currency);

}
