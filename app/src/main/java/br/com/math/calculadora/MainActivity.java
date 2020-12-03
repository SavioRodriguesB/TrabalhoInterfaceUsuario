package br.com.math.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultadoJSTela, resultadoJCTela, resultadoDSTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String resultadoJS = intent.getStringExtra("ResultadoJS");
        String resultadoJC = intent.getStringExtra("ResultadoJC");
        String resultadoDS = intent.getStringExtra("ResultadoDS");

        resultadoJSTela = findViewById(R.id.resultadoJSMain);
        resultadoJCTela = findViewById(R.id.resultadoJCMain);
        resultadoDSTela = findViewById(R.id.resultadoDSMain);

        resultadoJSTela.setText(resultadoJS == null ? "Sem Resultado Recente" :"R$ " + resultadoJS);
        resultadoJCTela.setText(resultadoJC == null ? "Sem Resultado Recente" :"R$ " + resultadoJC);
        resultadoDSTela.setText(resultadoDS == null ? "Sem Resultado Recente" :"R$ " + resultadoDS);

        Button jurosSimples = findViewById(R.id.bJurosSimples);
        jurosSimples.setOnClickListener(calcularJurosSimples);

        Button jurosComposto = findViewById(R.id.bJurosComposto);
        jurosComposto.setOnClickListener(calcularJurosComposto);

        Button descontoSimples = findViewById(R.id.bDescontoSimples);
        descontoSimples.setOnClickListener(calcularDescontoSimples);
    }

    private View.OnClickListener calcularJurosSimples = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent telaJurosSimples = new Intent(MainActivity.this, CalculoJurosSimples.class);
            startActivity(telaJurosSimples);
            finish();
        }
    };

    private View.OnClickListener calcularJurosComposto = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent telaJurosComposto = new Intent(MainActivity.this, CalculoJurosComposto.class);
            startActivity(telaJurosComposto);
            finish();
        }
    };

    private View.OnClickListener calcularDescontoSimples = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent telaDescontoSimples = new Intent(MainActivity.this, DescontoSimples.class);
            startActivity(telaDescontoSimples);
            finish();
        }
    };

}