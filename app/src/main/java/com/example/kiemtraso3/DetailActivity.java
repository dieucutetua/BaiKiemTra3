package com.example.kiemtraso3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    EditText edtVidu;
    TextView txtNgonNgu;
    Button btnThoat, btnThem;
    private  ThuVienAdapter adapter;
    private ListView lvThuVien;
    private ArrayList<ThuVien> thuVienArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail  );

        edtVidu = findViewById(R.id.tv_vidu);
        txtNgonNgu = findViewById(R.id.tv_name);
        btnThem = findViewById(R.id.btnLuu);
        btnThoat = findViewById(R.id.btnBack);
        lvThuVien = findViewById(R.id.listvidu);

        thuVienArrayList = new ArrayList<>();
        getData();
        adapter = new ThuVienAdapter(this,R.layout.item_listvidu,thuVienArrayList);
        lvThuVien.setAdapter(adapter);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        addControls();
        addEvents();

    }

    private void addEvents() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vidu = edtVidu.getText().toString();
                String ngonngu = txtNgonNgu.getText().toString();


                ThuVien thuVien =new ThuVien(ngonngu,vidu);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("QuanLyNgonNgu");
                String id = myRef.push().getKey();
                myRef.child(id).setValue(thuVien).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(),"Thêm thành công  !",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Thêm thất bại !",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    private void addControls() {
        txtNgonNgu = findViewById(R.id.tv_name);
        edtVidu = findViewById(R.id.tv_vidu);
        btnThem = findViewById(R.id.btnLuu);
    }
    private  void getData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("QuanLyNgonNgu");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adapter.clear();
                for(DataSnapshot data : snapshot.getChildren()){
                    ThuVien thuVien = data.getValue(ThuVien.class);
                    if(thuVien != null){
                        thuVien.setId(data.getKey());
                        adapter.add(thuVien);
                    }
                }
                Toast.makeText(getApplicationContext(),"Thành công !",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Thất bại !" + error.toString(),Toast.LENGTH_SHORT).show();
                Log.d("MYTAG","onCancelled: " + error.toString());
            }
        });
    }
}