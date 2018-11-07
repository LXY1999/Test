package com.example.liaoxinying.thetimer2;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlarmManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private ImageView mIv;
    private MediaPlayer mediaPlayer=new MediaPlayer();
    private CountdownDrawable mCdDrawable;
    private Animator mAnimator;
    String lingshengName = "linsheng2.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        String strTime=intent.getStringExtra("time");
        final int time=Integer.valueOf(strTime).intValue();

        final ImageView mIv = (ImageView)findViewById(R.id.iv);

        mCdDrawable = new CountdownDrawable(getResources().getDimensionPixelSize(R.dimen.drawable_ring_size),  getResources().getColor(R.color.dark_grey), getResources().getColor(R.color.brightly_grey)
                , getResources().getColor(R.color.holo_green_light), time/1000, getResources().getColor(R.color.red));
        mIv.setImageDrawable(mCdDrawable);

        //AlarmManager alarmManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);

        Button bt_start=(Button) findViewById(R.id.bt_start2);
        Button bt_end=(Button) findViewById(R.id.bt_end2);
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);
        RadioButton rb_ls0=(RadioButton) findViewById(R.id.rb_ls0);
        RadioButton rb_ls1=(RadioButton) findViewById(R.id.rb_ls1);
        RadioButton rb_ls2=(RadioButton) findViewById(R.id.rb_ls2);
        RadioButton rb_ls3=(RadioButton) findViewById(R.id.rb_ls3);

        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnimator != null) {
                    mAnimator.cancel();
                }
                mIv.setVisibility(View.VISIBLE);
                mAnimator = prepareAnimator(time);
                mAnimator.start();
            }
        });

        bt_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if(ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Main2Activity.this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else{
            MyRadioButtonListener mrb=new MyRadioButtonListener();
            rg1.setOnCheckedChangeListener(mrb);
        }

    }

    class MyRadioButtonListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // 选中状态改变时被触发
            switch (checkedId) {
                case R.id.rb_ls0:
                    Toast.makeText(Main2Activity.this, "已设置铃声为静音 ", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rb_ls1:
                    Toast.makeText(Main2Activity.this, "已设置铃声为铃声1 ", Toast.LENGTH_SHORT).show();
                    initMediaPlayer1();
                    break;
                case R.id.rb_ls2:
                    Toast.makeText(Main2Activity.this, "已设置铃声为铃声2 ", Toast.LENGTH_SHORT).show();
                    initMediaPlayer2();
                    break;
                case R.id.rb_ls3:
                    Toast.makeText(Main2Activity.this, "已设置铃声为铃声3 ", Toast.LENGTH_SHORT).show();
                    initMediaPlayer3();
                    break;
                default:
                    break;
            }
        }
    }

    private Animator prepareAnimator(int time1) {
        AnimatorSet animation = new AnimatorSet();

        // 进度条动画
        ObjectAnimator progressAnimator = ObjectAnimator.ofFloat(mCdDrawable, "progress", 1f, 0f);
        progressAnimator.setDuration(time1);
        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
               if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                //mIv.setVisibility(View.GONE);
            }
        });

        // 居中的倒计时数字
        ObjectAnimator showNumberAnimator = ObjectAnimator.ofInt(mCdDrawable, "showNumber", time1/1000, 0);
        showNumberAnimator.setDuration(time1);
        showNumberAnimator.setInterpolator(new LinearInterpolator());

        animation.playTogether(progressAnimator, showNumberAnimator);
        return animation;
    }

    private void initMediaPlayer1(){
        try{
            File file= new File(Environment.getExternalStorageDirectory(),"linsheng1.mp3");
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initMediaPlayer2(){
        try{
            File file= new File(Environment.getExternalStorageDirectory(),"linsheng2.mp3");
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initMediaPlayer3(){
        try{
            File file= new File(Environment.getExternalStorageDirectory(),"linsheng3.mp3");
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void onRequestPermissionResult(int requestCode,String[] permissions,int[] grantResults){
        switch(requestCode){
            case 1:
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    initMediaPlayer2();
                }else {
                    Toast.makeText(this,"拒绝权限将无法使用程序",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
            break;
        }
    }


    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
