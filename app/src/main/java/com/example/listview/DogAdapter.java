package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Map;

public class DogAdapter extends ArrayAdapter<Map<String,Object>> {
    private  int id;//子布局地址

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Map map=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(id,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.imageView=view.findViewById(R.id.img);
            viewHolder.textView=view.findViewById(R.id.text);
            view.setTag(viewHolder);
        }else {
           view= convertView;
           viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(Integer.parseInt(map.get("img").toString()));
        viewHolder.textView.setText(map.get("text").toString());
        return view;
    }

    public DogAdapter(Context context, int resource, List<Map<String, Object>> objects) {
        super(context, resource, objects);
        this.id=resource;
    }
    class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }
}
