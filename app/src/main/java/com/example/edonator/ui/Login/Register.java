package com.example.edonator.ui.Login;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edonator.R;

public class Register extends AppCompatActivity {
    private SQLiteDatabase db;
    private MyDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mDbHelper = new MyDbHelper(this);
        db = mDbHelper.getWritableDatabase();

        Button registerButton = (Button) findViewById(R.id.button_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to collect data from user
                EditText inputName = (EditText) findViewById(R.id.input_fullName);
                String name = inputName.getText().toString();

                Spinner inputGender = (Spinner) findViewById(R.id.gender);
                String gender = inputGender.getSelectedItem().toString();

                EditText inputMobile = (EditText) findViewById(R.id.inputMobile);
                int mobile = 0;
                try {
                    mobile = Integer.parseInt(inputMobile.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(Register.this, "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
                    return;
                }

                EditText inputAddress = (EditText) findViewById(R.id.inputAddress);
                String address = inputAddress.getText().toString();

                Spinner inputSubCounty = (Spinner) findViewById(R.id.inputSubCounty);
                String subCounty = inputSubCounty.getSelectedItem().toString();

                EditText input_userEmail = (EditText) findViewById(R.id.input_userEmail);
                String email = input_userEmail.getText().toString();

                EditText input_password = (EditText) findViewById(R.id.input_password);
                String password = input_password.getText().toString();

                EditText input_password_confirm = (EditText) findViewById(R.id.input_password_confirm);
                String cpassword = input_password_confirm.getText().toString();

                if (!password.equals(cpassword)) {
                    Toast.makeText(Register.this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT).show();
                    return;
                }
                CheckBox inputDonor = (CheckBox) findViewById(R.id.checkbox);
                boolean donor = inputDonor.isChecked();

                // Insert the data into the database
                ContentValues values = new ContentValues();
                values.put("full_name", name);
                values.put("gender", gender);
                values.put("mobile_number", mobile);
                values.put("address", address);
                values.put("sub_county", subCounty);
                values.put("email", email);
                values.put("password", password);
                values.put("donor", donor);

                long newRowId = db.insert("users", null, values);
                if (newRowId == -1) {
                    Toast.makeText(getApplicationContext(), "Failed to insert data", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
                }

                // Close the database
                db.close();
            }
        });
    }

}
