package com.tigers.remote_h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HelpEnvironment extends AppCompatActivity {
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;

    private MediaRecorder recorder = null;
    private MediaPlayer player = null;
    private String [] permissions = {Manifest.permission.RECORD_AUDIO};
    private boolean permissionToRecordAccepted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_environment);
        set_on_clicks();

    }

    void set_on_clicks() {
        Button push_env_info=(Button)findViewById(R.id.push_env_info);
        LinearLayout add_photo = (LinearLayout) findViewById(R.id.add_photo);
        LinearLayout add_voice = (LinearLayout) findViewById(R.id.add_voice);
        LinearLayout measure_intensity = (LinearLayout) findViewById(R.id.measure_intensity);
        add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                take_photo();
            }
        });
        add_voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                record_voice();
            }
        });
      push_env_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog progressDialog = new ProgressDialog(HelpEnvironment.this);
                progressDialog.setMessage("Ortam Bilgileri İşleniyor. Lütfen bekleyiniz..");
                progressDialog.show();


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (progressDialog != null && progressDialog.isShowing()) {
                            progressDialog.dismiss();
                            Intent intent = new Intent(HelpEnvironment.this,ResultEnvironment.class);
                            startActivity(intent);
                        }
                        
                    }
                },5000);
            }
        });

    }




    @Override
    public void onStop() {
        super.onStop();
        if (recorder != null) {
            recorder.release();
            recorder = null;
        }
        if (player != null) {
            player.release();
            player = null;
        }
    }
    void  startRecord(){
        recorder=new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile("test");
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            recorder.prepare();
        } catch (IOException e) {

        }
        recorder.start();

    }
        void record_voice()
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(HelpEnvironment.this);
        builder1.setMessage("Lütfen daha doğru sonuçlar için kayıt esnasında sessiz olunuz!");
        builder1.setCancelable(true);
        builder1.setIcon(android.R.drawable.ic_dialog_alert);
        builder1.setPositiveButton(
                "Başla",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TextView record_voice_text =(TextView)findViewById(R.id.record_voice_text);
                        record_voice_text.setText("Ses Kaydediliyor..10");

                        //startRecord();

                        new CountDownTimer(10000,1000) {
                            @Override
                            public void onTick(long l) {

                                record_voice_text.setText("Ses Kaydediliyor.."+Long.toString(l/1000));

                            }

                            @Override
                            public void onFinish() {
                                record_voice_text.setTextColor(Color.parseColor("#FF0000"));
                                SimpleDateFormat date= new SimpleDateFormat("MM-dd-yyyy HH:mm:ss" );
                                Calendar calendar=Calendar.getInstance();
                                String[] taken_date=date.format(calendar.getTime()).split(" ");
                                String fileName = taken_date[0]+"_"+taken_date[1]+ ".wav";
                                record_voice_text.setText(fileName);
                                Toast.makeText(HelpEnvironment.this,"Ses Başarıyla Kaydedildi",Toast.LENGTH_SHORT).show();
                            }
                        }.start();
                    }
                });

        builder1.setNegativeButton(
                "Çıkış",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();




    }


    void take_photo() {
        TextView textView = (TextView) findViewById(R.id.photo_name);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 12);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 12) {

            if (resultCode == RESULT_OK) {
                    SimpleDateFormat date= new SimpleDateFormat("MM-dd-yyyy HH:mm:ss" );
                    Calendar calendar=Calendar.getInstance();
                    String[] taken_date=date.format(calendar.getTime()).split(" ");

                    String filename = "img_"+taken_date[0]+"_"+taken_date[1]+ ".jpg";

                    //Toast.makeText(HelpEnvironment.this, filename, Toast.LENGTH_LONG).show();
                    TextView textView =(TextView)findViewById(R.id.photo_name);
                    textView.setText(filename);

            }


        }
    }
}