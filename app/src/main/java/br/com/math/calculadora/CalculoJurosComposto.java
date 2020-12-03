package br.com.math.calculadora;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CalculoJurosComposto extends AppCompatActivity {

    EditText capital, taxaJuros, duracao;
    Double capitalDouble, taxaJurosDouble, duracaoDouble, resultado;
    TextView resultadoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_juros_composto);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button voltar = findViewById(R.id.bVoltarJC);
        Button parcial = findViewById(R.id.bResultadoJCP);

        capital = findViewById(R.id.capitalJC);
        taxaJuros = findViewById(R.id.taxaJurosJC);
        duracao = findViewById(R.id.duracaoJC);
        resultadoView = findViewById(R.id.resultadoJC);

        capital.addTextChangedListener(pegarValorCapital);
        taxaJuros.addTextChangedListener(pegarValorTaxaJuros);
        duracao.addTextChangedListener(pegarValorDuracao);

        voltar.setOnClickListener(voltarActivity);
        parcial.setOnClickListener(gerarParcial);
    }

    private TextWatcher pegarValorCapital = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(capital.getText().toString().isEmpty()){
                capitalDouble = null;
            }else{
                capitalDouble = Double.parseDouble(capital.getText().toString());
            }

            if(capitalDouble != null && taxaJurosDouble != null && duracaoDouble != null){
                resultado = capitalDouble*Math.pow(1+(taxaJurosDouble/100),duracaoDouble);
                NumberFormat formatter = new DecimalFormat("#0.00");

                resultadoView.setText("R$" + formatter.format(resultado).toString());
            }else{
                resultadoView.setText("RESULTADO");
            }
        }
    };

    private TextWatcher pegarValorTaxaJuros = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(taxaJuros.getText().toString().isEmpty()){
                taxaJurosDouble = null;
            }else{
                taxaJurosDouble = Double.parseDouble(taxaJuros.getText().toString());
            }

            if(capitalDouble != null && taxaJurosDouble != null && duracaoDouble != null){
                resultado = capitalDouble*Math.pow(1+(taxaJurosDouble/100),duracaoDouble);
                NumberFormat formatter = new DecimalFormat("#0.00");

                resultadoView.setText("R$" + formatter.format(resultado).toString());
            }else{
                resultadoView.setText("RESULTADO");
            }
        }
    };

    private TextWatcher pegarValorDuracao = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(duracao.getText().toString().isEmpty()){
                duracaoDouble = null;
            }else{
                duracaoDouble = Double.parseDouble(duracao.getText().toString());
            }

            if(capitalDouble != null && taxaJurosDouble != null && duracaoDouble != null){
                resultado = capitalDouble*Math.pow(1+(taxaJurosDouble/100),duracaoDouble);
                NumberFormat formatter = new DecimalFormat("#0.00");

                resultadoView.setText("R$" + formatter.format(resultado).toString());
            }else{
                resultadoView.setText("RESULTADO");
            }
        }
    };

    private View.OnClickListener voltarActivity = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent menu = new Intent(CalculoJurosComposto.this, MainActivity.class);
            NumberFormat formatter = new DecimalFormat("#0.00");
            menu.putExtra("ResultadoJC", resultado == null? null : formatter.format(resultado).toString());
            startActivity(menu);
            finish();
        }
    };

    private View.OnClickListener gerarParcial = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent menu = new Intent(CalculoJurosComposto.this, CalculoJurosCompostoParcial.class);
            NumberFormat formatter = new DecimalFormat("#0.00");
            menu.putExtra("capital", capitalDouble);
            menu.putExtra("taxaJuros", taxaJurosDouble);
            menu.putExtra("duracao", duracaoDouble);
            startActivity(menu);
            finish();
        }
    };
}