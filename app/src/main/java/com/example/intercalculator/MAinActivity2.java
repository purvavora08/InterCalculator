package com.example.intercalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MAinActivity2 extends AppCompatActivity {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char PERCENT = '%';
    private char currentSymbol;
    private double firstValue = Double.NaN;
    private double secondValue = Double.NaN;
    private double ThirdValue;
    EditText inputDisplay;
    private TextView  outputDisplay, inputDisplay2;
    private DecimalFormat decimalFormat;
    private MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonDot, buttonAdd, buttonSub, buttonMultiply, buttonDivide, buttonPercent, buttonClear, buttonOFF, buttonEqual;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decimalFormat = new DecimalFormat("#.##########");
        inputDisplay = findViewById(R.id.input);
//        inputDisplay2 = findViewById(R.id.input2);
        outputDisplay = findViewById(R.id.output);
        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonAdd = findViewById(R.id.add);
        buttonSub = findViewById(R.id.subtract);
        buttonDivide = findViewById(R.id.division);
        buttonDot = findViewById(R.id.btnPoint);
        buttonMultiply = findViewById(R.id.multiply);
        buttonClear = findViewById(R.id.clear);
        buttonOFF = findViewById(R.id.off);
        buttonEqual = findViewById(R.id.equal);
        buttonPercent = findViewById(R.id.percent);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() +"0");

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() +"1");

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "2");

            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = ADDITION;
                outputDisplay.setText(decimalFormat.format(firstValue) + "+");
                inputDisplay.setText(null);
                inputDisplay2.setText(null);
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                outputDisplay.setText(decimalFormat.format(ThirdValue));
                firstValue = Double.NaN;
                currentSymbol = '0';
            }
        });
    }
    private void allCalculations(){
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(inputDisplay2.getText().toString());
            inputDisplay2.setText(null);
            inputDisplay.setText(null);
            if (currentSymbol == ADDITION)
                ThirdValue = firstValue + secondValue;
            else if (currentSymbol == SUBTRACTION)
                ThirdValue = firstValue - secondValue;
            else if (currentSymbol == MULTIPLICATION)
                ThirdValue = firstValue * secondValue;
            else if (currentSymbol == DIVISION)
                ThirdValue = firstValue / secondValue;
            else if (currentSymbol == PERCENT)
                ThirdValue = firstValue % secondValue;
        } else {
            try {
                ThirdValue = Double.parseDouble(inputDisplay2.getText().toString());
            } catch (Exception e) {
            }
        }
    }
}
