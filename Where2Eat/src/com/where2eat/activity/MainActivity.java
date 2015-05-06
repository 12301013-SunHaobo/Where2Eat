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
		LocationResult.setText("��λ�С�����");
		setTitle("��λ�С�����");
		address.setText("��λ��");
	}
	
	@Override
	protected void onStart(){
		mLocationClient.start();
		handler.postDelayed(runnable,1000); // ��ʼTimer
		super.onStart();
	}
	@Override
	protected void onStop() {
		mLocationClient.stop();
		handler.removeCallbacks(runnable); //ֹͣTimer 
		super.onStop();
	}

	private void InitLocation(){
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);//���ö�λģʽ
		option.setCoorType("gcj02");//��λʹ�õ�����ϵ
		option.setScanSpan(1000);//���÷���λ����ļ��ʱ��Ϊ1000ms
		option.setIsNeedAddress(true);//��Ҫ��ʾ��ַ
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
		mData = getData();//Ϊ�ղŵı�����ֵ
		listView = (ListView) findViewById(R.id.list_restaurant);//ʵ����ListView
		adapter = new RestaurantListAdapter(this);//����һ��������
	    listView.setAdapter(adapter);//ΪListView�ؼ���������
	}

	@Override
	public void initListeners() {
		btn_self.setOnClickListener(this);
	}

	@Override
	public void initData() {
	}
	
	//��ʼ��һ��List
	  public List<HashMap<String, Object>> getData() {
	    // �½�һ�������࣬���ڴ�Ŷ�������
	    ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
	    HashMap<String, Object> map = null;
	    for (int i = 1; i <= 10; i++) {
	      map = new HashMap<String, Object>();
	      map.put("restaurant_name",i+"�Ų���" );
	      map.put("restaurant_type", "����");
	      map.put("price", "��50/��");
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
				return mData.size();// ListView����Ŀ��
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
		      convertView = mInflater.inflate(R.layout.restaurant_list_item, null);//���ݲ����ļ�ʵ����view
		      TextView restaurant_name = (TextView) convertView.findViewById(R.id.restaurant_name);//��ĳ���ؼ�
		      restaurant_name.setText(mData.get(position).get("restaurant_name").toString());//���ÿؼ���������(���ݴӼ���������)
		      TextView restaurant_type = (TextView) convertView.findViewById(R.id.restaurant_type);//��ĳ���ؼ�
		      restaurant_type.setText(mData.get(position).get("restaurant_type").toString());//���ÿؼ���������(���ݴӼ���������)
		      TextView price = (TextView) convertView.findViewById(R.id.price);
		      price.setText(mData.get(position).get("price").toString());
		      ImageView restaurant_icon = (ImageView) convertView.findViewById(R.id.restaurant_icon);
		      restaurant_icon.setBackgroundResource((Integer) mData.get(position).get("restaurant_icon"));
		      return convertView;
		    }
			
			
		}


}