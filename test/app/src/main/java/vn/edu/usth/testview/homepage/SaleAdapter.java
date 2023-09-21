package vn.edu.usth.testview.homepage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class SaleAdapter extends RecyclerView.Adapter<SaleAdapter.UserViewHolder> {
    private List<Sale> mListSale;
    private Context mContextSale;

    public SaleAdapter(Context context, List<Sale> mListSale) {
        this.mContextSale = context;
        this.mListSale = mListSale;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sale,parent,false);
        return new UserViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final Sale sale = mListSale.get(position);
        if (sale ==null){
            return;
        }
        Log.d("SaleAdapter", "Setting text for sale: " + sale.getName());
        holder.imgAvatarSale.setImageResource(sale.getResourceId());
        holder.tvNameSale.setText(sale.getName());
        holder.layoutItemSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGotoDetail(sale);
            }
        });
    }
    private void onClickGotoDetail(Sale sale){
        Intent intent = new Intent(mContextSale, SaleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_sale_homepage", sale);
        intent.putExtras(bundle);
        mContextSale.startActivity(intent);


    }
    public void release(){
        mContextSale = null ;

    }

    @Override
    public int getItemCount() {
        if (mListSale != null){
            return mListSale.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgAvatarSale;
        private TextView tvNameSale;
        private TextView tvAddressSale;
        private RelativeLayout layoutItemSale;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatarSale = itemView.findViewById(R.id.img_sale);
            tvNameSale = itemView.findViewById(R.id.tv_sale);
            layoutItemSale =itemView.findViewById(R.id.sale_layout);
        }
    }

}