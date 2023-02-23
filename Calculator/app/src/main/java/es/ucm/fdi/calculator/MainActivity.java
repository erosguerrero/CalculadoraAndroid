package es.ucm.fdi.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Calculator calculadora = new Calculator();
    private EditText x,y;
    private TextView operate;
    private String op = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operate = findViewById(R.id.operationText);
        //this.op = "11+112+3+4+5+1";
    }
    public void operates(View view){
        Log.i("MainActivity", "LOLOLOLdentro de onClickListener");

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
    }

    public void buttonToOperate(View view){
        TextView texto = (TextView) view;
        this.op+=texto.getText().toString();
        operate.setText(op);
    }

    public void eraseLast(View view)
    {
        if(this.op.length() > 0)
        {
            String aux = this.op.substring(0, this.op.length()-1);
            this.op = aux;
            operate.setText(op);
        }
        else {
            Log.e("MainActivity", "Se esta intentando borrar y no hay elementos");
        }

    }
}