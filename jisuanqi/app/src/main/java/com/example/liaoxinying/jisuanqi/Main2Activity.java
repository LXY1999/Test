package com.example.liaoxinying.jisuanqi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import jisuan.stringToResult;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText et=(EditText) findViewById(R.id.editView_1);
        et.setInputType(InputType.TYPE_NULL);
        final TextView tv=(TextView) findViewById(R.id.textView_1);

        Button but_leftkuo = (Button) findViewById(R.id.button_leftkuo);
        Button but_rightkuo = (Button) findViewById(R.id.button_rightkuo);
        Button but_daoshu = (Button) findViewById(R.id.button_daoshu);
        Button but_pinfang = (Button) findViewById(R.id.button_pinfang);
        Button but_lifang = (Button) findViewById(R.id.button_lifang);
        Button but_cifang = (Button) findViewById(R.id.button_cifang);
        Button but_clear = (Button) findViewById(R.id.button_clear);
        Button but_divide = (Button) findViewById(R.id.button_divide);
        Button but_multi = (Button) findViewById(R.id.button_multi);
        Button but_back = (Button) findViewById(R.id.button_back);
        Button but_jiecheng = (Button) findViewById(R.id.button_jiecheng);
        Button but_kaifang = (Button) findViewById(R.id.button_kaifang);
        Button but_kainfang = (Button) findViewById(R.id.button_kainfang);
        Button but_7 = (Button) findViewById(R.id.button_7);
        Button but_8 = (Button) findViewById(R.id.button_8);
        Button but_9 = (Button) findViewById(R.id.button_9);
        Button but_minus = (Button) findViewById(R.id.button_minus);
        Button but_e = (Button) findViewById(R.id.button_e);
        Button but_ln = (Button) findViewById(R.id.button_ln);
        Button but_log = (Button) findViewById(R.id.button_log);
        Button but_4 = (Button) findViewById(R.id.button_4);
        Button but_5 = (Button) findViewById(R.id.button_5);
        Button but_6 = (Button) findViewById(R.id.button_6);
        Button but_plus = (Button) findViewById(R.id.button_plus);
        Button but_sin = (Button) findViewById(R.id.button_sin);
        Button but_cos = (Button) findViewById(R.id.button_cos);
        Button but_tan = (Button) findViewById(R.id.button_tan);
        Button but_1 = (Button) findViewById(R.id.button_1);
        Button but_2 = (Button) findViewById(R.id.button_2);
        Button but_3 = (Button) findViewById(R.id.button_3);
        Button but_is = (Button) findViewById(R.id.button_is);
        Button but_pi = (Button) findViewById(R.id.button_pi);
        Button but_percent = (Button) findViewById(R.id.button_percent);
        Button but_0 = (Button) findViewById(R.id.button_0);
        Button but_point = (Button) findViewById(R.id.button_point);

        but_0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"0");
            }
        });
        but_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"1");
            }
        });
        but_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"2");
            }
        });
        but_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"3");
            }
        });
        but_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"4");
            }
        });
        but_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"5");
            }
        });
        but_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"6");
            }
        });
        but_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"7");
            }
        });
        but_8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"8");
            }
        });
        but_9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"9");
            }
        });
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
        but_cifang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"^(");
            }
        });
        but_clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText("");
                tv.setText("");
            }
        });
        but_cos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"cos");
            }
        });
        but_daoshu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"^(-1)");
            }
        });
        but_divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"/");
            }
        });
        but_e.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"(1E)");
            }
        });
        but_is.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String inputText = et.getText().toString();
                /*double result=InfixToSuffix.getResult(InfixToSuffix.getSuffix(InfixToSuffix.getArrayList(inputText)));
                String result_s=String.valueOf(result);*/
                double result= stringToResult.eval(inputText);
                String result_s=String.valueOf(result);
                tv.setText(result_s);
            }
        });
        but_jiecheng.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"!");
            }
        });
        but_kaifang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"√");
            }
        });
        but_kainfang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"^(1/");
            }
        });
        but_leftkuo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"(");
            }
        });
        but_lifang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"^(3)");
            }
        });
        but_ln.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"ln");
            }
        });
        but_log.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"log");
            }
        });
        but_minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"-");
            }
        });
        but_multi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"*");
            }
        });
        but_percent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"%");
            }
        });
        but_pi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"(1π)");
            }
        });
        but_pinfang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"^(2)");
            }
        });
        but_plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"+");
            }
        });
        but_point.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+".");
            }
        });
        but_rightkuo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+")");
            }
        });
        but_sin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"sin");
            }
        });
        but_tan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"tan");
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
                Intent intent1 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent1);
            }
            break;
            case R.id.science:{
                Intent intent1 = new Intent(Main2Activity.this, Main2Activity.class);
                startActivity(intent1);
            }
            break;
            case R.id.jinzhi:{
                Intent intent1 = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent1);
            }
            break;
            default:
        }
        return true;
    }



}
