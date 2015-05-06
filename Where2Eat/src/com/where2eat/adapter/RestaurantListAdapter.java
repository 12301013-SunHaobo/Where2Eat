package com.where2eat.adapter;

import java.util.HashMap;
import java.util.List;

import com.example.where2eat.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantListAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<HashMap<String, Object>> mData;

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
