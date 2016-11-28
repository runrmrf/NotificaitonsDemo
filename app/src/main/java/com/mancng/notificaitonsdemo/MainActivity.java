package com.mancng.notificaitonsdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent where you want to display for the user when the notification is tapped
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, 0);

        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("Lunch is ready!")
                .setContentText("It's getting cold..")
                .setContentIntent(pendingIntent)
                //You can setup a different pendingIntent so when the Chat button is tapped, it'll go somewhere other than the MainActivity
                .addAction(android.R.drawable.sym_action_chat, "Chat", pendingIntent)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .build();

        //Display the notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(1, notification);


    }
}
