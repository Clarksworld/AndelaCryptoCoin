package com.clarkson.clarksworld.andelacryptocoin.coinAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.clarkson.clarksworld.andelacryptocoin.BtcCoinModel;
import com.clarkson.clarksworld.andelacryptocoin.R;
import com.clarkson.clarksworld.andelacryptocoin.coinapiservice.BtcCoinItem;

import java.util.List;

/**
 * Created by CLARKSWORLD on 27/10/2017.
 */




public class BtcCoinAdapter extends BaseAdapter {


    private Context context;
    private LayoutInflater layoutInflater;
    private List<BtcCoinModel> btcCoinModels;
    private BtcCoinItem btcCoinItem;

    public BtcCoinAdapter(Context context, List<BtcCoinModel> btcCoinModels, BtcCoinItem btcCoinItem) {
        this.context = context;
        this.btcCoinModels = btcCoinModels;
        this.btcCoinItem = btcCoinItem;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return btcCoinModels.size();
    }

    @Override
    public Object getItem(int position) {
        return btcCoinModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View ethCurrencyItemView = layoutInflater.inflate(R.layout.currency_item, null);
        TextView currencyName = ethCurrencyItemView.findViewById(R.id.name_of_currency);
        TextView currencyAmount =  ethCurrencyItemView.findViewById(R.id.amount_of_currency);
        TextView countryName = ethCurrencyItemView.findViewById(R.id.countrytextview);
        ImageView countryflag = ethCurrencyItemView.findViewById(R.id.countryflag);

        final BtcCoinModel btcCoinModel = btcCoinModels.get(position);
        currencyName.setText(btcCoinModel.getName());
        currencyAmount.setText(Double.toString(btcCoinModel.getRate()));
        countryName.setText(btcCoinModel.getCountryNames());
        countryflag.setImageResource(btcCoinModel.getImageview());

        ethCurrencyItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btcCoinItem.onETHCurrencyItemClick(btcCoinModel);
            }
        });
        return ethCurrencyItemView;
    }
}


