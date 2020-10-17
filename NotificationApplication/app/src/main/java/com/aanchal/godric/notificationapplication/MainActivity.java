package com.aanchal.godric.notificationapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button def,inbox,bigpic,bigtext;
    private String channelId = "Personal Notification";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        def.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotificationChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this)
                        .setContentTitle("Default Notification")
                        .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                        .setContentText("This is a default Notification");
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
            }
        });

    }

    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name = "Personal Notification";
            String desc = "Show all Notification";
            int impt = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(channelId,name,impt);
            notificationChannel.setDescription(desc);

            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(notificationChannel);
        }
    }

    private void init() {
        def = findViewById(R.id.default_notif);
        inbox = findViewById(R.id.inbox_notif);
        bigpic = findViewById(R.id.bigpic_notif);
        bigtext = findViewById(R.id.bigtext_notif);
    }

}
