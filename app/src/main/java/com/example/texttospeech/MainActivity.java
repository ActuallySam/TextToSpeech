package com.example.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //Initialize Variable
    EditText etInput;
    Button btConvert,btClear;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign Variables
        etInput = findViewById(R.id.et_input);
        btConvert = findViewById(R.id.bt_convert);
        btClear = findViewById(R.id.bt_clear);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    //Select Language
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //Get EditText Value
                String s = etInput.getText().toString();

                //Text Convert to Speech
                int speech = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //Clear EditText
                etInput.setText("");
            }
        });

    }
}
