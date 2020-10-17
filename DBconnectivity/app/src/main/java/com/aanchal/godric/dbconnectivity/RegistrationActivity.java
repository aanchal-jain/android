package com.aanchal.godric.dbconnectivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText uname,password,contact,state,city;
    Button register,cancel;
    private String name,pwd,phone,st,ci;
    private SqliteDbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = uname.getText().toString();
                pwd = password.getText().toString();
                phone = contact.getText().toString();
                st = state.getText().toString();
                ci = city.getText().toString();

                boolean f = db.registerUser(name,pwd,phone,st,ci);
                if(f)
                    Toast.makeText(RegistrationActivity.this,"Data Entered Successfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(RegistrationActivity.this,"Data Not Entered Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        uname = findViewById(R.id.usr_name);
        password = findViewById(R.id.passwd);
        contact = findViewById(R.id.phone);
        state = findViewById(R.id.state);
        city = findViewById(R.id.city);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        db = new SqliteDbHelper(this);
    }
}
