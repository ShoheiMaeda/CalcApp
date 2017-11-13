package jp.maeda.shohei.calcapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.plus);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.minus);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.multiply);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.divide);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);

        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {

        String editText1 = mEditText1.getText().toString();

        double val1 = 0;
        try{
            val1 = Double.parseDouble(editText1);
        }catch(Exception e){
            Toast.makeText(this, "数字以外の文字が入力されました。", Toast.LENGTH_LONG).show();
            return;
        }

        String editText2 = mEditText2.getText().toString();

        double val2 = 0;
        try{
            val2 = Double.parseDouble(editText2);
        }catch(Exception e){
            Toast.makeText(this, "数字以外の文字が入力されました。", Toast.LENGTH_LONG).show();
            return;
        }

        if(v.getId() == R.id.plus){
            result = val1 + val2 ;
        }else if(v.getId() == R.id.minus){
            result = val1 - val2 ;
        }else if(v.getId() == R.id.multiply){
            result = val1 * val2 ;
        }else{
            if(val2==0){
                Toast.makeText(this, "0では割れません。", Toast.LENGTH_LONG).show();
                return;
            }

            result = val1 / val2 ;
        }


        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", result);
        startActivity(intent);
    }
}