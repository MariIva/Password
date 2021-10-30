package ru.arizara.password;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.et_password);
        textView = (TextView) findViewById(R.id.tv_out);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = editText.getText().toString();
                String out = "Пароль подходит";

                if (!ValidPassword.stringLenght(pass)){
                    out = "Пароль менее 6 символов";
                }
                else if(ValidPassword.invalidSymbol(pass)){
                    out = "Пароль содержит неверные символы";
                }
                else if(!ValidPassword.containsDigit(pass)){
                    out = "Пароль должен содержать цифры";
                }
                else if(!ValidPassword.containsLetter(pass)){
                    out = "Пароль должен содержать буквы";
                }
                else if(!ValidPassword.containsLowLetter(pass)){
                    out = "Пароль должен содержать строчные буквы";
                }
                else if(!ValidPassword.containsUpLetter(pass)){
                    out = "Пароль должен содержать прописные буквы";
                }

                textView.setText(out);
            }
        });

    }
}