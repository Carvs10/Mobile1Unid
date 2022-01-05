package com.example.trabalho1unidade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondaryActivity extends AppCompatActivity {

    Button btnFood, btnDrink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        btnFood = findViewById(R.id.btnFood);
        btnDrink = findViewById(R.id.btnDrink);

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(it);
            }
        });

        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2 = new Intent(getApplicationContext(), FourthActivity.class);
                startActivity(it2);
            }
        });

    }
}