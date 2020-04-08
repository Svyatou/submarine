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
    public Integer [] arrayImage = {R.drawable.water, R.drawable.water1, R.drawable.water2, R.drawable.water3,
            R.drawable.water4, R.drawable.water5, R.drawable.water6, R.drawable.water7, R.drawable.water8, R.drawable.water9,
            R.drawable.water10, R.drawable.water11, R.drawable.water12, R.drawable.water13, R.drawable.water14, R.drawable.water15,
            R.drawable.water16, R.drawable.water17, R.drawable.water18, R.drawable.water19, R.drawable.water20, R.drawable.water21,
            R.drawable.water22, R.drawable.water23, R.drawable.water24, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water,
            R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water, R.drawable.water};
}
