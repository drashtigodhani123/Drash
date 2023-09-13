package com.example.prac4_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        editText1 = findViewById(R.id.editTextNumber1);
        editText2 = findViewById(R.id.editTextNumber2);
        textview = findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, " Please Insert Text",Toast.LENGTH_SHORT).show();
                }
                else{
                    int num1 = Integer.parseInt(editText1.getText().toString());
                    int num2 = Integer.parseInt(editText2.getText().toString());
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("num1",num1);
                    intent.putExtra("num2",num2);
                    startActivityForResult(intent,1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(requestCode==RESULT_OK){
                int result = data.getIntExtra("result", 0);
                textview.setText(""+result);
            }
            else if(requestCode==RESULT_CANCELED){
                textview.setText("Nothing selected");
            }
        }
    }
}