package com.example.intentdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 0;
    private Intent mainActivityIntent;
    private Button changeBackgroundButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityIntent = new Intent(this, SecondActivity.class);
        changeBackgroundButton = findViewById(R.id.setBackgroundButton);

        changeBackgroundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(mainActivityIntent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        int imageID = extras.getInt("imageID");
        ConstraintLayout currentLayout = findViewById(R.id.main_layout);
        currentLayout.setBackground(getDrawable(imageID));

    }
}