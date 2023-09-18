package vn.edu.usth.testview;

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
//Define a UserAdapter class
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> mListUser;
    private Context mContext;

//    Constructor to initialize UserAdapter
    public UserAdapter(Context context,List<User> mListUser) {
        this.mContext = context;
        this.mListUser = mListUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final User user = mListUser.get(position);
        if (user==null){
            return;
        }
//        Set user data to the ViewHolder
        holder.imgAvatar.setImageResource(user.getResourceId());
        holder.tvName.setText(user.getName());
//        Set click listener to the item view
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGotoDetail(user);
            }
        });
    }
    private void onClickGotoDetail(User user){
        Intent intent = new Intent(mContext, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user", user);
        intent.putExtras(bundle);
        mContext.startActivity(intent);


    }
    public void release(){
        mContext = null ;

    }

//return the item count in the list
    @Override
    public int getItemCount() {
        if (mListUser != null){
            return mListUser.size();
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
            imgAvatar = itemView.findViewById(R.id.img_pizza);
            tvName = itemView.findViewById(R.id.tv_name);

            layoutItem =itemView.findViewById(R.id.layout_item);
        }
    }

}
