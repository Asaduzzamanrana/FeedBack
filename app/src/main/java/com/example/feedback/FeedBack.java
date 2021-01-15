package com.example.feedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBack extends AppCompatActivity implements View.OnClickListener {
    private Button sendbutton, clearbutton;
    private EditText nameedittext, feedbackedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        nameedittext = findViewById(R.id.nameedittextid);
        feedbackedittext = findViewById(R.id.feedbackedittextid);
        sendbutton = findViewById(R.id.sendid);
        clearbutton = findViewById(R.id.clearid);

        sendbutton.setOnClickListener(this);
        clearbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        try {

            String name = nameedittext.getText().toString();
            String feedback = feedbackedittext.getText().toString();

            if (v.getId()==R.id.sendid){

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"asaduzzamanrrana@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"name: ");
                intent.putExtra(Intent.EXTRA_TEXT,"name: "+name+"\n feedback"+feedback);
                startActivity(Intent.createChooser(intent,"feedback with"));

            }
            else if (v.getId()==R.id.clearid){

                nameedittext.setText("");
                feedbackedittext.setText("");

            }

        }
        catch (Exception e){

            Toast.makeText(getApplicationContext(), "Exception"+e, Toast.LENGTH_SHORT).show();

        }

    }
}
