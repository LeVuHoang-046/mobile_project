package vn.edu.usth.testview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.testview.order.OderViewpagerAdapter;
import vn.edu.usth.testview.widget.CustomViewPager;

public class Tab2 extends Fragment {
    private TabLayout tabLayout;
    private CustomViewPager viewPager;
    private View oView ;

    public Tab2 () {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        oView = inflater.inflate(R.layout.fragment_tab2, container, false);
        tabLayout = oView.findViewById(R.id.tab_layout);
        viewPager = oView.findViewById(R.id.order_viewpager);

        OderViewpagerAdapter adapter = new OderViewpagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.setPagingEnabled(false);
        
        tabLayout.setupWithViewPager(viewPager);
        return oView;
    }
}