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
