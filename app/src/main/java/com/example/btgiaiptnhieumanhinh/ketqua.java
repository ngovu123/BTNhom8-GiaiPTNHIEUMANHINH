package com.example.btgiaiptnhieumanhinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class ketqua extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua);

        TextView textViewResult = findViewById(R.id.textViewResult);
        String result = getIntent().getStringExtra("result");
        textViewResult.setText(result);
    }

    public void onBackToMainClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Kết thúc ResultActivity để ngăn người dùng quay lại từ nút "Quay lại"
    }
}