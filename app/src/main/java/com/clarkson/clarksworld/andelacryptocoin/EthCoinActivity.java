package com.clarkson.clarksworld.andelacryptocoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.clarkson.clarksworld.andelacryptocoin.coinAdapter.EthCoinAdapter;
import com.clarkson.clarksworld.andelacryptocoin.coinapiservice.EthCoinApiService;
import com.clarkson.clarksworld.andelacryptocoin.coinapiservice.EthCoinItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class EthCoinActivity extends AppCompatActivity implements Callback<EthCoinConversion>, EthCoinItem {

    private ListView currencyList;
    private ProgressBar progressBar;
    String fsym = "ETH";
    String tsyms = "USD" + "," + "EUR" +
            "," + "GBP" + "," + "NGN" + "," +
            "CAD" + "," + "SGD" + "," + "CHF" + "," +
            "MYR" + "," + "JPY" + "," + "CNY" + "," +
            "BRL" + "," + "EGP" + "," + "GHS" + "," +
            "KRW" + "," + "MXN" + "," + "QAR" + "," +
            "RUB" + "," + "SAR" + "," + "ZAR" + "," + "AUD";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);

        currencyList = (ListView) findViewById(R.id.currency_list);
        loadETHExchangeData();
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

    }

    @Override
    protected void onStart() {
        super.onStart();
        progressBar.setVisibility(View.VISIBLE);
        loadETHExchangeData();
    }

    private void loadETHExchangeData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://min-api.cryptocompare.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EthCoinApiService service = retrofit.create(EthCoinApiService.class);
        Call<EthCoinConversion> call = service.loadETHExchange(fsym,tsyms);
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<EthCoinConversion> call, Response<EthCoinConversion> response) {
        progressBar.setVisibility(View.INVISIBLE);
        EthCoinConversion ethCoinConversion = response.body();
        currencyList.setAdapter(new EthCoinAdapter(this, ethCoinConversion.getCoinModelList(), this));
    }

    @Override
    public void onFailure(Call<EthCoinConversion> call, Throwable t) {
        progressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(this, "Unable to fetch data. Please try again later.", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onETHCurrencyItemClick(EthCoinModel ethCoinModel) {

        Intent myIntent = new Intent(this, EthCoinToCurrencyActivity.class);
        myIntent.putExtra("name_of_currency", ethCoinModel.getName());
        myIntent.putExtra("rate_of_currency", ethCoinModel.getRate());
        startActivity(myIntent);

    }
}
