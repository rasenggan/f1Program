package com.example.zoroo.visitka;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private ImageButton mButton1;
    private ImageButton mButton2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.EditText);

        mButton1 = findViewById(R.id.imageButton1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/egor7875/"));
                startActivity(browserIntent);

            }
        });

        mButton2 = findViewById(R.id.imageButton2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/id38247875"));
                startActivity(browserIntent);

            }
        });


        Button buttonSend =  findViewById(R.id.button1);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = mEditText.getText().toString();
                String subject = "Feedback";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto: egor1010@gmail.com")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);

                }
            }
        });
    }

}
