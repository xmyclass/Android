package com.example.commonjar.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.commonjar.R;

/**
 * @author admin
 * 图片左右滑动
 */
public class HorizontalScrollViewActivity extends Activity{
	
	private LinearLayout mGallery;
	private int[] mImgIds;
	//通俗的说,inflate就相当于将一个xml中定义的布局找出来. 
	private LayoutInflater mInflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//隐藏标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.horizontal_scroll_view);
		mInflater = LayoutInflater.from(this);
		
		init();
	}
	
	/**
	 * 初始化控件
	 */
	private void init(){
		mGallery = (LinearLayout) findViewById(R.id.id_gallery);
		mImgIds = new int[] 
				{ R.drawable.image1, R.drawable.image2, R.drawable.image3,
				  R.drawable.image4, R.drawable.image5, R.drawable.image6,
				  R.drawable.image7, R.drawable.image8, R.drawable.image9 };
		
        for (int i = 0; i < mImgIds.length; i++)  
        {  
              
        	/**
        	 *  View v1 = inflater.inflate(R.layout.el_include, null);  
			    View v3 = inflater.inflate(R.layout.el_include, itemGroup, false);  
          
		        View v2 = inflater.inflate(R.layout.el_include, itemGroup);  
				View v4 = inflater.inflate(R.layout.el_include, itemGroup, true); 
				
				 测试结果是：

1、V1和V3在Activity里显示效果一样，都是itemGroup原来的内容，V1和V3都是R.layout.el_include里的View对象。

2、V2和V4在Activity里显示效果一样，都是itemGroup添加R.layout.el_include里的内容之后的。V2和V4对象都是加了R.layout.el_include的itemGroup。

        	 * */

            View view = mInflater.inflate(R.layout.activity_index_gallery_item,  
                    mGallery, false);  
            ImageView img = (ImageView) view  
                    .findViewById(R.id.id_index_gallery_item_image);  
            img.setImageResource(mImgIds[i]);  
            TextView txt = (TextView) view  
                    .findViewById(R.id.id_index_gallery_item_text);  
            txt.setText("some info ");  
            mGallery.addView(view);  
        } 
        
	}

}
