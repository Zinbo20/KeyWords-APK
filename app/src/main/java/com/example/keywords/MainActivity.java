package com.example.keywords;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

        Button bt;
        TextView tv;
        FloatingActionButton fa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView3);
        fa = (FloatingActionButton) findViewById(R.id.floatingActionButton2);

        fa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv.setText("\n     Thank You!");
            }
        });
        bt = (Button) findViewById (R.id.button);

        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });

    }
}
