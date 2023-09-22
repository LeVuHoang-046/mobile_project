package vn.edu.usth.testview.homepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.testview.R;
import vn.edu.usth.testview.order.CategoryHomePageViewpageAdapter;
import vn.edu.usth.testview.widget.CustomViewPager;

public class Category extends Fragment {
    private TabLayout tabLayoutCate;
    private CustomViewPager viewPagerCate;
    private View oViewCate ;

    public Category () {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        oViewCate = inflater.inflate(R.layout.fragment_tab1, container, false);
        tabLayoutCate = oViewCate.findViewById(R.id.category_homepage1);
        viewPagerCate = oViewCate.findViewById(R.id.order_viewpagerCate);

        CategoryHomePageViewpageAdapter adapter = new CategoryHomePageViewpageAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerCate.setAdapter(adapter);
        viewPagerCate.setPagingEnabled(false);

        tabLayoutCate.setupWithViewPager(viewPagerCate);
        return oViewCate;
    }
}