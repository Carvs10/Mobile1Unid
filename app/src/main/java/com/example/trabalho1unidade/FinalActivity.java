package com.example.trabalho1unidade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.widget.Toast;

import com.example.trabalho1unidade.model.Cart;
import com.example.trabalho1unidade.model.Product;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {

    Intent it;
    Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        cart = new Cart();
        it = getIntent();
        Bundle data = it.getExtras();
        cart.loadCartFromIntentBundle(data);

        //TODO: Remove after debug
        Toast.makeText(getApplicationContext(), String.valueOf(cart.getTotalPrice()), Toast.LENGTH_SHORT).show();
    }

    public void finish() {
        it = cart.saveCartToIntentBundle(it);
        setResult(3, it);
        super.finish();
    }
}