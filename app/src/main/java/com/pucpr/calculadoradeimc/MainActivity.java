package com.pucpr.calculadoradeimc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText idadeEditTextNumber;
    EditText pesoEditTextNumberDecimal;
    EditText alturaEditTextNumberDecimal;

    TextView imcTextView;
    TextView classificacaoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.pink_light));
        idadeEditTextNumber = findViewById(R.id.idadeEditTextNumber);
        pesoEditTextNumberDecimal = findViewById(R.id.pesoEditTextNumberDecimal);
        alturaEditTextNumberDecimal = findViewById(R.id.alturaEditTextNumberDecimal);
        imcTextView = findViewById(R.id.imcTextView);
        classificacaoTextView = findViewById(R.id.classificacaoTextView);
        imcTextView.setText(" ");
        classificacaoTextView.setText(" ");
    }

    protected int getIntValueFromEditText(int id){
        String aux = null;
        if (id == 1) {
            aux = idadeEditTextNumber.getText().toString();
        }
        assert aux != null;
        return Integer.parseInt(aux);
    }

    protected float getFloatValueFromEditText(int id){
        String aux = null;
        if (id == 2) {
            aux = pesoEditTextNumberDecimal.getText().toString();
        } else if (id == 3) {
            aux = alturaEditTextNumberDecimal.getText().toString();
        }
        assert aux != null;
        return Float.parseFloat(aux);
    }

    public void calcularButtonOnClick(View v){
        float idade = getIntValueFromEditText(1);
        float peso = getFloatValueFromEditText(2);
        float altura = getFloatValueFromEditText(3);
        String classificacao;

        float imc = peso / (altura * altura);

        if(imc != 0) {
            imcTextView.setText(String.valueOf("O seu IMC é de: " + imc));
        }

        if (imc <= 15.9){
            classificacao = "Classificação do IMC: Magreza Grave";
            classificacaoTextView.setTextColor(Color.rgb(213,0,0));
            imcTextView.setTextColor(Color.rgb(213,0,0));
        } else if (imc > 15.9 && imc <= 16.9) {
            classificacao = "Classificação do IMC: Magreza Moderada";
            classificacaoTextView.setTextColor(Color.rgb(213,0,0));
            imcTextView.setTextColor(Color.rgb(213,0,0));
        } else if (imc > 16.9 && imc <= 18.4){
            classificacao = "Classificação do IMC: Magreza";
            classificacaoTextView.setTextColor(Color.rgb(214,106,44));
            imcTextView.setTextColor(Color.rgb(214,106, 44));
        } else if (imc > 18.4 && imc <= 24.9){
            classificacao = "Classificação do IMC: Normal";
            classificacaoTextView.setTextColor(Color.rgb(78,100,38));
            imcTextView.setTextColor(Color.rgb(78,100,38));
        } else if (imc > 24.9 && imc <= 29.9){
            classificacao = "Classificação do IMC: Sobrepeso";
            classificacaoTextView.setTextColor(Color.rgb(214,106,44));
            imcTextView.setTextColor(Color.rgb(214,106,44));
        } else if (imc > 29.9 && imc <= 34.9){
            classificacao = "Classificação do IMC: Obesidade Grau I";
            classificacaoTextView.setTextColor(Color.rgb(213,0,0));
            imcTextView.setTextColor(Color.rgb(213,0,0));
        } else if (imc > 34.9 && imc <= 39.9){
            classificacao = "Classificação do IMC: Obesidade Grau II";
            classificacaoTextView.setTextColor(Color.rgb(213,0,0));
            imcTextView.setTextColor(Color.rgb(213,0,0));
        } else {
            classificacao = "Classificação do IMC: Obesidade Grau III";
            classificacaoTextView.setTextColor(Color.rgb(213,0,0));
            imcTextView.setTextColor(Color.rgb(213,0,0));
        }

        classificacaoTextView.setText(String.valueOf(classificacao));
    }
}