package com.example.first_kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }
    public void OnClear(View view)
    {
        textView.setText("");
    }
    // обработка нажатия на числовую кнопку
    public void onNumberClick(View view){
        Button button = (Button)view;
        textView.append(button.getText());
    }
    public void OnResult(View view)
    {
        char[] example = textView.getText().toString().toCharArray();
        double firstNum = 0;
        double secondNum = 0;
        boolean FirstOrTwo = false;
        char oper = ' ';

        for(int i = 0;i < example.length;i++)
        {
            if(example[i] == '+' || example[i] == '-' || example[i] == '/' || example[i] == 'X' || example[i] == '%')
            {
                FirstOrTwo = true;
                oper = example[i];
            }
            if(FirstOrTwo == false)
            {
                firstNum += example[i];
            }
            else if(example[i] != '+')
            {
                secondNum = example[i];
            }
        }
        firstNum -= 48;
        secondNum -= 48;
        switch(oper)
        {
            case '+':
                firstNum += secondNum;
                break;
            case '-':
                firstNum -= secondNum;
                break;
            case 'X':
                firstNum *= secondNum;
                break;
            case '/':
                firstNum /= secondNum;
                break;

        }
        textView.setText(Double.toString(firstNum));
    }
}