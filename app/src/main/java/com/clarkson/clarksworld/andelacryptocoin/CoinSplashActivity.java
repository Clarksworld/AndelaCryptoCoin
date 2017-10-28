package com.clarkson.clarksworld.andelacryptocoin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;

public class CoinSplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;
//    String mComponentName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_coin_splash);
        ImageView imageView = (ImageView)findViewById(R.id.andela_logo);
        ImageView imageView1 = (ImageView)findViewById(R.id.coin_logo);
        imageView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        imageView1.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        new Handler().postDelayed(new Runnable() {



            @Override
            public void run() {

                Intent i = new Intent(CoinSplashActivity.this, MainActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
