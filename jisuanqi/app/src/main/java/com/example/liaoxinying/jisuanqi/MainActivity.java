package com.example.liaoxinying.jisuanqi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import jisuan.*;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        final EditText et=(EditText) findViewById(R.id.editView_1);
        et.setInputType(InputType.TYPE_NULL);
        final TextView tv=(TextView) findViewById(R.id.textView_1);

        Button but_clear = (Button) findViewById(R.id.button_clear);
        but_clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText("");
                tv.setText("");
            }
        });

        Button but_back = (Button) findViewById(R.id.button_back);
        but_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!et.getText().toString().isEmpty())
                {
                    String text=et.getText().toString();
                    text=text.substring(0,text.length()-1);
                    et.setText(text);
                }
            }
        });

        Button but_plus = (Button) findViewById(R.id.button_plus);
        but_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"+");
            }
        });
        Button but_1 = (Button) findViewById(R.id.button_1);
        but_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"1");
            }
        });
        Button but_2 = (Button) findViewById(R.id.button_2);
        but_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"2");
            }
        });
        Button but_3 = (Button) findViewById(R.id.button_3);
        but_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"3");
            }
        });
        Button but_minus = (Button) findViewById(R.id.button_minus);
        but_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"-");
            }
        });
        Button but_4 = (Button) findViewById(R.id.button_4);
        but_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"4");
            }
        });
        Button but_5 = (Button) findViewById(R.id.button_5);
        but_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"5");
            }
        });
        Button but_6 = (Button) findViewById(R.id.button_6);
        but_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"6");
            }
        });
        Button but_multi= (Button) findViewById(R.id.button_multi);
        but_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"*");
            }
        });
        Button but_7 = (Button) findViewById(R.id.button_7);
        but_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"7");
            }
        });
        Button but_8 = (Button) findViewById(R.id.button_8);
        but_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"8");
            }
        });
        Button but_9 = (Button) findViewById(R.id.button_9);
        but_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"9");
            }
        });
        Button but_is = (Button) findViewById(R.id.button_is);
        but_is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = et.getText().toString();
                /*double result=InfixToSuffix.getResult(InfixToSuffix.getSuffix(InfixToSuffix.getArrayList(inputText)));
                String result_s=String.valueOf(result);*/
                double result=stringToResult.eval(inputText);
                String result_s=String.valueOf(result);
                tv.setText(result_s);
            }
        });
        Button but_point = (Button) findViewById(R.id.button_point);
        but_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+".");
            }
        });
        Button but_0 = (Button) findViewById(R.id.button_0);
        but_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"0");
            }
        });
        Button but_divide = (Button) findViewById(R.id.button_divide);
        but_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"/");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.normal: {
                Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent1);
            }
                break;
            case R.id.science:{
                Intent intent1 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent1);
            }
                break;
            case R.id.jinzhi:{
                Intent intent1 = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent1);
            }
                break;
            default:
        }
        return true;
    }

}
