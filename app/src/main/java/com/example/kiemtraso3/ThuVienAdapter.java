package com.example.kiemtraso3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ThuVienAdapter extends ArrayAdapter<ThuVien> {
    private Activity activity;
    private int resource;
    @NonNull
    private List<ThuVien> objects;
    public ThuVienAdapter(@NonNull Activity activity, int resource, @NonNull List<ThuVien> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View view = inflater.inflate(this.resource, null);

        EditText edtso2 = view.findViewById(R.id.tv_vidu);
        TextView tvname = view.findViewById(R.id.tv_name);

        ThuVien thuVien = this.objects.get(position) ;
        tvname.setText(thuVien.getTenNgonNgu());
        edtso2.setText(thuVien.getViDu());


        return view;
    }
}

