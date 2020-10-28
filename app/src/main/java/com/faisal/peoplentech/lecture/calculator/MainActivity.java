package com.faisal.peoplentech.lecture.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvHistory, tvDisplay;
    Button btn7, btn8, btnAdd, btnEqual;
    Double a, b, result;
    int operationalFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnEqual.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String tem = "";
        switch (view.getId()) {
            case R.id.btn7:
                tem = tvDisplay.getText().toString();
                tvDisplay.setText(tem + "7");
                break;
            case R.id.btn8:
                tem = tvDisplay.getText().toString();
                tvDisplay.setText(tem + "8");
                break;
            case R.id.btnAdd:
                tem = tvDisplay.getText().toString();
                a = Double.parseDouble(tem);
                tvHistory.setText(tem + "+");
                operationalFlag = 1;
                tvDisplay.setText("");
                break;
            case R.id.btnEql:
                tem = tvDisplay.getText().toString();
                b = Double.parseDouble(tem);
                long intB=b.intValue();
                switch (operationalFlag) {
                    case 1:
                        result = a + b;
                        break;
                }
                tem = tvHistory.getText().toString();
                tem = tem + String.valueOf(intB) + "=";
                tvHistory.setText(tem);
                tvDisplay.setText(String.valueOf(result.intValue()));
                break;
        }
    }

    private void init() {
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btnAdd = findViewById(R.id.btnAdd);
        btnEqual = findViewById(R.id.btnEql);
        tvHistory = findViewById(R.id.tvHistory);
        tvDisplay = findViewById(R.id.tvDisplay);
    }
}
