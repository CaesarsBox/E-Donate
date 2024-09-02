package com.example.edonator.ui.Login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.edonator.R;

public class DonorActivity extends AppCompatActivity {


    CardView cardDonate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.well);
        cardDonate = findViewById(R.id.CardDonate);




    }
}
