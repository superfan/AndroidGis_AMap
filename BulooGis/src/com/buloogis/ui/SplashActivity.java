package com.buloogis.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;

public class SplashActivity extends BaseActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		initViewPager();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	private void initViewPager() {
	     ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
	     
	     View view1 = LayoutInflater.from(this).inflate(R.layout.splash_layout1, null);
	     View view2 = LayoutInflater.from(this).inflate(R.layout.splash_layout2, null);
	     View view3 = LayoutInflater.from(this).inflate(R.layout.splash_layout3, null);
	     
	     ArrayList<View> views = new ArrayList<View>();
	     views.add(view1);
	     views.add(view2);
	     views.add(view3);
	     
	     SplashViewPagerAdapter adapter = new SplashViewPagerAdapter();
	     adapter.setViews(views);
	     viewPager.setAdapter(adapter);
	     
	     Button button1 = (Button)view1.findViewById(R.id.splash_button_1);
	     button1.setOnClickListener(listener);
	     
	     Button button2 = (Button)view2.findViewById(R.id.splash_button_2);
	     button2.setOnClickListener(listener);
	     
	     Button button3 = (Button)view3.findViewById(R.id.splash_button_3);
	     button3.setOnClickListener(listener);
	}
	
	private OnClickListener listener = new OnClickListener() {
		@Override
   	 	public void onClick(View v) {
			Intent i = new Intent(SplashActivity.this, MapActivity.class);
   		 	startActivity(i);
   		 	SplashActivity.this.finish();
   	 	}
    };
	
}
