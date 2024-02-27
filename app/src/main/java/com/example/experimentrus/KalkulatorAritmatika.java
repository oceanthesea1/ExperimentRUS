package com.example.experimentrus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class KalkulatorAritmatika extends AppCompatActivity {

    private EditText input1;
    private EditText input2;
    private AppCompatButton buttonResult;
    private Spinner spOperator;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_aritmatika);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        buttonResult = findViewById(R.id.buttonResult);
        spOperator = findViewById(R.id.spinner);
        resultView = findViewById(R.id.resultView);

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedOperator = spOperator.getSelectedItem().toString();

                if (input1.getText().toString().isEmpty() || input2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    if ("Pilih".equals(selectedOperator)) {
                        Toast.makeText(getApplicationContext(), "Pilih Operator", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else {
                        int angka1Number = Integer.parseInt(input1.getText().toString());
                        int angka2Number = Integer.parseInt(input2.getText().toString());
                        int result;
                        double resultDecimal;

                        switch (selectedOperator)
                        {
                            case "Tambah (+)":
                                result = angka1Number + angka2Number;
                                resultView.setText("Result: " + result);
                                break;
                            case "Kurang (-)":
                                result = angka1Number - angka2Number;
                                resultView.setText("Result: " + result);
                                break;
                            case "Kali (*)":
                                result = angka1Number * angka2Number;
                                resultView.setText("Result: " + result);
                                break;
                            case "Bagi (/)":
                                if (angka1Number != 0 && angka2Number != 0) {
                                    resultDecimal = (double) angka1Number / angka2Number;
                                    resultView.setText("Result: " + resultDecimal);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Angka Tidak Boleh Nol", Toast.LENGTH_SHORT).show();
                                }
                                break;
                        }
                    }
                }
            }
        });
    }
}
