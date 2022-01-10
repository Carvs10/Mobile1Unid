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
    private TextView textPeople, finalPrice;
    private Button btnFinish;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        btnFinish = findViewById(R.id.btnFinish);

        finalPrice = findViewById(R.id.finalPrice);

        String[] prodName = {"coxinha, empadas, salgadinhos"};
        cart = new Cart();
        it = getIntent();
        Bundle data = it.getExtras();
        cart.loadCartFromIntentBundle(data);


        //SeekBar for catch the number of people to share the bill
        seekPeople = findViewById(R.id.seekBar);
        textPeople = findViewById(R.id.numbPeople);


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
                 finalPrice.setText(finale);

           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }



       });


        //TODO: Remove after debug
        Toast.makeText(getApplicationContext(), String.valueOf(cart.getTotalPrice()), Toast.LENGTH_SHORT).show();
    }

    public double calculatePrice(int peopleSelected){

        double price = 500.00;

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