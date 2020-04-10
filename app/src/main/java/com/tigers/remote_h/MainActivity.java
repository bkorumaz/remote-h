package com.tigers.remote_h;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {
    Button notifation_1;
    Button notifation_2;
    private  long timeLeftINMiliSeconds=1000;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notificationManager = NotificationManagerCompat.from(this);
        setContentView(R.layout.activity_main);

        notifation_1=(Button)findViewById(R.id.button1);
        notifation_2=(Button)findViewById(R.id.button2);
        set_on_click_buttons();

    }
    /*
    void notification_timer(int second){

          new CountDownTimer(second*1000,1000) {
            @Override
            public void onTick(long l) {
                Toast.makeText(getApplicationContext(),Long.toString(l/1000),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"Test",Toast.LENGTH_LONG).show();
                sendOnChannel1();
            }
        }.start();

    }*/
    //set on click
    void set_on_click_buttons(){
      /*  notifation_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                sendOnChannel1();
            }

        });
        notifation_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                sendOnChannel2();
            }

        });*/


        // set on click of statistick layout
        LinearLayout layout = (LinearLayout)findViewById(R.id.statistics);
        layout.setClickable(true);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,Statistics.class);
             startActivity(intent);
               // notification_timer(10);


            }
        });
        LinearLayout environment_layout = (LinearLayout)findViewById(R.id.environment);
        environment_layout.setClickable(true);
        environment_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Environment.class);
                startActivity(intent);
            }
        });

    }
    public  void  sendOnChannel1()
    {
        String title="test";
        String message="Testttttttt";
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification notification=new NotificationCompat.Builder(this,Notifications.CHANNEL_1_ID)
                .setSound(alarmSound)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1,notification);
    }
    public  void  sendOnChannel2() {
        String title = "test2";
        String message = "Testttttttt2222";
        long[] vibrate = {50, 100, 200, 300};

        Notification notification = new NotificationCompat.Builder(this, Notifications.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(vibrate)
                .build();
        notificationManager.notify(2, notification);
        setContentView(R.layout.activity_main);
    }
}