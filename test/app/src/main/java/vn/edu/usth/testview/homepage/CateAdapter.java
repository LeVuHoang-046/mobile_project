package vn.edu.usth.testview.homepage;

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

public class CateAdapter extends RecyclerView.Adapter<CateAdapter.UserViewHolder> {
    private List<Cate> mListCate;
    private Context mContext;

    public CateAdapter(Context context, List<Cate> mListCate) {
        this.mContext = context;
        this.mListCate = mListCate;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cate,parent,false);
        return new UserViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final Cate cate = mListCate.get(position);
        if (cate ==null){
            return;
        }
        holder.imgAvatar.setImageResource(cate.getResourceId());
        holder.tvName.setText(cate.getName());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGotoDetail(cate);
            }
        });
    }
    private void onClickGotoDetail(Cate cate){
        Intent intent = new Intent(mContext, CateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user_homepage", cate);
        intent.putExtras(bundle);
        mContext.startActivity(intent);


    }
    public void release(){
        mContext = null ;

    }

    @Override
    public int getItemCount() {
        if (mListCate != null){
            return mListCate.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgAvatar;
        private TextView tvName;
        private TextView tvAddress;
        private RelativeLayout layoutItem;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_cate);
            tvName = itemView.findViewById(R.id.tv_cate);
            layoutItem =itemView.findViewById(R.id.category_layout);
        }
    }

}
