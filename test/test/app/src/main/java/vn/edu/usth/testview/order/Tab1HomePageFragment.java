package vn.edu.usth.testview.order;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import vn.edu.usth.testview.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab1HomePageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1_homepage, container, false);
        getActivity().setTitle("Meat");
        return view;
    }

}

