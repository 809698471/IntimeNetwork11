package com.example.administrator.day9_12_startpage;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ValidationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_return;
    private EditText et_validation;
    private Button btn_validation;
    private Button btn_commit;
    private int num;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);
        initView();
    }

    private void initView() {
        img_return = (ImageView) findViewById(R.id.img_return);
        et_validation = (EditText) findViewById(R.id.et_validation);
        btn_validation = (Button) findViewById(R.id.btn_validation);
        btn_commit = (Button) findViewById(R.id.btn_commit);

        btn_validation.setOnClickListener(this);
        btn_commit.setOnClickListener(this);
        img_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String yanzheng = et_validation.getText().toString().trim();
        switch (v.getId()) {
            case R.id.btn_validation:
                CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        // TODO Auto-generated method stub
                        btn_validation.setText(+ millisUntilFinished / 1000 + "s");
                        btn_validation.setEnabled(false);
                    }
                    @Override
                    public void onFinish() {
//                        btn_yanzheng.setText("倒计时完毕了");
                        btn_validation.setEnabled(true);
                    }
                }.start();
                num = (int) (100000 + (Math.random() * (999999 - 100000 + 1)));
                Toast.makeText(this, "验证码:"+num, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_commit:
                if (TextUtils.isEmpty(yanzheng)) {
                    Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(new Intent(ValidationActivity.this,LoginActivity.class));
                }
                break;
            case R.id.img_return:
                finish();
                break;
        }
    }

}
