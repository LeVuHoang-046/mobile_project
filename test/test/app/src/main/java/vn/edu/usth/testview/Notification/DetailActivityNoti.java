package vn.edu.usth.testview.Notification;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.testview.R;

public class DetailActivityNoti extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_noti);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
        Noti noti = (Noti) bundle.get("object_noti");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView nameUser = findViewById(R.id.name_noti);
        nameUser.setText(noti.getName());
    }
}