package com.aanchal.godric.dbconnectivity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewAllActivity extends AppCompatActivity {

    TextView textView;
    Cursor cursor;
    SqliteDbHelper sqliteDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        textView = findViewById(R.id.all_data);
        sqliteDbHelper = new SqliteDbHelper(this);
        cursor = sqliteDbHelper.getAllData();
        StringBuffer buffer = new StringBuffer();
        if(cursor!=null || cursor.getCount()>0){
            while(cursor.moveToNext()){
                buffer.append(cursor.getString(1)+"\n");
            }
        }
        textView.setText(buffer.toString());
    }
}
