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
    private String op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.op = "11+112+3+4+5+1";

        operate = findViewById(R.id.equalsButton);
        Log.i("MainActivity", "dentro de onCreate");
            operate.setOnClickListener(view -> {
                Log.i("MainActivity", "dentro de onClickListener");

                if (!this.op.equals("")) {

                    Double ant = 0.0;
                    for (String op : op.split("\\+")) {
                        ant = calculadora.suma(ant,Double.parseDouble(op));
                    }

                    Intent intent = new Intent(this, CalculatorResultActivity.class);
                    intent.putExtra("resultado", ant);
                    startActivity(intent);
                } else {
                    Log.e("MainActivity", "Alguno de los operandos está vacío");
                }

            });
    }
}