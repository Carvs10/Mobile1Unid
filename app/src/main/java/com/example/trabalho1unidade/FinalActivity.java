package com.example.trabalho1unidade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabalho1unidade.model.Cart;
import com.example.trabalho1unidade.model.Product;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {

    Intent it;
    Cart cart;
    public int numPeople = 0;
    private SeekBar seekPeople;
    private TextView textPeople, finalPrice, finalTotalPrice;
    private Button btnFinish;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        ListView productList = (ListView) findViewById(R.id.productList);

        btnFinish = findViewById(R.id.btnFinish);

        finalTotalPrice = findViewById(R.id.finalTotalPrice);
        finalPrice = findViewById(R.id.finalPrice);

        //populate listview
        //String[] prodName = {"Pizza", "Macarrão", "Filé", "Pastel", "Salagadinhos, Amendoim", "Pringles", "Pão de Queijo"};

        cart = new Cart();
        it = getIntent();
        Bundle data = it.getExtras();
        cart.loadCartFromIntentBundle(data);

        ArrayList<String> listName = new ArrayList<String>();
        ArrayList<Integer> listQuantity = new ArrayList<Integer>();
        ArrayList<Float> listTotalPrice = new ArrayList<Float>();
        ArrayList<Pair<Product, Integer>> products = cart.getProducts();
        for(Pair<Product, Integer> product : products){
            listName.add(product.first.getName());
            listQuantity.add(product.second);
            listTotalPrice.add(product.first.getPrice() * product.second);
        }

        BaseAdapter2 prodAdapter2 = new BaseAdapter2(getApplicationContext(), listName, listQuantity,listTotalPrice);
        //ArrayAdapter<String> prodAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listName);
        productList.setAdapter(prodAdapter2);

        //SeekBar for catch the number of people to share the bill
        seekPeople = findViewById(R.id.seekBar);
        textPeople = findViewById(R.id.numbPeople);

        finalTotalPrice.setText("R$ " + cart.getTotalPrice());
        finalPrice.setText("R$ " + cart.getTotalPrice());

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(it);
                finishAffinity();
            }
        });

        //Seekbar function
       seekPeople.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                numPeople = progress;
                String status = String.valueOf(numPeople);
                textPeople.setText(status);

                 double share = calculatePrice(numPeople);
                 String finale = Double.toString(share);
                 finalPrice.setText("R$ " + finale);

           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }



       });

    }

    public double calculatePrice(int peopleSelected){

        double price = cart.getTotalPrice();

        double sharePrice = price / peopleSelected;

        return sharePrice;
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void finish() {
        it = cart.saveCartToIntentBundle(it);
        setResult(3, it);
        super.finish();
    }
}