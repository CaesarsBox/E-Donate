package com.example.edonator.ui.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;

import com.example.edonator.R;
import com.example.edonator.ui.Login.Admin.HomeActivity;
import com.example.edonator.ui.Login.Admin.NotificationActivity;
import com.example.edonator.ui.Login.Admin.ProfileActivity;
import com.example.edonator.ui.Login.Admin.SettingsActivity;
import com.example.edonator.ui.Login.Admin.UsersActivity;

public class AdminActivity extends Activity {
    CardView cardHome, cardChat, cardProfile, cardWidgets, cardSettings, cardLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        cardHome = findViewById(R.id.CardHome);
        cardChat = findViewById(R.id.CardChat);
        cardProfile = findViewById(R.id.CardProfile);
        cardWidgets = findViewById(R.id.CardWidgets);
        cardSettings = findViewById(R.id.CardSettings);
        cardLogout = findViewById(R.id.CardLogout);

        cardHome.setOnClickListener(v -> startActivity(new Intent(this, HomeActivity.class)));
        cardChat.setOnClickListener(v -> startActivity(new Intent(this, NotificationActivity.class)));
        cardProfile.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        cardWidgets.setOnClickListener(v -> startActivity(new Intent(this, UsersActivity.class)));
        cardSettings.setOnClickListener(v -> startActivity(new Intent(this, SettingsActivity.class)));
        cardLogout.setOnClickListener(v -> {
            // Add your logout logic here (e.g., FirebaseAuth.getInstance().signOut();)
            finish();
        });
    }
}