package com.example.trabalho1unidade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabalho1unidade.model.Product;


public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String listfood [];
    String listPrices[];
    int listimgs [];
    LayoutInflater inflater;

    public AdapterHandler adapterhandler;

    public CustomBaseAdapter(Context ct, String [] foodlist, int [] images, String [] prices){
        this.context = ct;
        this.listfood = foodlist;
        this.listimgs = images;
        this.listPrices = prices;
        inflater = LayoutInflater.from(ct);
    }

    @Override
    public int getCount() {
        return listfood.length;
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
        TextView txtView = (TextView) convertView.findViewById(R.id.textView);
        ImageView foodImg = (ImageView) convertView.findViewById(R.id.imageIcon);
        TextView priceView = (TextView) convertView.findViewById(R.id.priceView);
        priceView.setText(listPrices[position]);
        txtView.setText(listfood[position]);
        foodImg.setImageResource(listimgs[position]);
        Button buttonplus = (Button) convertView.findViewById(R.id.buttonBack42);
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CustomBaseAdapter.this.adapterhandler != null) {
                    CustomBaseAdapter.this.adapterhandler.updateProduct(new Product("b", 4, "a", "a", "a"),3);
                }
                Toast.makeText(buttonplus.getContext(), "button was clickde" + position, Toast.LENGTH_SHORT).show();
            }
        });
        Button buttonminus = (Button) convertView.findViewById(R.id.buttonBack24);
        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CustomBaseAdapter.this.adapterhandler != null) {
                    CustomBaseAdapter.this.adapterhandler.updateProduct(new Product("a", 4, "a", "a", "a"),3);
                }
                Toast.makeText(buttonminus.getContext(), "button was clickde" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;

    }
}
