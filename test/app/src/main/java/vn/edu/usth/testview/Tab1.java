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
import vn.edu.usth.testview.homepage.Cate;
import vn.edu.usth.testview.homepage.CateAdapter;
import vn.edu.usth.testview.homepage.Photo;
import vn.edu.usth.testview.homepage.PhotoAdapter;
import vn.edu.usth.testview.homepage.Sale;
import vn.edu.usth.testview.homepage.SaleAdapter;


public class Tab1 extends Fragment {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private List<Photo> mlistPhoto;
    private RecyclerView rcvDataCate;
    private CateAdapter cateAdapter;

    private RecyclerView rcvDataSale;
    private SaleAdapter saleAdapter;



    private Timer mTimer;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        rcvDataCate = view.findViewById(R.id.rcv_cate_homepage);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false);
        rcvDataCate.setLayoutManager(linearLayoutManager);


        cateAdapter = new CateAdapter(requireContext(), getListUser());
        rcvDataCate.setAdapter(cateAdapter);

        rcvDataSale = view.findViewById(R.id.rcv_sale_homepage);
        LinearLayoutManager linearLayoutManagerSale = new LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false);
        rcvDataSale.setLayoutManager(linearLayoutManagerSale);


        saleAdapter = new SaleAdapter(requireContext(), getListSale1());
        rcvDataSale.setAdapter(saleAdapter);


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
    private List<Cate> getListUser() {
        List<Cate> list = new ArrayList<>();
        list.add(new Cate(R.drawable.dish, "FastFood"));
        list.add(new Cate(R.drawable.pizza, "pizza"));
        list.add(new Cate(R.drawable.chicken, "Chicken"));
        list.add(new Cate(R.drawable.vegetables, "Vegetables" ));
        list.add(new Cate(R.drawable.foodcate1, "Rice Chicken" ));
        list.add(new Cate(R.drawable.friedegg, "Egg" ));
        list.add(new Cate(R.drawable.meat, "Meat" ));
        list.add(new Cate(R.drawable.hamburger, "Burger" ));
        list.add(new Cate(R.drawable.seafood, "Seafood" ));
        list.add(new Cate(R.drawable.sushi, "Sushi" ));
        list.add(new Cate(R.drawable.tok, "Tokbokki" ));



        return list;
    }
    private List<Sale> getListSale1(){
        List<Sale> list1 = new ArrayList<>();
        list1.add(new Sale(R.drawable.sale1,"Tiếp Sức 'Mùa Sale' Giảm 40%"));
        list1.add(new Sale(R.drawable.sale2,"Tiệc độc quyền: 1Đ + Freeship"));
        list1.add(new Sale(R.drawable.sale3,"Siêu Deal 0Đ Món Gì Cũng Có"));
        list1.add(new Sale(R.drawable.sale4,"Thứ 7 vui vẻ giảm tới 50.000Đ"));
        list1.add(new Sale(R.drawable.sale5,"Voucher Vạn Năng"));
        list1.add(new Sale(R.drawable.sale6,"Vạn Món Giá Hời"));

        return list1;
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
        if(cateAdapter != null){
            cateAdapter.release();
        }
        if (saleAdapter!=null){
            saleAdapter.release();
        }
    }

}