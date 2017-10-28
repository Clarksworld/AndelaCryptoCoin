package com.clarkson.clarksworld.andelacryptocoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.clarkson.clarksworld.andelacryptocoin.coinAdapter.BtcCoinAdapter;
import com.clarkson.clarksworld.andelacryptocoin.coinapiservice.BtcCoinApiService;
import com.clarkson.clarksworld.andelacryptocoin.coinapiservice.BtcCoinItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


    public class BtcCoinActivity extends AppCompatActivity implements Callback<BtcCoinConversion>, BtcCoinItem {

        private ListView currencyList;
        private ProgressBar progressBar;
        String fsym = "BTC";
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

            BtcCoinApiService service = retrofit.create(BtcCoinApiService.class);
            Call<BtcCoinConversion> call = service.loadETHExchange(fsym,tsyms);
            call.enqueue(this);
        }


        @Override
        public void onResponse(Call<BtcCoinConversion> call, Response<BtcCoinConversion> response) {
            progressBar.setVisibility(View.INVISIBLE);
            BtcCoinConversion btcCoinConversion = response.body();
            currencyList.setAdapter(new BtcCoinAdapter(this, btcCoinConversion.getCoinModelList(), this));
        }

        @Override
        public void onFailure(Call<BtcCoinConversion> call, Throwable t) {
            progressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Unable to fetch data. Please try again later.", Toast.LENGTH_LONG).show();


        }

        @Override
        public void onETHCurrencyItemClick(BtcCoinModel btcCoinModel) {

            Intent myIntent = new Intent(this, BtcCoinToCurrencyActivity.class);
            myIntent.putExtra("name_of_currency", btcCoinModel.getName());
            myIntent.putExtra("rate_of_currency", btcCoinModel.getRate());
            startActivity(myIntent);

        }
    }


