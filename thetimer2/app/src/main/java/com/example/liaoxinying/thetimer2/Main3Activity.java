package com.example.liaoxinying.thetimer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    String lingshengName="linsheng2.mp3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button bt_linsheng1=(Button) findViewById(R.id.linsheng1);
        Button bt_linsheng2=(Button) findViewById(R.id.linsheng2);
        Button bt_linsheng3=(Button) findViewById(R.id.linsheng3);

        bt_linsheng1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lingshengName="linsheng1.mp3";
                Intent intent =new Intent(Main3Activity.this,Main2Activity.class);
                intent.putExtra("lingshengName",lingshengName);
            }
        });
        bt_linsheng2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lingshengName="linsheng2.mp3";
                Intent intent =new Intent(Main3Activity.this,Main2Activity.class);
                intent.putExtra("lingshengName",lingshengName);
            }
        });
        bt_linsheng3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lingshengName="linsheng3.mp3";
                Intent intent =new Intent(Main3Activity.this,Main2Activity.class);
                intent.putExtra("lingshengName",lingshengName);
            }
        });
    }

}
