package com.example.dell.jokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=findViewById(R.id.number);
    }

    public void submit(View view) {
          String number1=number.getText().toString();
        Intent intent = new Intent(this, JokesActivity.class);
        intent.putExtra("key", number1);
        startActivity(intent);
    }
}
