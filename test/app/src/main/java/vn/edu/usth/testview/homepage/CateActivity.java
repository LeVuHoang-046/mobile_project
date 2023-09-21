package vn.edu.usth.testview.homepage;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.testview.R;

public class CateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate_detail);

        Bundle bundle = getIntent().getExtras();
        if(bundle==null){
            return;
        }
        Cate cate = (Cate) bundle.get("object_user_homepage");

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tvNameUser = findViewById(R.id.tv_name_user_homepage);
        tvNameUser.setText(cate.getName());
    }
}