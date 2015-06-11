package com.example.commonjar;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.example.commonjar.activity.HorizontalScrollViewActivity;
import com.example.commonjar.activity.MyHorizontalScrollViewActivity;

/**
 * @author admin
 * 主面板
 */
public class MainActivity extends Activity implements OnClickListener{

	//HorizontalScrollView的使用
	private Button buttonHorizontalScrollView;
	//自定义HorizontalScrollView的使用
	private Button myButtonHorizontalScrollView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//隐藏标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.activity_main);
		
		init();
	}
	
	/**
	 * 初始化控件
	 */
	private void init(){
		//HorizontalScrollView的使用
		buttonHorizontalScrollView=(Button) findViewById(R.id.buttonHorizontalScrollView);
		buttonHorizontalScrollView.setOnClickListener(this);
		
		myButtonHorizontalScrollView=(Button) findViewById(R.id.myButtonHorizontalScrollView);
		myButtonHorizontalScrollView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		//HorizontalScrollView的使用
		if(v.getId()==R.id.buttonHorizontalScrollView){
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, HorizontalScrollViewActivity.class);
			startActivity(intent);
		}else if(v.getId()==R.id.myButtonHorizontalScrollView){
			//自定义HorizontalScrollView的使用	
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, MyHorizontalScrollViewActivity.class);
			startActivity(intent);
		}
	}

}
