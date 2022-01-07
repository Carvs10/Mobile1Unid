package com.example.trabalho1unidade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.trabalho1unidade.model.Cart;
import com.example.trabalho1unidade.model.Product;

import java.io.Serializable;

public class GroupsActivity extends AppCompatActivity {

    Cart cart;

    Button btnFood, btnDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        cart = new Cart();

        //TODO: Remove after test
        Product a = new Product("a", 2, "a", "a", "a");
        cart.addProduct(a, 3);

        btnFood = findViewById(R.id.btnFood);
        btnDrink = findViewById(R.id.btnDrink);

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), FoodsActivity.class);
                startActivity(it);
            }
        });

        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2 = new Intent(getApplicationContext(), DrinksActivity.class);
                startActivity(it2);
            }
        });

    }

    ////// ACTIVITY BAR ///////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.price_menu, menu);

        // Update total price
        menu.findItem(R.id.totalPrice).setTitle("R$ " + String.valueOf(cart.getTotalPrice()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.goToCart:
            case R.id.totalPrice:
                Intent it = new Intent(getApplicationContext(), FinalActivity.class); //TODO: Enviar os dados
                it = cart.saveCartToIntentBundle(it);
                startActivity(it);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}