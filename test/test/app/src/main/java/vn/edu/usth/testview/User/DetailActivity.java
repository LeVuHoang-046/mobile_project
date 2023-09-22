package vn.edu.usth.testview.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import vn.edu.usth.testview.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }

        User user = (User) bundle.get("object_user");

        TextView tvNameUser = findViewById(R.id.tv_name_user);
        tvNameUser.setText(user.getName());
    }
}