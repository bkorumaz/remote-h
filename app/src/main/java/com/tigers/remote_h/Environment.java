package com.tigers.remote_h;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Environment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment);

       // getActionBar().hide();
        LinearLayout help_env= (LinearLayout)findViewById(R.id.set_working_env);
        help_env.setClickable(true);
        help_env.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Environment.this,HelpEnvironment.class);
                startActivity(intent);
            }
        });

        LinearLayout ideal_environment= (LinearLayout)findViewById(R.id.ideal_working_env);
        ideal_environment.setClickable(true);
        ideal_environment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intHome = new Intent(Environment.this, ActivitySlider.class);
                startActivity(intHome);
            }
        });

        LinearLayout did_you_know= (LinearLayout)findViewById(R.id.did_you_know);
        did_you_know.setClickable(true);
        did_you_know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Environment.this, QuoteActivity.class);
                intent.putExtra("isQuotes", false);
                startActivity(intent);
            }
        });

    }


}
