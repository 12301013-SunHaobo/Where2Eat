package com.where2eat.activity;


import com.example.where2eat.R;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends BaseActivity implements OnClickListener{
	TextView regist;
	Button loginButton;
	EditText et_username, et_password;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == regist){
			Intent intent = new Intent(LoginActivity.this,
					RegistActivity.class);
			startActivity(intent);
		}else if(v == loginButton){
			Intent intent = new Intent(LoginActivity.this,
					MainActivity.class);
			startActivity(intent);
			//login();
		}
	}

	@Override
	public void setContentView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_login);
	}

	@Override
	public void initViews() {
		// TODO Auto-generated method stub
		Animation anim=AnimationUtils.loadAnimation(getBaseContext(), R.anim.login_anim);
		anim.setFillAfter(true);
		LinearLayout inputLayout = (LinearLayout) findViewById(R.id.input_box);
		inputLayout.startAnimation(anim);
		regist = (TextView) findViewById(R.id.btn_register);
		loginButton = (Button) findViewById(R.id.btn_login);
		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub
		regist.setOnClickListener(this);
		loginButton.setOnClickListener(this);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}
	
	private void login(){
		String name = et_username.getText().toString();
		String password = et_password.getText().toString();

		if (TextUtils.isEmpty(name)) {
			ShowToast(R.string.toast_error_username_null);
			return;
		}

		if (TextUtils.isEmpty(password)) {
			ShowToast(R.string.toast_error_password_null);
			return;
		}

		final ProgressDialog progress = new ProgressDialog(
				LoginActivity.this);
		progress.setMessage("ÕýÔÚµÇÂ½...");
		progress.setCanceledOnTouchOutside(false);
		progress.show();
		
		
		
	}
}

	

