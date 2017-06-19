package com.etiyaprogressview;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.etiya.progressview.EtiyaProgressView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtiyaProgressView etiyaProgressView;
        etiyaProgressView = (EtiyaProgressView) findViewById(R.id.etiyaProgressView);

        etiyaProgressView.setProgress(40);
        etiyaProgressView.setProgressColor(ContextCompat.getColor(this, R.color.progress_color));
        etiyaProgressView.setTextColor(ContextCompat.getColor(this, R.color.progress_color));
        etiyaProgressView.setPercentageColor(ContextCompat.getColor(this, R.color.progress_color));
        etiyaProgressView.setInnerCircleMargin(-1);
        etiyaProgressView.setInnerCircleColor(ContextCompat.getColor(this, R.color.inner_circle_color));
        etiyaProgressView.setOuterCircleColor(ContextCompat.getColor(this, R.color.inner_circle_color));
        etiyaProgressView.setPercentageText("%");
        etiyaProgressView.setStartAngle(270);
        etiyaProgressView.setMaxProgress(100);

    }
}
