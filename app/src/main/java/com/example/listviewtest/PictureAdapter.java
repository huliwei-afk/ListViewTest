package com.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class PictureAdapter extends ArrayAdapter<Picture> {

    private int resourceId;

    public PictureAdapter(Context context, int textViewResourceId, List<Picture> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Picture picture = getItem(position);

        //提升效率，convertView参数缓存布局
        View view;
        //防止每次调用findViewById方法
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);//如果参数为null，则重新加载布局
            viewHolder = new ViewHolder();// 创建viewHolder对象，并将控件实例存储其中
            viewHolder.pictureImage = (ImageView)view.findViewById(R.id.picture_image);
            viewHolder.pictureName = (TextView)view.findViewById(R.id.picture_name);
            view.setTag(viewHolder);//setTag方法将ViewHolder储存在View中
        }else{
            view = convertView;//convertView不为null时则直接调用
            viewHolder = (ViewHolder)view.getTag();//getTag方法重新获取ViewHolder
        }

//        ImageView pictureImage = (ImageView)view.findViewById(R.id.picture_image);
//        TextView pictureName = (TextView)view.findViewById(R.id.picture_name);
//        pictureImage.setImageResource(picture.getImageId());
//        pictureName.setText(picture.getName());
        viewHolder.pictureImage.setImageResource(picture.getImageId());
        viewHolder.pictureName.setText(picture.getName());
        return view;
    }

    //对控件实例进行缓存
    class ViewHolder{
        ImageView pictureImage;
        TextView pictureName;
    }

}
