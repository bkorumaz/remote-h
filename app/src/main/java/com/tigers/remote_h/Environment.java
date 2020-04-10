package com.tigers.remote_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

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

    }


}
