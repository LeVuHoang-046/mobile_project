package vn.edu.usth.testview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.testview.LoRe.Login;
import vn.edu.usth.testview.User.User;
import vn.edu.usth.testview.User.UserAdapter;

public class Tab4 extends Fragment {

    private RecyclerView rcvData;
    private UserAdapter userAdapter;

//--------------------------------------LogOut------------------------------------------------
    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;
//---------------------------------------------------------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tab4, container, false);


//-------------------------------------RecycleView----------------------------------------------------
        rcvData = view.findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvData.setLayoutManager(linearLayoutManager);

        userAdapter= new UserAdapter(getActivity(),getListUser());
        rcvData.setAdapter(userAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);


//----------------------------------------------------------------------------------------------------


// -------------------------------------logOut---------------------------------------------------------
        auth = FirebaseAuth.getInstance();
        textView = view.findViewById(R.id.user_detail);
        button = view.findViewById(R.id.logout);

        user = auth.getCurrentUser();
        if(user == null) {
            Intent intent = new Intent(getActivity(), Login.class);
            startActivity(intent);
            getActivity().finish();
        }
        else {
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
                getActivity().finish();

            }
        });
// -------------------------------------------------------------------------------------------------------

        return view;
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.wallet, "Pay"));
        list.add(new User(R.drawable.settings, "Settings"));
        list.add(new User(R.drawable.medal, "Rewards"));
        list.add(new User(R.drawable.help_center, "Help center"));

        return list;
    }



}