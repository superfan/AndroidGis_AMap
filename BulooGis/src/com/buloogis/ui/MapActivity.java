package com.buloogis.ui;

import android.os.Bundle;
import android.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.buloogis.ui.fragment.*;
import com.slidingmenu.lib.SlidingMenu;
import com.amap.api.maps.SupportMapFragment;

import android.app.Fragment;

//import com.esri.android.map.MapView;
//import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;

public class MapActivity extends SlidingActivity {
	//private MapView mMapView = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_frame_content);
		setBehindContentView(R.layout.map_frame_left_menu);
		setSecondaryBehindContentView(R.layout.map_frame_right_menu);
		
		Button left = (Button)findViewById(R.id.map_left);
		left.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				toggle();
			}
		});
		
		Button right = (Button)findViewById(R.id.map_right);
		right.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showSecondaryMenu();
			}
		});
		
    	//mMapView = (MapView)findViewById(R.id.mapview);
    	//if (mMapView == null) {
    	//	return;
    	//}
    	//mMapView.addLayer(new ArcGISTiledMapServiceLayer(getResources().getString(R.string.map_url)));
		
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        MapLeftMenuFragment leftMenuFragment = new MapLeftMenuFragment();
        MapRightMenuFragment rightMenuFragment = new MapRightMenuFragment();
        MapContentFragment mapFragment = new MapContentFragment();
        fragmentTransaction.replace(R.id.map_left_menu, leftMenuFragment);
        fragmentTransaction.replace(R.id.map_right_menu, rightMenuFragment);
        fragmentTransaction.replace(R.id.map_content, mapFragment);
        fragmentTransaction.commit();
        
        // customize the SlidingMenu
        SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidth(50);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffset(200);
        sm.setFadeDegree(0.35f);
        sm.setMode(SlidingMenu.LEFT_RIGHT);
        //设置slding menu的几种手势模式
        //TOUCHMODE_FULLSCREEN 全屏模式，在content页面中，滑动，可以打开sliding menu
        //TOUCHMODE_MARGIN 边缘模式，在content页面中，如果想打开slding ,你需要在屏幕边缘滑动才可以打开slding menu
        //TOUCHMODE_NONE 自然是不能通过手势打开啦
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);

        //使用左上方icon可点，这样在onOptionsItemSelected里面才可以监听到R.id.home
        //getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		//mMapView.unpause();
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		//mMapView.pause();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
	}
	
/*	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            //toggle就是程序自动判断是打开还是关闭
            toggle();
//          getSlidingMenu().showMenu();// show menu
//          getSlidingMenu().showContent();//show content
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
