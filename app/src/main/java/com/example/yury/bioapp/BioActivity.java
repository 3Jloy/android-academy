package com.example.yury.bioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BioActivity extends AppCompatActivity implements View.OnClickListener {

    private String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        EditText emailEditTextView = findViewById(R.id.message_edit_text);
        emailText = emailEditTextView.getText().toString();

        Button sendEmailButton = findViewById(R.id.send_email_button);
        sendEmailButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sendEmailAction();
    }

    private void sendEmailAction() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        //emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("*/*");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "3jloy.01@gmai.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mail from your bio app");
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailText);

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        } else {
            Toast.makeText(this, "Sending an email is not available!", Toast.LENGTH_LONG).show();
        }

    }
}
