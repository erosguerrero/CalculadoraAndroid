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

        Double result = intent.getDoubleExtra("resultado",0);
        String text = String.valueOf(result);

        if (isInt(result)){
            text = String.valueOf(result.intValue());
        }

        textoResultado.setText(text);




    }

    private boolean isInt(double n){
        return n == (int) n;
    }
}