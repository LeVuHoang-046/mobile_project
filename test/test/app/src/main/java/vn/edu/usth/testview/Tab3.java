package vn.edu.usth.testview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.testview.Notification.Noti;
import vn.edu.usth.testview.Notification.NotiAdapter;

public class Tab3 extends Fragment {


    private RecyclerView rcvData;
    private int contentView;
    private NotiAdapter userAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tab3, container, false);
        getActivity().setTheme(R.style.MyFragmentTheme);
        rcvData = view.findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvData.setLayoutManager(linearLayoutManager);
        userAdapter = new NotiAdapter(getContext(),getListUser());
        rcvData.setAdapter(userAdapter);
        return view;
    }

    private List<Noti> getListUser() {
        List<Noti> list = new ArrayList<>();
        list.add(new Noti(R.drawable.friedchicken,"Chicken at KFC", " The order at store A has been completed"));
        list.add(new Noti(R.drawable.pizzanoti,"Pizza at Domino", "The order at store A has been completed"));
        list.add(new Noti(R.drawable.hamburgernoti,"Humburger at KingHamburger", "The order at store A has been completed"));
        list.add(new Noti(R.drawable.ramennoti,"Bun Bo Hue at Nghia Tan", " The order at store A has been completed"));
        list.add(new Noti(R.drawable.friedchicken,"Chicken 88 at Nguyen Khang", "The order at store A has been completed"));
        list.add(new Noti(R.drawable.trasua,"Phe la at Nguyen Van Loc", "The order at store A has been completed"));
        list.add(new Noti(R.drawable.ramennoti,"Pho at Ba Trieu", " The order at store A has been completed"));
        list.add(new Noti(R.drawable.banhtom,"Banh tom Ho tay at West Lake", "The order at store A has been completed"));
        list.add(new Noti(R.drawable.comtam,"Com Tam Tu Map at Thuy Khue", "The order at store A has been completed"));
        list.add(new Noti(R.drawable.ramennoti,"Bun Moc at Nghia Tan", " The order at store A has been completed"));
        list.add(new Noti(R.drawable.kimbap,"KimBappp at Nguyen Trai", "The order at store A has been completed"));
        list.add(new Noti(R.drawable.trasua,"Phe la at Dang Tien Dong", "The order at store A has been completed"));
        return list;
    }

}