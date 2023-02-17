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
        Log.i("MainActivity", "dentro de onCreate");

        operate.setOnClickListener(view -> {
            Log.i("MainActivity", "dentro de onClickListener");

            String xText = x.getText().toString();
            String yText = y.getText().toString();
            if(!xText.equals("") && !yText.equals("")){
                double op1 = Double.parseDouble(x.getText().toString());
                double op2 = Double.parseDouble(y.getText().toString());

                double result = calculadora.suma(op1, op2);

                Intent intent = new Intent(this,CalculatorResultActivity.class);
                intent.putExtra("resultado", result);

                startActivity(intent);
            } else {
                Log.e("MainActivity", "Alguno de los operandos está vacío");
            }

        });

    }
}