package com.example.trabalho1unidade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BaseAdapter2 extends BaseAdapter {

    Context context;
    ArrayList<String> nameprod;
    ArrayList<Integer>quantities;
    ArrayList<Float>prices;
    LayoutInflater inflater;

    public BaseAdapter2(Context ctx, ArrayList<String> prodName, ArrayList<Integer> quantity, ArrayList<Float>price){
        this.context = ctx;
        this.nameprod = prodName;
        this.quantities = quantity;
        this.prices = price;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return nameprod.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView nameView = (TextView) convertView.findViewById(R.id.listProdName);
        TextView quantView = (TextView) convertView.findViewById(R.id.listProdQuantity);
        TextView priceView = (TextView) convertView.findViewById(R.id.listProdPrice);
        nameView.setText(nameprod[position]);
        quantView.setText(quantities[position]);
        priceView.setText(prices[position].toString());

        return convertView;
    }
}
