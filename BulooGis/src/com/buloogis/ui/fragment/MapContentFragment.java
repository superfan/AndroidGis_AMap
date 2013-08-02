package com.buloogis.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.buloogis.ui.R;

//import com.esri.android.map.MapView;
//import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;

public class MapContentFragment extends Fragment {
	private MapView aMapView = null;
	private AMap aMap = null;
	
    public MapContentFragment() {
    	super();
    }

   /* public MapContentFragment(String text) {
        Log.e("BulooGis", text);
        this.text = text;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflater the layout
    	View v = inflater.inflate(R.layout.map, null);
    	aMapView = (MapView)v.findViewById(R.id.mapview);
    	if (aMapView == null) {
    		return null;
    	}
		aMapView.onCreate(savedInstanceState);
		
        return aMapView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        aMapView.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onPause() {
        super.onPause();
        aMapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        aMapView.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
    
}
