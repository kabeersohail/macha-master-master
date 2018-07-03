package com.example.sohail.macha;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    public static int[] image ={
      R.drawable.fbg1,
      R.drawable.fbg2,
      R.drawable.fbg3,
      R.drawable.bg1,
      R.drawable.fbg3,
      R.drawable.bg1,
      R.drawable.bg1,
      R.drawable.bg1,
      R.drawable.bg1,
      R.drawable.bg1,
      R.drawable.bg1,
      R.drawable.bg1,
      R.drawable.bg1,
      R.drawable.bg1

    };



    public ImageAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(160,160));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }
        else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(image[position]);
        return imageView;
    }
}
