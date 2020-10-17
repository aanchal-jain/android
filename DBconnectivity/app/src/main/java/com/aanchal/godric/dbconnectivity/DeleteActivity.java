package com.aanchal.godric.dbconnectivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText username;
    Button submit;
    String uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        username = findViewById(R.id.delete_uname);
        submit = findViewById(R.id.delete_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = username.getText().toString();
                SqliteDbHelper db = new SqliteDbHelper(DeleteActivity.this);
                int res = db.deleteUser(uname);
                if (res > 0)
                    Toast.makeText(DeleteActivity.this, "Record Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DeleteActivity.this, "Enter valid username", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
