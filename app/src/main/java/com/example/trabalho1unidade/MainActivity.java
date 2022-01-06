package com.example.trabalho1unidade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.trabalho1unidade.fragments.InfoDigalogFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager nFragmentManager;

    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nFragmentManager = getSupportFragmentManager();

        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SecondaryActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.simple_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.sobre:
                InfoDigalogFragment infoDigalogFragment = new InfoDigalogFragment();
                infoDigalogFragment.show(nFragmentManager, "INFO");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}