package com.example.commonjar.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.commonjar.R;
import com.example.commonjar.activity.MyHorizontalScrollView.CurrentImageChangeListener;
import com.example.commonjar.activity.MyHorizontalScrollView.OnItemClickListener;
import com.example.commonjar.adapter.HorizontalScrollViewAdapter;

/**
 * @author admin
 * 图片左右滑动
 */
public class MyHorizontalScrollViewActivity extends Activity{
	
	private MyHorizontalScrollView mHorizontalScrollView;
	private HorizontalScrollViewAdapter mAdapter;
	private ImageView mImg;
	private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(
			R.drawable.image1, R.drawable.image2, R.drawable.image3, 
			R.drawable.image4, R.drawable.image5, R.drawable.image6, 
			R.drawable.image7, R.drawable.image8, R.drawable.image9));
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//隐藏标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.horizontal_scroll_view_2);
		init();
	}
	
	/**
	 * 初始化控件
	 */
	private void init(){
		mImg = (ImageView) findViewById(R.id.id_content);
		mHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.id_horizontalScrollView);
		mAdapter = new HorizontalScrollViewAdapter(this, mDatas);
		
		//添加滚动回调
		mHorizontalScrollView.setCurrentImageChangeListener(new CurrentImageChangeListener() {
			@Override
			public void onCurrentImgChanged(int position, View viewIndicator) {
				mImg.setImageResource(mDatas.get(position));
				viewIndicator.setBackgroundColor(Color.RED);
			}
		});
		
		//添加点击回调
		mHorizontalScrollView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onClick(View view, int pos) {
				mImg.setImageResource(mDatas.get(pos));
				view.setBackgroundColor(Color.RED);
			}
		});
		
		//设置适配器
		mHorizontalScrollView.initDatas(mAdapter);
        
	}

}
