package com.example.liaoxinying.jisuanqi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.spec.ECField;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final EditText et_2=(EditText) findViewById(R.id.et2);
        final EditText et_3=(EditText) findViewById(R.id.et3);
        final EditText et_8=(EditText) findViewById(R.id.et8);
        final EditText et_10=(EditText) findViewById(R.id.et10);
        final EditText et_16=(EditText) findViewById(R.id.et16);
        final Button but_trans=(Button) findViewById(R.id.button_trans);
        final Button but_clear=(Button) findViewById(R.id.button_clear);

        class ButtonListener implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                String temp=null,num2=null,num3=null,num8=null,num10=null,num16=null;

                switch(v.getId())
                {
                    case R.id.button_trans:{
                        if(et_2.hasFocus())
                        {
                            try{
                                temp=et_2.getText().toString();
                                num10=Integer.valueOf(temp,2).toString();
                                num3=Integer.toString(Integer.parseInt(num10),3).toString();
                                num8=Integer.toOctalString(Integer.parseInt(num10)).toString();
                                num16=Integer.toHexString(Integer.parseInt(num10)).toString();
                                et_3.setText(num3);
                                et_8.setText(num8);
                                et_10.setText(num10);
                                et_16.setText(num16);
                            }catch(Exception e){

                            }
                        }
                        else if(et_3.hasFocus())
                        {
                            try{
                                temp=et_3.getText().toString();
                                num10=Integer.valueOf(temp,3).toString();
                                num2=Integer.toBinaryString(Integer.parseInt(num10)).toString();
                                num8=Integer.toOctalString(Integer.parseInt(num10)).toString();
                                num16=Integer.toHexString(Integer.parseInt(num10)).toString();
                                et_2.setText(num2);
                                et_8.setText(num8);
                                et_10.setText(num10);
                                et_16.setText(num16);
                            }catch(Exception e){

                            }
                        }
                        else if(et_8.hasFocus())
                        {
                            try{
                                temp=et_8.getText().toString();
                                num10=Integer.valueOf(temp,8).toString();
                                num2=Integer.toBinaryString(Integer.parseInt(num10)).toString();
                                num3=Integer.toString(Integer.parseInt(num10)).toString();
                                num16=Integer.toHexString(Integer.parseInt(num10)).toString();
                                et_2.setText(num2);
                                et_3.setText(num3);
                                et_10.setText(num10);
                                et_16.setText(num16);
                            }catch(Exception e){

                            }
                        }
                        else if(et_10.hasFocus())
                        {
                            try{
                                temp=et_10.getText().toString();
                                num2=Integer.toBinaryString(Integer.parseInt(temp)).toString();
                                num3=Integer.toString(Integer.parseInt(temp),3).toString();
                                num8=Integer.toOctalString(Integer.parseInt(temp)).toString();
                                num16=Integer.toHexString(Integer.parseInt(temp)).toString();
                                et_2.setText(num2);
                                et_3.setText(num3);
                                et_8.setText(num8);
                                et_16.setText(num16);
                            }catch(Exception e){

                            }
                        }
                        else if(et_16.hasFocus())
                        {
                            try{
                                temp=et_16.getText().toString();
                                num10=Integer.valueOf(temp,16).toString();
                                num2=Integer.toBinaryString(Integer.parseInt(num10)).toString();
                                num3=Integer.toString(Integer.parseInt(num10),3).toString();
                                num8=Integer.toOctalString(Integer.parseInt(num10)).toString();
                                et_2.setText(num2);
                                et_3.setText(num3);
                                et_8.setText(num8);
                                et_10.setText(num10);
                            }catch (Exception e){

                            }
                        }

                    }
                    break;
                    case R.id.button_clear:{
                        et_2.setText("");
                        et_3.setText("");
                        et_8.setText("");
                        et_10.setText("");
                        et_16.setText("");
                    }
                    break;
                }
            }

        }
        but_trans.setOnClickListener(new ButtonListener());
        but_clear.setOnClickListener(new ButtonListener());
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
                Intent intent1 = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent1);
            }
            break;
            case R.id.science:{
                Intent intent1 = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(intent1);
            }
            break;
            case R.id.jinzhi:{
                Intent intent1 = new Intent(Main3Activity.this, Main3Activity.class);
                startActivity(intent1);
            }
            break;
            default:
        }
        return true;
    }

}

