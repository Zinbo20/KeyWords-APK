package com.example.keywords;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity3 extends AppCompatActivity {

    TextView tv;
    TextView tv1;
    EditText ed;
//    Button bt1;
    FloatingActionButton buttonCopiar;
    FloatingActionButton buttonColar;
    TextView editCopiar;
    EditText editColar;

    String h = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    String r = "abcdefghijklmnopqrstuvwxyz ";
    char [] t = r.toCharArray();
    char [] r2 = r.toCharArray();
    char [] h2 = h.toCharArray();
    int u=0; int b=0; int z=0; int a=0; int k=0; int l=0; int m=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

            tv = findViewById(R.id.textView4);
            tv1 = findViewById(R.id.textView6);
            tv1.setMovementMethod(new ScrollingMovementMethod());
            ed = (EditText) findViewById(R.id.editText);
//          bt1 = (Button) findViewById (R.id.floatingActionButton3);
        buttonCopiar = findViewById(R.id.buttonCopiar);
//        buttonColar = findViewById(R.id.buttonColar);
    Intent intent = getIntent();
            final String MSG = intent.getStringExtra("MSG");
            final String key = intent.getStringExtra("Chave");
            final char[] x = key.toCharArray();
            tv.setText(MSG);
            String nada = "                          ";
            final char[] y = nada.toCharArray();

        for (int i = 0; i < key.toString().length(); i++) {
            u = 1;
            for (int q = 0; q < 26; q++) {
                if ((x[i] == h2[q]) && (u == 1)) {
                    x[i] = t[q];
                    u = 0;
                }
            }
        }
//        for(int i=0; i < key.toString().length(); i++ ) {
//            tv1.setText(tv1.getText()+""+x[i]);
//        }
//        tv1.setText(tv1.getText()+"\n");

                 // Parte 1
                for (int i = 0; i < key.toString().length(); i++) {
            u = 1;
            for (int q = i + 1; q < key.toString().length(); q++) {
                if (x[i] == x[q] && u == 1) {
                    u = 0;
                    x[i] = ' ';
                }
            }
        }

        for (int i = 0; i < key.toString().length(); i++) {
            if (x[i] != ' ') {
                x[b] = x[i];
                b++;
            }
        }

        for (int i = 0; i < key.toString().length(); i++) {
            u = 1;
            for (int q = i + 1; q < key.toString().length(); q++) {
                if (x[i] == x[q] && u == 1) {
                    u = 0;
                    x[q] = ' ';
                }
            }
        }

                // Parte 2
                for (int i = 0; i < 26; i++) {
                    for (int q = 0; q < b; q++) {
                        if (t[i] == x[q]) {
                            t[i] = ' ';
                        }
                    }
                }

                for (int i = 0; i < b; i++) {
                    if (t[i] != ' ') {
                        a++;
                        y[a] = t[i];
                        t[i] = ' ';
                    }
                }

                for (int i = b; i < 26; i++) {
                    for (int q = b; q < 26; q++) {
                        if (t[q] == ' ') t[q] = t[q - 1];
                        if (t[q] == t[q + 1]) t[q] = t[q - 1];
                    }
                }

                for (int i = 0; i < b; i++) {
                    t[i] = x[i];
                }
                for (int i = b; i < b + a; i++) {
                    if (t[i] == ' ') {
                        z++;
                        t[i] = y[z];
                    }
                }

        ed.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = ed.getText().toString();
                char[] y2 = text.toCharArray();

                if (MSG.equals("Criptografia")) {
                    //Parte 3
                    if (1 <= text.toString().length()) {
                        for (int i = 0; i < text.toString().length(); i++) {
                            u = 1;
                            for (int q = 0; q < 26; q++) {
                                if ((y2[i] == r2[q]) && (u == 1)) {
                                    y2[i] = t[q];
                                    u = 0;
                                }
                            }
                        }
                        for (int i = 0; i < text.toString().length(); i++) {
                            u = 1;
                            for (int q = 0; q < 26; q++) {
                                if ((y2[i] == h2[q]) && (u == 1)) {
                                    y2[i] = t[q];
                                    u = 0;
                                }
                            }
                        }
                        k = 0;
                        for (int i = 0; i < text.toString().length(); i++) {
                            k = r.toString().length() / key.toString().length();
                            if (y2[i] == ' ') {
                                y2[i] = y2[i];
                            }
                            else {
                                y2[i] = (char) (y2[i] + k);
                            }
                        }
                        int j = 0;                                                // print o texto
                        if(text.toString().length()==1){
                            j = 1;
                        }
                        tv1.setText("");
                        for (int i = j; i < text.toString().length(); i++) {
                        tv1.setText(tv1.getText() + "" + y2[i]);
                         }
                        String text1 = tv1.getText().toString();
                        tv1.setText("");
                        tv1.setText(""+text1);


                    }}

                else{                                                         //Des

                    k=0;
                    for(int i=0; i < text.toString().length(); i++){
                        k= r.toString().length() / key.toString().length();
                        if(y2[i]==' '){
                            y2[i]=y2[i];
                        }
                        else{
                            y2[i] = (char) (y2[i] - k);
                        }}

                    for(int i=0; i < text.toString().length(); i++){
                        u=1;
                        for(int q=0; q < 26; q++){
                            if((y2[i]==t[q])&&(u==1)){
                                y2[i]=r2[q];
                                u=0;
                            }}}
                    int j = 0;                                             // print o texto
                    if(text.toString().length()==1){
                        j = 1;
                    }
                    tv1.setText("");
                    for (int i = j; i < text.toString().length(); i++) {
                        tv1.setText(tv1.getText() + "" + y2[i]);
                    }
                    String text1 = tv1.getText().toString();
                    tv1.setText("");
                    tv1.setText(""+text1);

                }

                buttonCopiar.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        copiarParaAreaDeTransferencia();
                    }
                });
//                buttonColar.setOnClickListener(new View.OnClickListener(){
//                    public void onClick(View v){
//                         colarDaAreaDeTransferencia();
//                    }
//                });
                //Copia o texto pra área de transferência

            }});
   }

    private void copiarParaAreaDeTransferencia() {
        editCopiar = (TextView) findViewById(R.id.textView6);
        editColar = (EditText) findViewById(R.id.editText);
        ClipboardManager Copiar = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        Copiar.setText(editCopiar.getText());
        //Mostra um toast ao clicar no botão "copiar". Pode ser retirado se quiser, não vai fazer diferença
        Toast.makeText(MainActivity3.this, "Texto Copiado", Toast.LENGTH_SHORT).show();
    }
    //Cola o texto que estava na área de transferência
//    private void colarDaAreaDeTransferencia() {
//        ClipboardManager Colar = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//        editColar.setText(Colar.getText());
//    }
}
//mgjsxy
//             for(int i=0; i < 26; i++ ) {
//        tv1.setText(tv1.getText()+""+t[i]);
//        }
//            for(int i=0; i < key.toString().length(); i++ ) {
//        tv1.setText(tv1.getText()+""+x[i]);
//        }
//           tv1.setText(tv1.getText()+"\n");
//                    if (text.length() <= 1) {
//                        text1 = text1.substring (0, s.length() - 1);
//                    }
//                bt1.setOnClickListener(new View.OnClickListener(){
//                  public void onClick(View v){
//
//                 }
//                });