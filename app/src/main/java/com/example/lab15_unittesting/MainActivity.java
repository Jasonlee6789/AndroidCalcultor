package com.example.lab15_unittesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab15_unittesting.helpers.BasicCalculator;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAdd, btnSubstrct, btnMultiply, btnDivide;
    public double val1, val2, result;
    private boolean operating = false;
    private boolean decUsed = false;
    private boolean calculated = false;
    private String operator;
    private String tempNumber;
    private DecimalFormat format = new DecimalFormat("#,##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup viewGroup = findViewById(R.id.container);

        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof Button)
                view.setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        EditText editText = findViewById(R.id.edText1);

        switch (view.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                if (operating) {
                    tempNumber = editText.getText().toString();
                    editText.setText(button.getText());
                    operating = false;
                    decUsed = false;
                } else {
                    if (calculated || editText.getText() == null || editText.getText().toString().isEmpty()
                            || editText.getText().toString().equals("0")) {
                        editText.setText(button.getText());
                        calculated = false;
                    } else {
                        editText.setText(new StringBuilder(editText.getText()).append(button.getText()));
                    }
                    editText.setSelection(editText.getText().length());
                    break;
                }
                break;
            case R.id.btn_dec:
                if (!decUsed) {
                    editText.setText(new StringBuilder(editText.getText().append(button.getText())));
                }
                editText.setSelection(editText.getText().length());
                break;
            case R.id.btn_Add:
            case R.id.btn_Sub:
            case R.id.btn_Mul:
            case R.id.btn_Div:
                if (editText.getText() != null && !editText.getText().toString().isEmpty()) {
                    if (tempNumber != null && !tempNumber.isEmpty() && operator != null) {
                        String result = calculate(tempNumber, editText.getText().toString(), operator);
                        editText.setText(result);
                        editText.setSelection(editText.getText().length());
                        tempNumber = result;
                    }
                    operating = true;
                    operator = button.getText().toString();
                    calculated = false;
                }
                break;


            case R.id.btn_calc:

                if (tempNumber != null && !tempNumber.isEmpty() && operator != null) {
                    String result = calculate(tempNumber, editText.getText().toString(), operator);
                    editText.setText(result);
                    editText.setSelection(editText.getText().length());
                    tempNumber = null;
                    cleanOperation();
                    calculated = true;
                }
                operating = true;
                operator = button.getText().toString();
                calculated = false;

                break;

            case R.id.btn_clear:
                editText.setText("");
                cleanOperation();
                decUsed = false;
                tempNumber = null;
        }
    }



    private String calculate(String value1, String value2,String operator ){
            double num1 = Double.parseDouble(value1);
            double num2 = Double.parseDouble(value2);
            BasicCalculator calculator = new BasicCalculator(num1, num2);
            double rtnVal;

            switch (operator) {
                case "+":
                    rtnVal = calculator.add();
                    break;
                case "-":
                    rtnVal = calculator.subtract();
                    break;
                case "*":
                    rtnVal = calculator.multiply();
                    break;
                case "/":
                    rtnVal = calculator.divide();
                    break;
                default:
                    rtnVal = num1;
                    break;
            }
            return format.format(rtnVal);
        }
    private void cleanOperation() {
        operating = false;
        operator = null;
    }
    }
//
//    final BasicCalculator obj = new BasicCalculator(val1, val2);
//        btnAdd =findViewById(R.id.btn_Add);
//
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                obj.add();
//            }
//        });
//
//        btnSubstrct = findViewById(R.id.btn_Sub);
//
//        btnSubstrct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                obj.subtract();
//            }
//        });
//
//        btnMultiply = findViewById(R.id.btn_Mul);
//
//        btnMultiply.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                obj.multiply();
//            }
//        });
//
//        btnDivide = findViewById(R.id.btn_Div);
//
//         btnDivide.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 obj.divide();
//             }
//         });



