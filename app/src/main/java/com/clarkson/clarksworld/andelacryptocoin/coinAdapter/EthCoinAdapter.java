package com.clarkson.clarksworld.andelacryptocoin.coinAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.clarkson.clarksworld.andelacryptocoin.EthCoinModel;
import com.clarkson.clarksworld.andelacryptocoin.R;
import com.clarkson.clarksworld.andelacryptocoin.coinapiservice.EthCoinItem;

import java.util.List;

/**
 * Created by CLARKSWORLD on 27/10/2017.
 */


public class EthCoinAdapter extends BaseAdapter {


    private Context context;
    private LayoutInflater layoutInflater;
    private List<EthCoinModel> ethCoinModels;
    private EthCoinItem ethCoinItem;

    public EthCoinAdapter(Context context, List<EthCoinModel> ethCoinModels, EthCoinItem ethCoinItem) {
        this.context = context;
        this.ethCoinModels = ethCoinModels;
        this.ethCoinItem = ethCoinItem;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return ethCoinModels.size();
    }

    @Override
    public Object getItem(int position) {
        return ethCoinModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View ethCurrencyItemView = layoutInflater.inflate(R.layout.currency_item, null);
        TextView currencyName = ethCurrencyItemView.findViewById(R.id.name_of_currency);
        TextView currencyAmount = ethCurrencyItemView.findViewById(R.id.amount_of_currency);
        TextView countryName = ethCurrencyItemView.findViewById(R.id.countrytextview);
        ImageView countryflag = ethCurrencyItemView.findViewById(R.id.countryflag);

        final EthCoinModel ethCoinModel = ethCoinModels.get(position);
        currencyName.setText(ethCoinModel.getName());
        currencyAmount.setText(Double.toString(ethCoinModel.getRate()));
        countryName.setText(ethCoinModel.getCountryNames());
        countryflag.setImageResource(ethCoinModel.getImageview());

        ethCurrencyItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ethCoinItem.onETHCurrencyItemClick(ethCoinModel);
            }
        });
        return ethCurrencyItemView;
    }
}