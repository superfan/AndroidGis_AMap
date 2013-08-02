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
        //����slding menu�ļ�������ģʽ
        //TOUCHMODE_FULLSCREEN ȫ��ģʽ����contentҳ���У����������Դ�sliding menu
        //TOUCHMODE_MARGIN ��Եģʽ����contentҳ���У�������slding ,����Ҫ����Ļ��Ե�����ſ��Դ�slding menu
        //TOUCHMODE_NONE ��Ȼ�ǲ���ͨ�����ƴ���
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);

        //ʹ�����Ϸ�icon�ɵ㣬������onOptionsItemSelected����ſ��Լ�����R.id.home
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
            //toggle���ǳ����Զ��ж��Ǵ򿪻��ǹر�
            toggle();
//          getSlidingMenu().showMenu();// show menu
//          getSlidingMenu().showContent();//show content
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
