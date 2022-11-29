package com.example.kiemtraso3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NgonNguAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<NgonNgu> arraylist;

    public NgonNguAdapter(Context context, int layout, List<NgonNgu> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override


    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        NgonNgu phepTinh = arraylist.get(i);

        TextView textView1 = view.findViewById(R.id.tv_name);
        ImageView imageView1 = view.findViewById(R.id.imgAvatar);

        textView1.setText(phepTinh.getNgonNgu());;
        imageView1.setImageResource(phepTinh.getHinhAnh());

        return view;
    }
}

