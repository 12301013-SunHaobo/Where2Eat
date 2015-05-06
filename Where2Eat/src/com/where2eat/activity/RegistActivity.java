package com.where2eat.activity;


import com.example.where2eat.R;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegistActivity extends BaseActivity implements OnClickListener {
	Button btn_back,registButton;
	EditText et_username, et_password, et_repassword,et_email;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btn_back){
			finish();
		}else if(v == registButton) {
			regist();
		}
		
	}

	@Override
	public void setContentView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_regist);
	}

	@Override
	public void initViews() {
		// TODO Auto-generated method stub
		btn_back = (Button) findViewById(R.id.btn_back);
		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		et_repassword = (EditText) findViewById(R.id.et_repassword);
		et_email = (EditText) findViewById(R.id.et_email);
		registButton = (Button) findViewById(R.id.btn_register);
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub
		btn_back.setOnClickListener(this);
		registButton.setOnClickListener(this);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}
	/*
	 * 判断输入信息
	 */
	private void regist(){
		String name = et_username.getText().toString();
		String password = et_password.getText().toString();
		String repassword = et_repassword.getText().toString();
		String email = et_email.getText().toString();
		if (TextUtils.isEmpty(name)) {
			ShowToast(R.string.toast_error_username_null);
			return;
		}

		if (TextUtils.isEmpty(password)) {
			ShowToast(R.string.toast_error_password_null);
			return;
		}
		if (!repassword.equals(password)) {
			ShowToast(R.string.toast_error_comfirm_password);
			return;
		}
		if (TextUtils.isEmpty(email)) {
			ShowToast(R.string.toast_error_email_null);
			return;
		}
		
		
		final ProgressDialog progress = new ProgressDialog(RegistActivity.this);
		progress.setMessage("正在注册...");
		progress.setCanceledOnTouchOutside(false);
		progress.show();
		
	}

}
