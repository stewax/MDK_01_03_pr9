package com.example.pr9;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.uicomponents.button.BthBig;
import com.example.uicomponents.button.BthCustom;
import com.example.uicomponents.button.TbBig;
import com.example.uicomponents.button.TbCustom;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        BthBig bthPrimary = findViewById(R.id.bthPrimary);
        BthBig bthEnable = findViewById(R.id.bthEnable);
        BthBig bthTertiary = findViewById(R.id.bthTertiary);
        BthBig bthSecondary = findViewById(R.id.bthSecondary);

        bthPrimary.init("Отправить", BthCustom.TypeButton.PRIMARY);
        bthEnable.setEnabled(false);
        bthTertiary.init("Авторизоваться", BthCustom.TypeButton.TERTIARY);
        bthTertiary.init("Забыли пароль?", BthCustom.TypeButton.SECONDARY);

        TbBig tbSurname = findViewById(R.id.tbPrimary);
        TbBig tbNumbers = findViewById(R.id.tbActivity);

        String ErrorText = "Фамилия должна содержать только буквы";
        String ErrorNumber = "Только цифры!!!!";

        tbSurname.init(
                "Укажите фамилию",
                "Введите фамилию",
                "",
                TbCustom.TypeText.PRIMARY,
                ErrorText
        );

        tbNumbers.init("Напишите циферки", "Много циферок", "", TbCustom.TypeText.PRIMARY, ErrorNumber);

        tbSurname.editText.addTextChangedListener(new android.text.TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(android.text.Editable s) {
                tbSurname.validateLettersOnly(ErrorText);
            }
        });

        tbNumbers.editText.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {
                tbNumbers.validateNumbersOnly(ErrorNumber);
            }
        });
    }
}