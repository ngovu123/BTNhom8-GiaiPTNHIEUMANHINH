package com.example.btgiaiptnhieumanhinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Nhapheso extends AppCompatActivity {
    private EditText editTextA, editTextB, editTextC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhapheso);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
    }

    public void onSubmitClick(View view) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double c = Double.parseDouble(editTextC.getText().toString());

        Intent resultIntent = new Intent();
        resultIntent.putExtra("a", a);
        resultIntent.putExtra("b", b);
        resultIntent.putExtra("c", c);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}