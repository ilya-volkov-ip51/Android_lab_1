package com.example.illya.android_lab_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button okButton = (Button) findViewById(R.id.okButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final TextView outputText = (TextView) findViewById(R.id.outputText);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton selected = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                outputText.setText(editText.getText());
                String font = (String) selected.getText();
                switch (font) {
                    case "sans-serif-light": outputText.setTextAppearance(MainActivity.this, R.style.sansSerifLight); break;
                    case "sans-serif-medium": outputText.setTextAppearance(MainActivity.this, R.style.sansSerifMedium); break;
                    case "sans-serif": outputText.setTextAppearance(MainActivity.this, R.style.sansSerif); break;
                    case "sans-serif-condensed": outputText.setTextAppearance(MainActivity.this, R.style.sansSerifCondensed); break;
                }
                Toast.makeText(MainActivity.this, selected.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputText.setText("");
                editText.setText("");
            }
        });
    }
}
