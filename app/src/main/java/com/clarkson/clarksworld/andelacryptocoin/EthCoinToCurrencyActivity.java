package com.clarkson.clarksworld.andelacryptocoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by CLARKSWORLD on 27/10/2017.
 */


public class EthCoinToCurrencyActivity extends AppCompatActivity {

    private TextView coinTitle;
    private TextView coinsub;
    private TextView coinOutputName;
    private TextView tvOutputRate;
    private EditText etInput;
    private String nameOfCurrency;
    private Double currencyRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ethconversion);

        coinTitle = (TextView) findViewById(R.id.cointitle);
        coinsub = (TextView) findViewById(R.id.coinrate);
        coinOutputName = (TextView) findViewById(R.id.coin_name_output);
        tvOutputRate = (TextView) findViewById(R.id.coin_rate_output);
        etInput = (EditText) findViewById(R.id.coin_input);


        Intent myIntent = getIntent();
        nameOfCurrency = myIntent.getStringExtra("name_of_currency");
        currencyRate = myIntent.getDoubleExtra("rate_of_currency", 0);

        coinTitle.setText("ETH to " + nameOfCurrency.toUpperCase());
        coinsub.setText("Rate 1:" + currencyRate);
        coinOutputName.setText(nameOfCurrency.toUpperCase() + ": ");


        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etInput.getText().toString().isEmpty()) {
                    tvOutputRate.setText("noting to convert ");
                }

                coincalculate();


            }

            @Override
            public void afterTextChanged(Editable editable) {
//                if (TextUtils.isEmpty(editable.toString().trim())) {
//
//                } else {
//
//                }
            }


        });
    }


    //        btnCalculate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(etInput.getText().toString().length() == 0){
//                    return;
//                }
//
//                double input;
//
//                try{
//                    input = Double.parseDouble(etInput.getText().toString());
//                }catch (NumberFormatException e){
//                    etInput.setText("");
//                    return;
//                }
//
//                double output = input * currencyRate;
//                DecimalFormat decimalFormat = new DecimalFormat("#,###,###,###");
//                tvOutputRate.setText(decimalFormat.format(output));
//
//            }
//        });
    public void coincalculate() {
        if (etInput.getText().toString().length() == 0) {
            return;
        }
        double coinInput;
        coinInput = Double.parseDouble(etInput.getText().toString());
        double coinOutput = coinInput * currencyRate;
        java.text.DecimalFormat coinDecimalFormat = new java.text.DecimalFormat("#,###,###");
        tvOutputRate.setText(coinDecimalFormat.format(coinOutput));

    }
}
