package com.where2eat.activity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.where2eat.R;

import android.os.Bundle;
import android.os.Handler;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements OnClickListener {
	
	private ListView listView;
	private List<HashMap<String, Object>> mData;
	Button btn_self;
	RestaurantListAdapter adapter;
	private TextView address;
	private LocationClient mLocationClient;
	private TextView LocationResult;
	private Handler handler = new Handler();
	private Runnable runnable = new Runnable(){
		public void run (){
			setTitle(LocationResult.getText());
			handler.postDelayed(this,1000);
			address.setText(LocationResult.getText());
		}
	};
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		address = (TextView)findViewById(R.id.tv_address);
		mLocationClient = ((LocationApplication)getApplication()).mLocationClient;
		LocationResult = new TextView(this);
		((LocationApplication)getApplication()).mLocationResult = LocationResult;
		InitLocation();
		LocationResult.setText("定位中。。。");
		setTitle("定位中。。。");
		address.setText("定位中");
	}
	
	@Override
	protected void onStart(){
		mLocationClient.start();
		handler.postDelayed(runnable,1000); // 开始Timer
		super.onStart();
	}
	@Override
	protected void onStop() {
		mLocationClient.stop();
		handler.removeCallbacks(runnable); //停止Timer 
		super.onStop();
	}

	private void InitLocation(){
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);//设置定位模式
		option.setCoorType("gcj02");//定位使用的坐标系
		option.setScanSpan(1000);//设置发起定位请求的间隔时间为1000ms
		option.setIsNeedAddress(true);//需要显示地址
		mLocationClient.setLocOption(option);
	}

	public void onClick(View v) {
		if (v == btn_self){
			Intent intent = new Intent(MainActivity.this,
					SelfActivity.class);
			startActivity(intent);
		}
		
	}
	
	@Override
	public void setContentView() {
		setContentView(R.layout.activity_main);
	}

	@Override
	public void initViews() {
		btn_self = (Button) findViewById(R.id.btn_self);
		mData = getData();//为刚才的变量赋值
		listView = (ListView) findViewById(R.id.list_restaurant);//实例化ListView
		adapter = new RestaurantListAdapter(this);//创建一个适配器
	    listView.setAdapter(adapter);//为ListView控件绑定适配器
	}

	@Override
	public void initListeners() {
		btn_self.setOnClickListener(this);
	}

	@Override
	public void initData() {
	}
	
	//初始化一个List
	  public List<HashMap<String, Object>> getData() {
	    // 新建一个集合类，用于存放多条数据
	    ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
	    HashMap<String, Object> map = null;
	    for (int i = 1; i <= 10; i++) {
	      map = new HashMap<String, Object>();
	      map.put("restaurant_name",i+"号餐厅" );
	      map.put("restaurant_type", "川菜");
	      map.put("price", "￥50/人");
	      map.put("restaurant_icon", R.drawable.default_restaurant_icon);
	      list.add(map);
	    }

	    return list;
	  }
	
	  public class RestaurantListAdapter extends BaseAdapter {
			private LayoutInflater mInflater;

			public RestaurantListAdapter(Context context){
				this.mInflater = LayoutInflater.from(context); 
			}
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mData.size();// ListView的条目数
			}

			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
		    public View getView(int position, View convertView, ViewGroup parent) {
		      convertView = mInflater.inflate(R.layout.restaurant_list_item, null);//根据布局文件实例化view
		      TextView restaurant_name = (TextView) convertView.findViewById(R.id.restaurant_name);//找某个控件
		      restaurant_name.setText(mData.get(position).get("restaurant_name").toString());//给该控件设置数据(数据从集合类中来)
		      TextView restaurant_type = (TextView) convertView.findViewById(R.id.restaurant_type);//找某个控件
		      restaurant_type.setText(mData.get(position).get("restaurant_type").toString());//给该控件设置数据(数据从集合类中来)
		      TextView price = (TextView) convertView.findViewById(R.id.price);
		      price.setText(mData.get(position).get("price").toString());
		      ImageView restaurant_icon = (ImageView) convertView.findViewById(R.id.restaurant_icon);
		      restaurant_icon.setBackgroundResource((Integer) mData.get(position).get("restaurant_icon"));
		      return convertView;
		    }
			
			
		}


}