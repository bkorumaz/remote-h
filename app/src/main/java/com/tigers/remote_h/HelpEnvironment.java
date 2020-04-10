package com.tigers.remote_h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class HelpEnvironment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_environment);
    }
    void set_on_clicks()
    {
        LinearLayout add_photo= (LinearLayout) findViewById(R.id.add_photo);
        LinearLayout add_voice= (LinearLayout) findViewById(R.id.add_voice);
        LinearLayout measure_intensity= (LinearLayout) findViewById(R.id.measure_intensity);
        

    }
}
