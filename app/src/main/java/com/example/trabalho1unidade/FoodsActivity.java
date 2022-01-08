package com.example.trabalho1unidade;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.trabalho1unidade.model.Cart;
import com.example.trabalho1unidade.model.Product;

public class FoodsActivity extends AppCompatActivity {

    Intent it;
    Menu menu;
    Cart cart;

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        cart = new Cart();
        it = getIntent();
        Bundle data = it.getExtras();
        cart.loadCartFromIntentBundle(data);

        btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Remove after test
                Product a = new Product("b", 4, "a", "a", "a");
                cart.addProduct(a, 1);
                updateTotalPrice();
            }
//            public void onClick(View v) { finish(); }
        });
    }

    ////// ACTIVITY BAR ///////
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.price_menu, menu);
        this.menu = menu;

        // Update total price
        updateTotalPrice();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.goToCart:
            case R.id.totalPrice:
                Intent it = new Intent(getApplicationContext(), FinalActivity.class);
                it = cart.saveCartToIntentBundle(it);
                startActivityForResult(it, 3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 3 && resultCode == 3){
            cart.loadCartFromIntentBundle(data.getExtras());
            updateTotalPrice();
        } else {
            Toast.makeText(this, "Error to load cart price!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateTotalPrice(){
        menu.findItem(R.id.totalPrice).setTitle("R$ " + String.valueOf(cart.getTotalPrice()));
    }

    @Override
    public void finish() {
        it = cart.saveCartToIntentBundle(it);
        setResult(1, it);
        super.finish();
    }
}