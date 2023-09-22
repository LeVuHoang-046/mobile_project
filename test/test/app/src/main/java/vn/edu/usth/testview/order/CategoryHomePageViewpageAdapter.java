package vn.edu.usth.testview.order;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CategoryHomePageViewpageAdapter extends FragmentStatePagerAdapter {

    public CategoryHomePageViewpageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : return new Tab1HomePageFragment();
            case 1 : return new Tab2HomePageFragment();
            case 2 : return new Tab3HomePageFragment();
            case 3 : return new Tab4HomePageFragment();
            case 4 : return new Tab5HomePageFragment();
            default: return new Tab1HomePageFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Meat";
            case 1:
                return "Fast Food";
            case 2:
                return "Vegetables";
            case 3:
                return "Dessert";
            case 4:
                return "Drink";
            default:
                return "Meat";
        }



    }
}
