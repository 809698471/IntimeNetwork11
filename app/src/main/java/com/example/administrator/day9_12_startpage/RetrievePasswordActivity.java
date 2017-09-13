package com.example.administrator.day9_12_startpage;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class RetrievePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private EditText my_iPhone;
    private EditText my_Code;
    private Button Code_button;
    private EditText my_Password;
    private Button Retieve_button;
    private int s = 0;
    private int time = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_password);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        my_iPhone = (EditText) findViewById(R.id.my_iPhone);
        my_Code = (EditText) findViewById(R.id.my_Code);
        Code_button = (Button) findViewById(R.id.Code_button);
        my_Password = (EditText) findViewById(R.id.my_Password);
        Retieve_button = (Button) findViewById(R.id.Retieve_button);

        Code_button.setOnClickListener(this);
        Retieve_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Code_button:

                Random random = new Random();
                s = random.nextInt(8999) + 1000;
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                PendingIntent pend = PendingIntent.getActivity(this, 0, new Intent(RetrievePasswordActivity.this, RetrievePasswordActivity.class), 0);
                NotificationCompat.Builder buli = new NotificationCompat.Builder(this);
                buli.setDefaults(Notification.DEFAULT_VIBRATE);//默认震动
                buli.setTicker("请查收你的验证码!!!");
                buli.setSmallIcon(R.mipmap.ic_launcher);
                buli.setContentTitle("验证码提示：");
                buli.setContentText("<中国原谅帽公司有限出品>，您的验证码为：" + s +"，本公司不会以任何名义索要你的验证码请不要上当");
                buli.setContentIntent(pend);
                buli.setNumber(1);
                buli.setWhen(System.currentTimeMillis());
                Notification notification = buli.build();
                notification.flags |= Notification.FLAG_AUTO_CANCEL;
                manager.notify(1, notification);

                CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        // TODO Auto-generated method stub
                        Code_button.setText("还剩" + millisUntilFinished / 1000 + "s");
                        Code_button.setEnabled(false);
                    }

                    @Override
                    public void onFinish() {
                        Code_button.setText("倒计时完毕了");
                        Code_button.setEnabled(true);
                    }
                }.start();
                break;
            case R.id.Retieve_button:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String iPhone = my_iPhone.getText().toString().trim();
        if (TextUtils.isEmpty(iPhone)) {
            Toast.makeText(this, "请输入您的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String Code = my_Code.getText().toString().trim();
        if (TextUtils.isEmpty(Code)) {
            Toast.makeText(this, "请输入您的验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        String Password = my_Password.getText().toString().trim();
        if (TextUtils.isEmpty(Password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Code.equals(s)) {
            Toast.makeText(RetrievePasswordActivity.this, "您输入的验证码有误,请检查", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(RetrievePasswordActivity.this, "找回密码成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, RetrievePasswordActivity.class));

        }


    }
}
