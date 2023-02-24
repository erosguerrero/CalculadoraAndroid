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

    private static final String TAG = "MainActivity";
    private static final String KEY_OP_ACTUAL = "opActual";
    private TextView operate;
    private String op = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operate = findViewById(R.id.operationText);

        if (savedInstanceState != null) {
            Log.i(TAG, "Dentro de comprobacion de savedInstance en onCreate");
            this.op = savedInstanceState.getString(KEY_OP_ACTUAL, "");
            operate.setText(op);
        }
        //this.op = "11+112+3+4+5+1";
    }

    public void operates(View view){
        Log.i(TAG, "dentro de onClickListener");

        if (!this.op.equals("")) {

            Double ant = 0.0;

            for (String op : op.split("\\+")) {
                if (!op.equals(""))
                    ant = calculadora.suma(ant,Double.parseDouble(op));
            }

            Intent intent = new Intent(this, CalculatorResultActivity.class);
            intent.putExtra("resultado", ant);
            startActivity(intent);
        } else {
            Log.e(TAG, "Alguno de los operandos está vacío");
        }
    }

    public void buttonToOperate(View view){

        TextView texto = (TextView) view;
        String operation = texto.getText().toString();

        boolean correct = true;

        if (operation.equals(".")){

            char[] chars = this.op.toCharArray();


            for (int i = chars.length - 1; i >= 0 && chars[i] != '+'; i--){
                if (chars[i] == '.')
                    correct = false;
            }

            if (chars.length == 0 || (chars.length > 0 && chars[chars.length - 1] == '+'))
                correct = false;

        }


        if (correct){
            this.op += operation;
            operate.setText(op);
        }



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
            Log.e(TAG, "Se esta intentando borrar y no hay elementos");
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putString(KEY_OP_ACTUAL, this.op);
    }
}