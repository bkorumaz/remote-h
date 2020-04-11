package com.tigers.remote_h;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class QuoteActivity extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotsLayout;

    private TextView[] mDots;
    private QuoteAdapter sliderAdapter;

    private Button mNextButton;
    private Button mBackButton;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        Boolean isQuotes = getIntent().getBooleanExtra("isQuotes", true);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        mNextButton = findViewById(R.id.nextBtn);
        mBackButton = findViewById(R.id.backBtn);
        sliderAdapter = new QuoteAdapter(this, isQuotes);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        mBackButton.setVisibility(View.INVISIBLE);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentPage==3){
                    Intent intHome = new Intent(QuoteActivity.this, MainActivity.class);
                    startActivity(intHome);
                } else {
                    mSlideViewPager.setCurrentItem(mCurrentPage+1);
                }
            }
        });

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[4];
        mDotsLayout.removeAllViews();

        for(int i=0; i< mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(50);
            mDots[i].setTextColor(getResources().getColor(R.color.sliderColorTransparentWhite));
            mDotsLayout.addView(mDots[i]);
        }

        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.sliderColorAccent));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;


            Log.v("POSITION : ", Integer.toString(position));

            if(position==0){
                mNextButton.setEnabled(true);
                mBackButton.setEnabled(false);
                mBackButton.setVisibility(View.INVISIBLE);

                mNextButton.setText("İleri");
                mBackButton.setText("");
            } else if (position==mDots.length -1 ) {
                mNextButton.setEnabled(true);
                mBackButton.setEnabled(true);
                mBackButton.setVisibility(View.VISIBLE);

                mNextButton.setText("Son");
                mBackButton.setText("Geri");
            } else {
                mNextButton.setEnabled(true);
                mBackButton.setEnabled(true);
                mBackButton.setVisibility(View.VISIBLE);

                mNextButton.setText("İleri");
                mBackButton.setText("Geri");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
