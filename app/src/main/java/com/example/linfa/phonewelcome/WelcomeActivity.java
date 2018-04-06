package com.example.linfa.phonewelcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author skylinelin
 * @date 2018/4/6
 */
public class WelcomeActivity extends AppCompatActivity {
    private Button mWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initViews();

        boolean b = checkIsFirst();

        if (b) {
            mWelcome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferencesUtil.getmInStance().put(WelcomeActivity.this, "isFirst", false);
                    enterHome();
                }
            });

        } else {
            enterHome();
        }
    }

    private void enterHome() {
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
    }

    /**
     * 检查是否是第一次启动
     */
    private boolean checkIsFirst() {
        boolean bool = (boolean) SharedPreferencesUtil.getmInStance().get(WelcomeActivity.this, "isFirst", true);
        return bool;
    }

    private void initViews() {

        mWelcome = findViewById(R.id.welcome);

    }
}
