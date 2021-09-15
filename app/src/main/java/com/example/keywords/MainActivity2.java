package com.example.keywords;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button bt1;
    Button bt2;
    EditText ed_caption;
    TextView tv_counter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_counter = (TextView) findViewById(R.id.textView9);
        ed_caption = (EditText) findViewById(R.id.editText2);

        bt1 = (Button) findViewById (R.id.button4);
        bt1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tv_counter.setText("Escreva mais que um Caractere.");
            }
        });
        bt2 = (Button) findViewById (R.id.button3);
        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv_counter.setText("Escreva mais que um Caractere.");
            }
        });

        ed_caption.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() >= 2) {
                    tv_counter.setText("");
                    bt1 = (Button) findViewById (R.id.button4);
                    bt1.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                            Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                            i.putExtra("MSG", "Criptografia");
                            String key = ed_caption.getText().toString();
                            i.putExtra("Chave", key);
                            startActivity(i);
                        }
                    });
                    bt2 = (Button) findViewById (R.id.button3);
                    bt2.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){

                            Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                            i.putExtra("MSG", "Descriptografia");
                            String key = ed_caption.getText().toString();
                            i.putExtra("Chave", key);
                            startActivity(i);
                        }
                    });
                }
                else {
                    bt1 = (Button) findViewById (R.id.button4);
                    bt1.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                            tv_counter.setText("Escreva mais que um Caractere.");
                        }
                    });
                    bt2 = (Button) findViewById (R.id.button3);
                    bt2.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            tv_counter.setText("Escreva mais que um Caractere.");
                        }
                    });
                }
                //
            }
        });


    }
}