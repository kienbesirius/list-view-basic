package com.fetchmefun.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {

    private EditText editText_MonHoc2, editText_TinChi2, editText_Description2;
    private ImageView ImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mapIdToView();
        setupViews();
    }

    private void setupViews() {
        Intent intent = getIntent();
        String MonHoc = intent.getStringExtra("MonHoc"),
                TinChi = intent.getStringExtra("TinChi"),
                Desc = intent.getStringExtra("Desc");
        int Image = intent.getIntExtra("Image",R.raw.kanao_avatar);
        editText_MonHoc2.setText(MonHoc);
        editText_TinChi2.setText(TinChi);
        editText_Description2.setText(Desc);
        Glide.with(this).load(Image).into(ImageView2);
    }

    private void mapIdToView() {
        editText_Description2 = findViewById(R.id.editText_Description2);
        editText_MonHoc2 = findViewById(R.id.editText_MonHoc2);
        editText_TinChi2 = findViewById(R.id.editText_TinChi2);
        ImageView2 = findViewById(R.id.imageView2);
    }
}