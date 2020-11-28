package com.example.bafometro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enviarDados = (Button) findViewById(R.id.enviarDados);

        final EditText peso = (EditText) findViewById(R.id.pesoInput);
        final EditText sexo = (EditText) findViewById(R.id.sexoInput);
        final EditText copos = (EditText) findViewById(R.id.coposInput);
        final EditText jejum = (EditText) findViewById(R.id.jejumInput);


        enviarDados.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                String varPeso = peso.getText().toString();
                String varSexo = sexo.getText().toString();
                String varCopos = copos.getText().toString();
                String varJejum = jejum.getText().toString();

                Intent it = new Intent(getBaseContext(), SecondActivity.class);
                Bundle params = new Bundle();

                params.putString("peso", varPeso);
                params.putString("sexo", varSexo);
                params.putString("copos", varCopos);
                params.putString("jejum", varJejum);

                it.putExtras(params);
                startActivityForResult(it, 10);

            }
        });

    }

    @Override
    protected void onActivityResult(int codigoRequisicao, int codigoResultado, Intent it) {
        super.onActivityResult(codigoRequisicao, codigoResultado, it);

        if(it != null){
            if(codigoRequisicao == 10){
                String resultado = it.getStringExtra("classificacao");

                Toast.makeText(getBaseContext(),resultado,Toast.LENGTH_LONG).show();
            }
        }
    }



}