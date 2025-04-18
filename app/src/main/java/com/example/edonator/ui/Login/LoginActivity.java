package com.example.edonator.ui.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edonator.R;


public class LoginActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private MyDbHelper mDbHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mDbHelper = new MyDbHelper(this);
        db = mDbHelper.getReadableDatabase();
        Button btnLogin = (Button) findViewById(R.id.button_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input_userEmail = (EditText) findViewById(R.id.input_email);
                String email = input_userEmail.getText().toString();

                EditText input_password = (EditText) findViewById(R.id.input_password);
                String password = input_password.getText().toString();

                String[] projection = {
                        "_id",
                        "full_name",
                        "email",
                        "password"
                };

                String selection = "email = ? and password = ?";
                String[] selectionArgs = {email, password};

                cursor = db.query(
                        "users",   // The table to query
                        projection,             // The array of columns to return (pass null to get all)
                        selection,              // The columns for the WHERE clause
                        selectionArgs,          // The values for the WHERE clause
                        null,                   // don't group the rows
                        null,                   // don't filter by row groups
                        null               // The sort order
                );

                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    String fullName = cursor.getString(cursor.getColumnIndexOrThrow("full_name"));

                    if (email.equals("admin@123.com")) {
                        Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                        startActivity(intent);
                        input_userEmail.setText("");
                        input_password.setText("");
                    } else {
                        Toast.makeText(LoginActivity.this, "Welcome " + fullName, Toast.LENGTH_SHORT).show();
                        input_password.setText("");
                        Intent intent = new Intent(LoginActivity.this, DonorActivity.class);
                        startActivity(intent);
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                    input_password.setText("");
                }

                SharedPreferences prefs = getSharedPreferences("user_session", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isLoggedIn", true);
                editor.putString("email", email); // Optional
                editor.apply();

            }
        });

        Button register = findViewById(R.id.button_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}



