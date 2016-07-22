package com.andrey.englishcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.andrey.englishcard.utils.Dictionary;
import com.andrey.englishcard.utils.Pair;

public class MainActivity extends AppCompatActivity {

    private Pair<String, String> currentWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCurrentWord();

        findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = (EditText) findViewById(R.id.input);
                String userAnswer = input.getText().toString();
                if (currentWord.getEnglish().equals(userAnswer)) {
                    TextView result = (TextView) findViewById(R.id.result);
                    result.setText("Correct!");
                    result.setTextColor(0x0000FF00);
                } else {
                    TextView result = (TextView) findViewById(R.id.result);
                    result.setText("Wrong: --> " + currentWord.getEnglish());
                    result.setTextColor(0x00FF0000);
                }
            }
        });

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentWord();
                ((EditText) findViewById(R.id.input)).setText("");
                ((TextView) findViewById(R.id.result)).setText("");
            }
        });
    }

    private void setCurrentWord() {
        currentWord = Dictionary.getWord();
        TextView word = (TextView) findViewById(R.id.word);
        word.setText(currentWord.getRussian());
    }
}
