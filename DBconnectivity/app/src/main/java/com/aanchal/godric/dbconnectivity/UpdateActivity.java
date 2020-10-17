package com.aanchal.godric.dbconnectivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class UpdateActivity extends AppCompatActivity {

    EditText uname,username,password,contact,state,city;
    Button submit,update;
    LinearLayout updateLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        init();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    private void init() {
        uname = findViewById(R.id.update_uname);
        username = findViewById(R.id.update_username);
        password = findViewById(R.id.update_password);
        contact = findViewById(R.id.update_contact);
        state = findViewById(R.id.update_state);
        city = findViewById(R.id.update_city);
        submit = findViewById(R.id.update_submit);
        update = findViewById(R.id.update_record);
        updateLayout = findViewById(R.id.update_layout);
    }
}
