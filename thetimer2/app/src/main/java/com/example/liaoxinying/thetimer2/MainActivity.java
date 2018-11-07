 package com.example.liaoxinying.thetimer2;

 import android.content.Intent;
 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et_day=(EditText)findViewById(R.id.et_day);
        final EditText et_hour=(EditText)findViewById(R.id.et_hour);
        final EditText et_minute=(EditText)findViewById(R.id.et_minute);
        final EditText et_second=(EditText)findViewById(R.id.et_second);

        Button bt_start=(Button) findViewById(R.id.bt_start);

        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day=et_day.getText().toString();
                String hour=et_hour.getText().toString();
                String minute=et_minute.getText().toString();
                String second=et_second.getText().toString();
                final int time=getTime(day,hour,minute,second);
                String strTime=String.valueOf(time);
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("time",strTime);
                startActivity(intent);
                finish();
            }
        });


    }

   public int getTime(String day,String hour,String minute,String second){
        int totalTime;
        int dayTime,hourTime,minuteTime,secondTime;
        dayTime=Integer.valueOf(day).intValue();
        hourTime=Integer.valueOf(hour).intValue();
        minuteTime=Integer.valueOf(minute).intValue();
        secondTime=Integer.valueOf(second).intValue();
        totalTime = dayTime * 86400000+hourTime * 3600000 + minuteTime * 60000 + secondTime * 1000;
        return totalTime;
    }
}
