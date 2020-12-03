package br.com.math.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CalculoJurosCompostoParcial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_juros_composto_parcial);

        Button voltar = findViewById(R.id.bVoltarJCP);
        TextView resultadoText = findViewById(R.id.resultadoJCP);

        Intent intent = getIntent();

        Double capital = intent.getDoubleExtra("capital", 0);
        Double taxaJuros = intent.getDoubleExtra("taxaJuros", 0);
        Double duracao = intent.getDoubleExtra("duracao", 0);

        String resultado = "";
        Double resultadoOperacao;

        NumberFormat formatter = new DecimalFormat("#0.00");

        for(int i = 1; i <= duracao ; i++){

            resultadoOperacao = capital+(capital*(taxaJuros/100));
            resultado = resultado.concat("Mês " + i)
                                 .concat("  R$ ").concat(String.valueOf(formatter.format(resultadoOperacao-capital)))
                                 .concat("  R$ ").concat(String.valueOf(formatter.format(resultadoOperacao)))
                                 .concat("\n");
            capital = resultadoOperacao;
        }

        resultadoText.setText(resultado);
        voltar.setOnClickListener(voltarActivity);

    }

    private View.OnClickListener voltarActivity = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent menu = new Intent(CalculoJurosCompostoParcial.this, CalculoJurosComposto.class);
            startActivity(menu);
            finish();
        }
    };
}