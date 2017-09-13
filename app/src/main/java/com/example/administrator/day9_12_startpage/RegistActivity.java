package com.example.administrator.day9_12_startpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {

//    private ImageView img_return;
    private EditText et_phone;
    private EditText et_pwd;
    private Button btn_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
    }

    private void initView() {
//        img_return = (ImageView) findViewById(img_return);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        btn_regist = (Button) findViewById(R.id.btn_regist);

        btn_regist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String phone = et_phone.getText().toString().trim();
        String mima = et_pwd.getText().toString().trim();
        switch (v.getId()) {
            case R.id.btn_regist:
                if (TextUtils.isEmpty(phone)&&TextUtils.isEmpty(mima)) {
                    Toast.makeText(this, "请输入", Toast.LENGTH_SHORT).show();
                }else{
                startActivity(new Intent(RegistActivity.this,ValidationActivity.class));
                }
                break;
            case R.id.img_return:
                finish();
                break;
        }
    }
}
