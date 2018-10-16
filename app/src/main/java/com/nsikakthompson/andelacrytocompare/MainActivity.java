package com.nsikakthompson.andelacrytocompare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.nsikakthompson.andelacrytocompare.adapter.CryptoAdapter;
import com.nsikakthompson.andelacrytocompare.model.CoinResponse;
import com.nsikakthompson.andelacrytocompare.retrofit.RetrofitUtil;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APiService aPiService;
    String fsyms = "BTC" + "," + "ETH";
    String tsyms = "USD"
            + ","
            + "EUR"
            + ","
            + "GBP"
            + ","
            + "NGN"
            + ","
            + "CAD"
            + ","
            + "SGD"
            + ","
            + "CHF"
            + ","
            + "MYR"
            + ","
            + "JPY"
            + ","
            + "CNY"
            + ","
            + "BRL"
            + ","
            + "EGP"
            + ","
            + "GHS"
            + ","
            + "KRW"
            + ","
            + "MXN"
            + ","
            + "QAR"
            + ","
            + "RUB"
            + ","
            + "SAR"
            + ","
            + "ZAR";

    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        fetchData();
    }

    public void fetchData() {
        showProgress();
        RetrofitUtil retrofitUtil = new RetrofitUtil(getApplicationContext());
        aPiService = retrofitUtil.provideRetrofit().create(APiService.class);
        aPiService.getCoins(fsyms, tsyms).enqueue(new Callback<CoinResponse>() {
            @Override
            public void onResponse(Call<CoinResponse> call, Response<CoinResponse> response) {
                if (response.isSuccessful()) {

                    List<Entry<String, Double>> cryptoList =
                            new ArrayList<>(response.body().getBtc().entrySet());
                    cryptoList.add(0, new SimpleEntry<String, Double>("BTC", null));
                    cryptoList.add(new SimpleEntry<String, Double>("ETH", null));
                    cryptoList.addAll(response.body().getEth().entrySet());
                    recyclerView.setAdapter(new CryptoAdapter(cryptoList));
                    hideProgress();
                }
            }

            @Override
            public void onFailure(Call<CoinResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("MainActivity", t.getMessage().toString());
                hideProgress();
            }
        });
    }

    private void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
