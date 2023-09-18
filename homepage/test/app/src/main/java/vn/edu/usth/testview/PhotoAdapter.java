package vn.edu.usth.testview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.edu.usth.testview.R;

public class PhotoAdapter extends PagerAdapter {

    private Context mContext ;

    public  PhotoAdapter(Context mContext, List<Photo> mListphoto) {
        this.mContext = mContext;
        this.mListphoto = mListphoto;
    }

    private List<Photo> mListphoto;


//    create and return the item at the given position
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo, container, false);
        ImageView imgPhoto = view.findViewById(R.id.img_photo);

//      Get the photo at the specified position
        Photo photo = mListphoto.get(position);
        if(photo != null) {
            //Load the photo into the ImageView
            Glide.with(mContext).load(photo.getResourceId()).into(imgPhoto);
        }

        //Add view to viewgroup
        container.addView(view);

        return view;
    }

    //return the number of items in the adapter
    @Override
    public int getCount() {
        if (mListphoto != null) {
            return mListphoto.size();
        }
        return 0;
    }

    //determine if a page View is associated with a given object
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }

    //remove the page for the given position
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //remove view from viewgroup
        container.removeView((View)  object);

    }
}
