package com.buloogis.ui.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;

import com.buloogis.ui.MapActivity;
import com.buloogis.ui.R;
/**
 * menu fragment ，主要是用于显示menu菜单
 * @author <a href="mailto:kris@krislq.com">Kris.lee</a>
 * @since Mar 12, 2013
 * @version 1.0.0
 */
public class MapLeftMenuFragment extends PreferenceFragment implements OnPreferenceClickListener{
    int index = -1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        //set the preference xml to the content view
        addPreferencesFromResource(R.xml.menu);
        //add listener
        findPreference("a").setOnPreferenceClickListener(this);
        findPreference("b").setOnPreferenceClickListener(this);
        findPreference("n").setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();
        /*if("a".equals(key)) {
            //if the content view is that we need to show . show directly
            if(index == 0) {
                ((MapActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            //otherwise , replace the content view via a new Content fragment
            index = 0;
            FragmentManager fragmentManager = ((MapActivity)getActivity()).getFragmentManager();
            MapContentFragment contentFragment = (MapContentFragment)fragmentManager.findFragmentByTag("A");
            fragmentManager.beginTransaction()
            .replace(R.id.map_content, contentFragment == null ? new MapContentFragment():contentFragment ,"A")
            .commit();
        }else if("b".equals(key)) {
            if(index == 1) {
                ((MapActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 1;
            FragmentManager fragmentManager = ((MapActivity)getActivity()).getFragmentManager();
            MapContentFragment contentFragment = (MapContentFragment)fragmentManager.findFragmentByTag("B");
            fragmentManager.beginTransaction()
            .replace(R.id.map_content, contentFragment == null ? new MapContentFragment():contentFragment,"B")
            .commit();
        }else if("n".equals(key)) {

            if(index == 2) {
                ((MapActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 2;
            FragmentManager fragmentManager = ((MapActivity)getActivity()).getFragmentManager();
            MapContentFragment contentFragment = (MapContentFragment)fragmentManager.findFragmentByTag("N");
            fragmentManager.beginTransaction()
            .replace(R.id.map_content, contentFragment == null ? new MapContentFragment():contentFragment,"C")
            .commit();
        }*/
        //anyway , show the sliding menu
        ((MapActivity)getActivity()).getSlidingMenu().toggle();
        return false;
    }
}
