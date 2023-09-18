package vn.edu.usth.testview;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : return new Tab1();
            case 1 : return new Tab2();
            case 2 : return new Tab3();
            case 3 : return new Tab4();
            default: return new Tab1();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
