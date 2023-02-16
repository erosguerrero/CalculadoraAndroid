package es.ucm.fdi.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Calculator calculadora = new Calculator();
    private EditText x,y;
    private Button operate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x = findViewById(R.id.op1);
        y = findViewById(R.id.op2);
        operate = findViewById(R.id.boton);

        operate.setOnClickListener(view -> {

            double result = calculadora.suma(Double.parseDouble(x.getText().toString()),Double.parseDouble(y.getText().toString()));
            Intent intent = new Intent(this,CalculatorResultActivity.class);
            intent.putExtra("resultado", result);
            startActivity(intent);

        });

    }
}