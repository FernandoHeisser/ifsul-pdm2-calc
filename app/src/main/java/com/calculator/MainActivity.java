package com.calculator;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText editTextValue1, editTextValue2, editTextResult;
    private RadioGroup radioGroup;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValue1 = findViewById(R.id.editText);
        editTextValue2 = findViewById(R.id.editText2);
        editTextResult = findViewById(R.id.editText3);
        radioGroup = findViewById(R.id.radioGroup);
        Button buttonResult = findViewById(R.id.button);
        Button buttonClear = findViewById(R.id.button2);

        buttonResult.setOnClickListener(view -> {
            String string1 = editTextValue1.getText().toString();
            String string2 = editTextValue2.getText().toString();

            if (string1.isEmpty() || string2.isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "Digite os valores corretamente", Toast.LENGTH_SHORT).show();
                return;
            }

            double value1 = Double.parseDouble(string1);
            double value2 = Double.parseDouble(string2);

            int selectedId = radioGroup.getCheckedRadioButtonId();

            RadioButton radioButton = findViewById(selectedId);

            if (Objects.isNull(radioButton)) {
                Toast.makeText(MainActivity.this,
                        "Selecione uma operação", Toast.LENGTH_SHORT).show();
                return;
            }

            String operation = radioButton.getText().toString();

            switch (operation) {
                case "Soma":
                    editTextResult.setText(String.valueOf(value1+value2));
                    break;
                case "Subtração":
                    editTextResult.setText(String.valueOf(value1-value2));
                    break;
                case "Divisão":
                    editTextResult.setText(String.valueOf(value1/value2));
                    break;
                case "Multiplicação":
                    editTextResult.setText(String.valueOf(value1*value2));
                    break;
            }
        });

        buttonClear.setOnClickListener(view -> {
            finish();
            startActivity(getIntent());
        });
    }
}