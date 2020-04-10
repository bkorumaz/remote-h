package com.tigers.remote_h;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HelpEnvironment extends AppCompatActivity {
    Uri mUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_environment);
        set_on_clicks();
    }

    void set_on_clicks() {
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

    }
    void record_voice()
    {
        //TextView record_voice_text =(TextView)findViewById(R.)

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
            Toast.makeText(HelpEnvironment.this, "filename", Toast.LENGTH_LONG).show();

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