package vn.edu.usth.testview.Notification;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.testview.R;

public class NotiAdapter extends RecyclerView.Adapter<NotiAdapter.NotiViewHolder>{
    private List<Noti> mListNoti;
    private Context mContext;
    public NotiAdapter(Context context, List<Noti> mListNoti ){
        this.mContext = context;
        this.mListNoti = mListNoti;

    }

    @NonNull
    @Override
    public NotiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        return new NotiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotiViewHolder holder, int position) {
     final Noti noti = mListNoti.get(position);
    if (noti == null){
        return;
    }
    holder.imgFood.setImageResource(noti.getResourceId());
    holder.nameFood.setText(noti.getName());
    holder.statusFood.setText(noti.getAddress());
    holder.layoutFood.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onClickGoToDetail(noti);
        }
    });



    }
    private void onClickGoToDetail(Noti noti){
    Intent intent = new Intent(mContext, DetailActivityNoti.class);
    Bundle bundle = new Bundle();
    bundle.putSerializable("object_noti",noti);
    intent.putExtras(bundle);
    mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (mListNoti != null) {
            return mListNoti.size();
        }
        return 0;
    }

    public class NotiViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout layoutFood;
        private ImageView imgFood;
        private TextView nameFood;
        private TextView statusFood;

        public NotiViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutFood = itemView.findViewById(R.id.layout_food);
            imgFood = itemView.findViewById(R.id.image_food);
            nameFood = itemView.findViewById(R.id.name_food);
            statusFood = itemView.findViewById(R.id.status_food);
        }
    }

}
