package com.nsikakthompson.andelacrytocompare;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nsikakthompson.andelacrytocompare.model.CoinResponse;
import com.nsikakthompson.andelacrytocompare.retrofit.RetrofitUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APiService aPiService;
    String fsyms = "BTC" + "," + "ETH";
    String tsyms = "USD" + "," + "EUR" + "," + "GBP" + "," + "NGN" + "," + "CAD" + "," + "SGD" + "," + "CHF" + "," + "MYR" + "," + "JPY" + "," + "CNY" + "," + "BRL" + "," + "EGP" + "," + "GHS" + "," + "KRW" + "," + "MXN" + "," + "QAR" + "," + "RUB" + "," + "SAR" + "," + "ZAR";

    TextView btcResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btcResults = findViewById(R.id.showResults);
        fetchData();
    }



    public void fetchData(){
        RetrofitUtil retrofitUtil = new RetrofitUtil( getApplicationContext());
        aPiService = retrofitUtil.provideRetrofit().create(APiService.class);
        aPiService.getCoins(fsyms,tsyms).enqueue(new Callback<CoinResponse>() {
            @Override
            public void onResponse(Call<CoinResponse> call, Response<CoinResponse> response) {

                if(response.isSuccessful()){

                    Toast.makeText(MainActivity.this, response.body().getEth().toString(), Toast.LENGTH_LONG).show();
                  btcResults.setText(response.body().getBtc().toString());
// Log.e("MainActivity", response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<CoinResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("MainActivity", t.getMessage().toString());

            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
