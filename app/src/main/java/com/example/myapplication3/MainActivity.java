package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private TextView textViewTv;
    private double firstVar;
    private double secondVar;
    private boolean isOperationClick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTv = findViewById(R.id.tv_result);
    }

    public void onNuberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setNumbers("1");
                break;
            case R.id.two_number:
                setNumbers("2");
                break;
            case R.id.three_btn:
                setNumbers("3");
                break;
            case R.id.four_btn:
                setNumbers("4");
                break;
            case R.id.five_btn:
                setNumbers("5");
                break;
            case R.id.six_btn:
                setNumbers("6");
                break;
            case R.id.seven_btn:
                setNumbers("7");
                break;
            case R.id.eight_btn:
                setNumbers("8");
                break;
            case R.id.iam_btn:
                setNumbers("9");
                break;
            case R.id.null_btn:
                if (textViewTv.getText().toString().equals("0")) {
                    textViewTv.setText("0");
                } else {
                    textViewTv.append("0");

                }

                break;
            case R.id.clear_text:
                textViewTv.setText("0");
                firstVar = 0;
                secondVar = 0;
                break;
            case R.id.dot_btn:
                setNumbers(".");
        }

    }

    private void setNumbers(String numbers) {
        if (textViewTv.getText().toString().equals("0")) {
            textViewTv.setText(numbers);
        } else if (isOperationClick) {
            textViewTv.setText(numbers);
        } else {
            textViewTv.append(numbers);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus_btn:
                firstVar = Double.parseDouble(textViewTv.getText().toString());
                operation = "+";
                isOperationClick = true;
                break;
            case R.id.delenie_btn:
                firstVar = Double.parseDouble(textViewTv.getText().toString());
                operation = "/";
                isOperationClick = true;
                break;
            case R.id.umnojenie_btn:
                firstVar = Double.parseDouble(textViewTv.getText().toString());
                operation = "x";
                isOperationClick = true;
                break;
            case R.id.equals_btn:

                secondVar = Double.parseDouble(textViewTv.getText().toString());
                Double result1 = Double.valueOf(0);
                switch (operation) {
                    case "-":
                        result1 = firstVar - secondVar;
                        break;
                    case "+":
                        result1 = firstVar + secondVar;
                        break;
                    case "/":
                        result1 = firstVar / secondVar;
                        break;
                    case "x":
                        result1 = firstVar * secondVar;

                    case ".":
                        String str = textViewTv.getText().toString().trim();
                        if (textViewTv.length() > 0) {
                            textViewTv.setText(str + ".");
                        } else {
                            textViewTv.setText("0.");
                        }
                }

                textViewTv.setText(new DecimalFormat("##.#####").format(result1));
                isOperationClick = true;
                break;
            case R.id.minus_btn:
                firstVar = Double.parseDouble(textViewTv.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;

        }


    }

}
