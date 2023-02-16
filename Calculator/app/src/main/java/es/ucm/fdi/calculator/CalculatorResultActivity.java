package es.ucm.fdi.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CalculatorResultActivity extends AppCompatActivity {
    private TextView textoResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_result);
        textoResultado = findViewById(R.id.textoResultado);
        Intent intent = getIntent();
        double result = intent.getDoubleExtra("resultado",0);
        int r = (int) result;
        textoResultado.setText((r==result)?String.valueOf(r):String.valueOf(result));
    }
}