package com.where2eat.activity;


import com.example.where2eat.R;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashActivity extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		init();
	}
	@Override
	public void setContentView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_splash);

	}

	@Override
	public void initViews() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub

	}


	
	private void init(){

        new Handler().postDelayed(new Runnable() {
            public void run() {
            	Intent intent = new Intent(SplashActivity.this,
        				LoginActivity.class);
        		startActivity(intent);
        		SplashActivity.this.finish();
            }
        }, 2900); //2900 for release

    }
		
	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}
	
}
