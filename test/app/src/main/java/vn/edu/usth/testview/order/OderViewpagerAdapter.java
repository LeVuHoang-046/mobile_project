package vn.edu.usth.testview.order;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.edu.usth.testview.Tab1;
import vn.edu.usth.testview.Tab2;
import vn.edu.usth.testview.Tab3;
import vn.edu.usth.testview.Tab4;

public class OderViewpagerAdapter extends FragmentStatePagerAdapter {
    public OderViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : return new Tab1Fragment();
            case 1 : return new Tab2Fragment();
            case 2 : return new Tab3Fragment();
            default: return new Tab1Fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0 :
                return "Coming";
            case 1 :
                return "History";
            case 2 :
                return "Draf Form";
            default:
                return "Coming";

        }
    }
}
