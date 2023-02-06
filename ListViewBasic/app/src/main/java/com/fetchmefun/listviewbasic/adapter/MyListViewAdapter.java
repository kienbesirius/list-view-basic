package com.fetchmefun.listviewbasic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fetchmefun.listviewbasic.MonHocModelClass;
import com.fetchmefun.listviewbasic.R;

import java.util.ArrayList;

public class MyListViewAdapter extends ArrayAdapter<MonHocModelClass> {

    // Data  - needs to display
    private ArrayList<MonHocModelClass> list;
    Context context;

    public MyListViewAdapter(Context context, ArrayList<MonHocModelClass> list) {
        super(context, R.layout.my_list_view_item, list);
        this.list = list;
        this.context = context;
    }

    // View Holder
    public static class MyViewHolder {
        ImageView imageView;
        TextView textView_MonHoc, textView_TinChi;
        TextView textView_Description;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MonHocModelClass item = getItem(position);
        MyViewHolder myViewHolder;

        final View RESULT;
        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(
                    R.layout.my_list_view_item,
                    parent,
                    false
            );
            myViewHolder.textView_MonHoc = convertView.findViewById(R.id.textView_MonHoc);
            myViewHolder.textView_TinChi = convertView.findViewById(R.id.textView_TinChi);
            myViewHolder.textView_Description = convertView.findViewById(R.id.textView_Description);
            myViewHolder.imageView = convertView.findViewById(R.id.imageView);
            RESULT = convertView;
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
            RESULT = convertView;
        }

        myViewHolder.textView_MonHoc.setText(item.getMonHoc());
        myViewHolder.textView_TinChi.setText(item.getTinChi());
        myViewHolder.textView_Description.setText(item.getDescription());
        Glide.with(convertView).load(item.getImage()).into(myViewHolder.imageView);

        return convertView;
    }
}
