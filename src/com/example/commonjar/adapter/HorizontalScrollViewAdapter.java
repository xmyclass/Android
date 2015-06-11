package com.example.commonjar.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.commonjar.R;

/**
 * @author admin
 * 自定义图片适配器，继承BaseAdapter
 */
public class HorizontalScrollViewAdapter extends BaseAdapter{

	//定义上下文
	private Context mContext;
	private LayoutInflater mInflater;
	private List<Integer> mDatas;

	public HorizontalScrollViewAdapter(Context context, List<Integer> mDatas) {
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		this.mDatas = mDatas;
	}

	//得到图片的大小
	@Override
	public int getCount() {
		return mDatas.size();
	}

	//得到指定图片的对象
	@Override
	public Object getItem(int position) {
		return mDatas.get(position);
	}

	//得到指定图片的对象的ID
	@Override
	public long getItemId(int position) {
		return position;
	}

	//显示图标列表
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(
					R.layout.activity_index_gallery_item, parent, false);
			viewHolder.mImg = (ImageView) convertView
					.findViewById(R.id.id_index_gallery_item_image);
			viewHolder.mText = (TextView) convertView
					.findViewById(R.id.id_index_gallery_item_text);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.mImg.setImageResource(mDatas.get(position));
		viewHolder.mText.setText("some info ");

		return convertView;
	}

	private class ViewHolder {
		ImageView mImg;
		TextView mText;
	}

}
