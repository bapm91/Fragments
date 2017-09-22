package com.example.slava.fragments.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.slava.fragments.R;
import com.example.slava.fragments.fragments.FirstFragment;
import com.example.slava.fragments.fragments.SecondFragment;
import com.example.slava.fragments.fragments.ThirdFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_first_fragment).setOnClickListener(this);
        findViewById(R.id.bt_second_fragment).setOnClickListener(this);
        findViewById(R.id.bt_second_activity).setOnClickListener(this);
        findViewById(R.id.bt_third_fragment).setOnClickListener(this);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new FirstFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.bt_first_fragment:
                fragmentTransaction.replace(R.id.frameLayout, new FirstFragment());
                fragmentTransaction.commit();
                break;

            case R.id.bt_second_fragment:
                fragmentTransaction.replace(R.id.frameLayout, new SecondFragment());
                fragmentTransaction.commit();
                break;

            case R.id.bt_third_fragment:
                fragmentTransaction.replace(R.id.frameLayout, new ThirdFragment());
                fragmentTransaction.commit();
                break;

            case R.id.bt_second_activity:
                Intent intent = new Intent(this, SimpleActivity.class);
                startActivity(intent);
                break;
        }
    }
}
