package br.com.math.calculadora;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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

public class DescontoSimples extends AppCompatActivity {

    EditText capital, taxaDesconto, duracao;
    Double capitalDouble, taxaDescontoDouble, duracaoDouble, resultado;
    TextView resultadoView, resultadoMensalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desconto_simples);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button voltar = findViewById(R.id.bVoltarDS);

        capital = findViewById(R.id.capitalDS);
        taxaDesconto = findViewById(R.id.taxaDescontoDS);
        duracao = findViewById(R.id.duracaoDS);
        resultadoView = findViewById(R.id.resultadoDS);
        resultadoMensalView = findViewById(R.id.resultadoDSP);

        capital.addTextChangedListener(pegarValorCapital);
        taxaDesconto.addTextChangedListener(pegarValorTaxaDesconto);
        duracao.addTextChangedListener(pegarValorDuracao);

        voltar.setOnClickListener(voltarActivity);

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

            if(capitalDouble != null && taxaDescontoDouble != null && duracaoDouble != null){
                resultado = capitalDouble*(taxaDescontoDouble/100)*duracaoDouble;
                NumberFormat formatter = new DecimalFormat("#0.00");

                resultadoView.setText("R$" + formatter.format(resultado).toString());
                resultadoMensalView.setText("R$" + formatter.format(resultado/duracaoDouble).toString());
            }else{
                resultadoView.setText("RESULTADO");
                resultadoMensalView.setText("RESULTADO");
            }
        }
    };

    private TextWatcher pegarValorTaxaDesconto = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(taxaDesconto.getText().toString().isEmpty()){
                taxaDescontoDouble = null;
            }else{
                taxaDescontoDouble = Double.parseDouble(taxaDesconto.getText().toString());
            }

            if(capitalDouble != null && taxaDescontoDouble != null && duracaoDouble != null){
                resultado = capitalDouble*(taxaDescontoDouble/100)*duracaoDouble;
                NumberFormat formatter = new DecimalFormat("#0.00");

                resultadoView.setText("R$" + formatter.format(resultado).toString());
                resultadoMensalView.setText("R$" + formatter.format(resultado/duracaoDouble).toString());
            }else{
                resultadoView.setText("RESULTADO");
                resultadoMensalView.setText("RESULTADO");
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

            if(capitalDouble != null && taxaDescontoDouble != null && duracaoDouble != null){
                resultado = capitalDouble*(taxaDescontoDouble/100)*duracaoDouble;
                NumberFormat formatter = new DecimalFormat("#0.00");

                resultadoView.setText("R$" + formatter.format(resultado).toString());
                resultadoMensalView.setText("R$" + formatter.format(resultado/duracaoDouble).toString());
            }else{
                resultadoView.setText("RESULTADO");
                resultadoMensalView.setText("RESULTADO");
            }
        }
    };

    private View.OnClickListener voltarActivity = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent menu = new Intent(DescontoSimples.this, MainActivity.class);
            NumberFormat formatter = new DecimalFormat("#0.00");
            menu.putExtra("ResultadoDS", resultado == null? null : formatter.format(resultado).toString());
            startActivity(menu);
            finish();
        }
    };
}