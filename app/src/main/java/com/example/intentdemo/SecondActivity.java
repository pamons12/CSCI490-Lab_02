package com.example.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private ImageView superMoonImg;
    private ImageView waterfallImg;
    private int imageID;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        i = new Intent(this, MainActivity.class);
        superMoonImg = findViewById(R.id.supermoon);
        waterfallImg = findViewById(R.id.waterfall);

        superMoonImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageID = R.drawable.supermoon;
                finish();
            }
        });

        waterfallImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageID = R.drawable.waterfall;
                finish();
            }
        });

    }
    @Override
    public void finish() {
        Intent i = new Intent();
        i.putExtra("imageID", imageID);

        setResult(RESULT_OK, i);
        super.finish();
    }
}
