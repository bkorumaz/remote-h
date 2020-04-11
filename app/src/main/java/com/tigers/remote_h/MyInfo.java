package com.tigers.remote_h;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyInfo extends AppCompatActivity {
    RatingBar ratingBar;
    Button day_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        TextView rating_text= (TextView)findViewById(R.id.rating_info);
        ratingBar=(RatingBar)findViewById(R.id.day_rate);
        day_=(Button) findViewById(R.id.day_);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            // Called when the user swipes the RatingBar
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rating_text.setText("Puanınız:"+Float.toString(rating)+"/5");
                if(rating>1.0) rating_text.setTextColor(Color.parseColor("#FFC294"));
                if(rating>2.0) rating_text.setTextColor(Color.parseColor("#9beb34"));
                if(rating>3.5) rating_text.setTextColor(Color.parseColor("#96FF14"));
                if(rating>4.5) rating_text.setTextColor(Color.parseColor("#30F634"));

            }
        });

        day_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ratingBar.getRating()<2.5) {

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MyInfo.this);
                    builder1.setMessage("“Umutsuz durumlar yoktur, umutsuz insanlar vardır. ...\n" +
                            "Ve Hayat, devam etmekle ilgilidir.\"");
                    builder1.setCancelable(true);
                    builder1.setIcon(R.drawable.smile);
                    builder1.show();
                }
            }
        });
    }

    }
