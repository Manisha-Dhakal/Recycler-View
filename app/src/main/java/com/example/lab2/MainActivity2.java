package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab2.ModelClass.ModelContact;

import java.util.List;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    Button button;
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setTitle("Contact Details");

        String name= getIntent().getStringExtra("name");

        textView= findViewById(R.id.carviewtext);

        textView.setText(String.valueOf(name));

        button=findViewById(R.id.button);

        textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage(Locale.CANADA);
                textToSpeech.setSpeechRate(1);
                textToSpeech.setPitch(1);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.speak(name,TextToSpeech.QUEUE_FLUSH,null);
            }
        });


    }
}