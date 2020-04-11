package com.tigers.remote_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultEnvironment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView main_actvity= (TextView)findViewById(R.id.textView2);
        main_actvity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultEnvironment.this,MainActivity.class);
                startActivity(intent);
            }
        });
        setContentView(R.layout.activity_result_environment);
    }
}
