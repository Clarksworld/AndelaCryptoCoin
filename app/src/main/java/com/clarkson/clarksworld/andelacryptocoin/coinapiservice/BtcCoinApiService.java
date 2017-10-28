package com.clarkson.clarksworld.andelacryptocoin.coinapiservice;

import com.clarkson.clarksworld.andelacryptocoin.BtcCoinConversion;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by CLARKSWORLD on 27/10/2017.
 */

public interface BtcCoinApiService {

    @GET("data/price?")
    Call<BtcCoinConversion> loadETHExchange(@Query("fsym") String coins, @Query("tsyms") String currency);
}
