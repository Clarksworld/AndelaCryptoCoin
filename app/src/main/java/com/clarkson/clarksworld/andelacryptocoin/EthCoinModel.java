package com.clarkson.clarksworld.andelacryptocoin;

/**
 * Created by CLARKSWORLD on 27/10/2017.
 */

public class EthCoinModel {

    private String name;
    private double rate;
    private String countryNames;

    private int imageview;

    public EthCoinModel(String name, double rate,String countryNames, int imageview) {
        this.name = name;
        this.rate = rate;
        this.countryNames = countryNames;
        this.imageview = imageview;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public String getCountryNames() {
        return countryNames;
    }



    public int getImageview() {
        return imageview;
    }
}
