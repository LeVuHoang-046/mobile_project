package vn.edu.usth.testview;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class Tab1 extends Fragment {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private List<Photo> mlistPhoto;
    private RecyclerView rcvData;
    private UserAdapter userAdapter;



    private Timer mTimer;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        rcvData = view.findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false);
        rcvData.setLayoutManager(linearLayoutManager);


        userAdapter = new UserAdapter(requireContext(), getListUser());
        rcvData.setAdapter(userAdapter);


        viewPager = view.findViewById(R.id.viewpagerslide);
        circleIndicator = view.findViewById(R.id.circle_indicator);

        mlistPhoto = getListPhoto();
        photoAdapter = new PhotoAdapter(requireContext(), mlistPhoto);
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        return view;

    }



    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.slideimg1));
        list.add(new Photo(R.drawable.slideimg2));
        list.add(new Photo(R.drawable.slideimg3));
        return list;
    }
    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.dish, "fastdelivery"));
        list.add(new User(R.drawable.pizza, "pizza"));
        list.add(new User(R.drawable.chicken, "chicken"));
        list.add(new User(R.drawable.vegetables, "salad" ));
        list.add(new User(R.drawable.foodcate1, "salad" ));
        list.add(new User(R.drawable.friedegg, "salad" ));
        list.add(new User(R.drawable.food, "salad" ));


        return list;
        }


private void autoSlideImages(){
        if(mlistPhoto == null || mlistPhoto.isEmpty() || viewPager ==null){
            return;
        }
        if (mTimer == null){
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = mlistPhoto.size() -1;
                        if (currentItem<totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else{
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 100,3000);
    }
    @Override
    public void onResume() {
        super.onResume();
        autoSlideImages();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTimer != null){
            mTimer.cancel();
            mTimer = null;
        }
        if(userAdapter != null){
            userAdapter.release();
        }
    }

}