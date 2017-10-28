package com.clarkson.clarksworld.andelacryptocoin.coinapiservice;

import com.clarkson.clarksworld.andelacryptocoin.EthCoinConversion;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by CLARKSWORLD on 27/10/2017.
 */

public interface EthCoinApiService {

    @GET("data/price?")
    Call<EthCoinConversion> loadETHExchange(@Query("fsym") String coins, @Query("tsyms") String currency);
}
