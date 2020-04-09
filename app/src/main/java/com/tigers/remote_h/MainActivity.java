package com.tigers.remote_h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button notifation_1;
    Button notifation_2;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        notificationManager = NotificationManagerCompat.from(this);
        setContentView(R.layout.notifations_test);
        notifation_1=(Button)findViewById(R.id.button1);
        notifation_2=(Button)findViewById(R.id.button2);
        set_on_click_buttons();
    }
    void set_on_click_buttons(){
        notifation_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                sendOnChannel1();
            }

        });
        notifation_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                sendOnChannel2();
            }

        });

    }
    public  void  sendOnChannel1()
    {
        String title="test";
        String message="Testttttttt";
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification notification=new NotificationCompat.Builder(this,Notifications.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setSound(alarmSound)
                .build();
        notificationManager.notify(1,notification);
    }
    public  void  sendOnChannel2()
    {
        String title="test2";
        String message="Testttttttt2222";
        long[] vibrate = { 50, 100, 200, 300 };

        Notification notification=new NotificationCompat.Builder(this,Notifications.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(vibrate)
                .build();
        notificationManager.notify(2,notification);
    }
}
