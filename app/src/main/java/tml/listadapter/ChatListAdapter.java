package tml.listadapter;
//https://github.com/mitchtabian/ListViews/blob/master/ListAdapter_WithImages/ListAdapter/app/src/main/java/tabian/com/listadapter/PersonListAdapter.java
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import tml.hawktalk.R;

//import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
//import com.nostra13.universalimageloader.core.DisplayImageOptions;
//import com.nostra13.universalimageloader.core.ImageLoader;
//import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
//import com.nostra13.universalimageloader.core.assist.ImageScaleType;
//import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 3/14/2017.
 */

public class ChatListAdapter extends ArrayAdapter<ChatList> {

    private static final String TAG = "PersonListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView title;
        TextView subtitle;
        TextView date;
        ImageView imgURL;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public ChatListAdapter(Context context, int resource, ArrayList<ChatList> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //sets up the image loader library
        //setupImageLoader();

        //get the persons information
        String title = getItem(position).getTitle();
        String subtitle = getItem(position).getSubtitle();
        String date = getItem(position).getDate();
        String imgUrl = getItem(position).getImgURL();

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;


        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            //holder.imgURL = (TextView) convertView.findViewById(R.id.lst_icon);
            holder.title = (TextView) convertView.findViewById(R.id.lst_title);
            holder.subtitle = (TextView) convertView.findViewById(R.id.lst_subtitle);
            holder.date = (TextView) convertView.findViewById(R.id.lst_subtitle_date);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


//        Animation animation = AnimationUtils.loadAnimation(mContext,
//                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
//        result.startAnimation(animation);
//        lastPosition = position;

        //holder.imgURL.setImgURL(simg);
        holder.title.setText(title);
        holder.subtitle.setText(subtitle);
        holder.date.setText(date);

        return convertView;
    }

    /**
     * Required for setting up the Universal Image loader Library
     */
//    private void setupImageLoader(){
//        // UNIVERSAL IMAGE LOADER SETUP
//        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
//                .cacheOnDisc(true).cacheInMemory(true)
//                .imageScaleType(ImageScaleType.EXACTLY)
//                .displayer(new FadeInBitmapDisplayer(300)).build();
//
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
//                mContext)
//                .defaultDisplayImageOptions(defaultOptions)
//                .memoryCache(new WeakMemoryCache())
//                .discCacheSize(100 * 1024 * 1024).build();
//
//        ImageLoader.getInstance().init(config);
//        // END - UNIVERSAL IMAGE LOADER SETUP
//    }
}