package com.example.btgiaiptnhieumanhinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int INPUT_COEFFICIENTS_REQUEST = 1;
    private TextView textViewFormula;
    private EditText editTextResult;
    private double a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFormula = findViewById(R.id.textViewFormula);
        editTextResult = findViewById(R.id.editTextResult);
    }

    public void onInputCoefficientsClick(View view) {
        Intent intent = new Intent(this, Nhapheso.class);
        startActivityForResult(intent, INPUT_COEFFICIENTS_REQUEST);
    }

    public void onSolveEquationClick(View view) {
        double discriminant = b * b - 4 * a * c;
        Intent resultIntent = new Intent(this, ketqua.class);
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            resultIntent.putExtra("result", "Phương trình có 2 nghiệm:\n x1 = " + x1 + "\n x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            resultIntent.putExtra("result", "Phương trình có nghiệm kép:\n x = " + x);
        } else {
            resultIntent.putExtra("result", "Phương trình vô nghiệm");
        }
        startActivity(resultIntent);
    }

    public void onCloseAppClick(View view) {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == INPUT_COEFFICIENTS_REQUEST) {
            if (resultCode == RESULT_OK) {
                a = data.getDoubleExtra("a", 0);
                b = data.getDoubleExtra("b", 0);
                c = data.getDoubleExtra("c", 0);
                editTextResult.setText("Công thức: " + a + "x^2 + " + b + "x + " + c + " = 0");
            }
        }
    }
}
