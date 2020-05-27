package com.example.gridsubmarine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;


    public ImageAdapter(Context c){
        context = c;
    }

    public ImageAdapter() {

    }

    @Override
    public int getCount() {
        return arrayImage.length;
    }

    @Override
    public Object getItem(int position) {
        return arrayImage[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    //Создаем ImageView для каждого элемента, на который будет ссылаться адаптер (настройка поля).
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1, 1, 1, 1);
            imageView.setAlpha(0.6f);
        } else {
            imageView = (ImageView)convertView;
        }

        imageView.setImageResource(arrayImage[position]);
        return imageView;
    }



    //Забиваем массив картинкой поля.
    public Integer [] arrayImage = {R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water,
            R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water,
            R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water,
            R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water,
            R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water,
            R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water};


}