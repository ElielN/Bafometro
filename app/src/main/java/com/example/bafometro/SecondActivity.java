package com.example.bafometro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SecondActivity extends AppCompatActivity {

    String classificacao = "";
    String teste = "a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent it = getIntent();
        Bundle params = it.getExtras();

        Button calcular = (Button) findViewById(R.id.calcular);


        Double alcoolemia = 0.0;
        Double coeficiente = 0.0;

        Double pesoSec = Double.valueOf(params.getString("peso"));
        String sexoSec = params.getString("sexo");
        Integer coposSec = Integer.valueOf(params.getString("copos"));
        String jejumSec = params.getString("jejum");

        if(jejumSec == "s") {
            if (sexoSec == "h") {
                coeficiente = 0.7;
            } else if (sexoSec == "m"){
                coeficiente = 0.6;
            }
        }
        else{
            coeficiente = 1.1;
        }
        alcoolemia = coposSec * 4.8 / (pesoSec * coeficiente);
        if(alcoolemia > 0.2){
            classificacao = "Taxa de alcoolemia: " + alcoolemia + "\n Classificação: Pessoa Alcoolizada";
        }
        else{
            classificacao = "Taxa de alcoolemia: " + alcoolemia + "\n Classificação: Pessoa NÃO Alcoolizada";
        }

        calcular.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                Intent it2 = new Intent(getBaseContext(), MainActivity.class);

                it2.putExtra("classificacao", classificacao);

                setResult(10, it2);
                finish();
            }
        });
    }
}