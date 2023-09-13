package com.example.prac4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    private TextView Text1;
    private TextView Text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        Text1 = findViewById(R.id.textView1);
        Text2 = findViewById(R.id.textView2);

        int num1 = intent.getIntExtra("num1",0);
        int num2 = intent.getIntExtra("num2",0);

        Text1.setText("Number : "+num1);
        Text2.setText("Number : "+num2);

        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = num1 + num2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",res);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = num1 - num2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",res);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}