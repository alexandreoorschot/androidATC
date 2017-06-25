package com.example.alexandre.dividirconta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button botao = (Button) findViewById(R.id.button);
        final EditText texto_valor = (EditText) findViewById(R.id.editText);
        final EditText texto_pessoas = (EditText) findViewById(R.id.editText2);
        final EditText texto_final = (EditText) findViewById(R.id.editText3);
        final CheckBox checa = (CheckBox) findViewById(R.id.checkBox);
        texto_valor.setText("");
        checa.setText("Gorjeta do garçon(+10%)");
        texto_valor.setHint("Valor");
        texto_pessoas.setText("");
        texto_pessoas.setHint("Pessoas");
        texto_final.setText("");
        texto_final.setHint("Valor final");
        botao.setOnClickListener(new View.OnClickListener(){
           public void onClick (View v){
               try {
                   double valor;
                   double pessoas;
                   double valor_final;
                   String texto_excrever;
                   valor = Double.parseDouble(texto_valor.getText().toString());
                   pessoas = Double.parseDouble(texto_pessoas.getText().toString());
                   if (checa.isChecked()) {
                       valor_final = (valor * 1.1) / pessoas;
                   } else {
                       valor_final = (valor) / pessoas;
                   }
                   texto_excrever = Double.toString(valor_final);
                   texto_final.setText(texto_excrever);
               }
               catch(Exception e){
                   Toast torrada = Toast.makeText(getApplication().getBaseContext(),"Calculos com erro",Toast.LENGTH_SHORT);
                   torrada.show();
               }
           }
        });
        checa.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                botao.performClick();
            }
        });
    }
}
