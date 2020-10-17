package com.aanchal.godric.dbconnectivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    Button register,update,delete,viewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(intent);
            }
        });

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewAllActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        register = findViewById(R.id.register_button);
        update = findViewById(R.id.update_button);
        delete = findViewById(R.id.delete_button);
        viewAll = findViewById(R.id.viewAll_button);
    }
}
