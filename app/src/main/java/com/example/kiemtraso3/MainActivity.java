package com.example.kiemtraso3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<NgonNgu> arrayList;
    NgonNguAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView = findViewById(R.id.lv_ngonngu);
        arrayList = new ArrayList<>();
        arrayList.add(new NgonNgu( "Tiếng Anh",R.drawable.img_2));
        arrayList.add(new NgonNgu( "Tiếng Trung",R.drawable.img_1));
        adapter = new NgonNguAdapter(MainActivity.this, R.layout.items_list, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, DetailActivity.class);
                    startActivity(intent);

                } else if (i == 1){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, TiengTrung.class);
                    startActivity(intent);
               }

            }
        });



    }
}