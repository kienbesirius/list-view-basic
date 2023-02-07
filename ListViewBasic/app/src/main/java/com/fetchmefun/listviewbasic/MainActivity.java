package com.fetchmefun.listviewbasic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.fetchmefun.listviewbasic.adapter.MyListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button_Them, button_Sua, button_Xoa;
    private EditText editText_MonHoc, editText_TinChi;
    private ListView listView;
    private ArrayList<MonHocModelClass> dataList;
    private MyListViewAdapter myListViewAdapter;
    private Map<Integer,Integer> mapImages;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapIdToView();
        setupViews();
    }

    private void setupViews() {
        button_Xoa.setEnabled(false);
        button_Sua.setEnabled(false);

        setupDataList();

        myListViewAdapter = new MyListViewAdapter(getApplicationContext(),dataList);
        listView.setAdapter(myListViewAdapter);

        // Handling click events
        button_Xoa.setOnClickListener(view -> {
            Toast.makeText(this,"Đã Xóa! " + dataList.get(index).getMonHoc(),Toast.LENGTH_SHORT).show();
            dataList.remove(index);
            myListViewAdapter.notifyDataSetChanged();
            editText_MonHoc.setText("");
            editText_TinChi.setText("");
            button_Xoa.setEnabled(false);
            button_Sua.setEnabled(false);
        });
        button_Sua.setOnClickListener(view -> {
            dataList.get(index).setMonHoc(editText_MonHoc.getText().toString().trim());
            dataList.get(index).setTinChi(editText_TinChi.getText().toString().trim());
            myListViewAdapter.notifyDataSetChanged();
            editText_MonHoc.setText("");
            editText_TinChi.setText("");
            Toast.makeText(this,"Đã Sửa! " + dataList.get(index).getMonHoc(),Toast.LENGTH_SHORT).show();
            button_Xoa.setEnabled(false);
            button_Sua.setEnabled(false);
        });
        button_Them.setOnClickListener(view -> {
            String MonHoc = editText_MonHoc.getText().toString().trim().equals("") ?
                    "Không" : editText_MonHoc.getText().toString().trim();
            String TinChi = editText_TinChi.getText().toString().trim().equals("") ?
                    "Không" : editText_TinChi.getText().toString().trim();
            String Descriptions = "Bế Chí Kiên Thất Bại " +
                    (dataList.size() + 1) +
                    "! If I get hurts, then the hurts will become strength. " +
                    "To be a successor, I have to take the losses.";
            int Image = getImage(mapImages);
            dataList.add(new MonHocModelClass(MonHoc,TinChi,Descriptions,Image));
            myListViewAdapter.notifyDataSetChanged();
            Toast.makeText(this,"Đã Thêm!",Toast.LENGTH_SHORT).show();
        });
        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Bundle bundle = new Bundle();
            bundle.putString("MonHoc", dataList.get(i).getMonHoc());
            bundle.putString("TinChi", dataList.get(i).getTinChi());
            bundle.putString("Desc", dataList.get(i).getDescription());
            bundle.putInt("Image",dataList.get(i).getImage());
            Intent intent = new Intent(this,MainActivity2.class);
            intent.putExtras(bundle);
            startActivity(intent);
            return true;
        });
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String MonHoc = dataList.get(i).getMonHoc();
            String TinChi = dataList.get(i).getTinChi();
            editText_TinChi.setText(TinChi);
            editText_MonHoc.setText(MonHoc);
            index = i;
            button_Sua.setEnabled(true);
            button_Xoa.setEnabled(true);
        });
    }

    private void setupDataList() {
        for (int i = 0; i<6;i++){
            String MonHoc = ""+i;
            String TinChi = ""+i;
            String Descriptions = "Bế Chí Kiên Thất Bại "+ i +
                    "! If I get hurts, then the hurts will become strength" +
                    "To be a successor, I have to take the losses.";
            int Image = getImage(mapImages);
            dataList.add(new MonHocModelClass(MonHoc,TinChi,Descriptions,Image));
        }
    }

    private void mapIdToView() {
        button_Sua = findViewById(R.id.button_Sua);
        button_Them = findViewById(R.id.button_Them);
        button_Xoa = findViewById(R.id.button_Xoa);
        editText_MonHoc = findViewById(R.id.editText_MonHoc);
        editText_TinChi = findViewById(R.id.editText_TinChi);
        listView = findViewById(R.id.listView);
        dataList = new ArrayList<>();
        mapImages = new HashMap<>();
        // Set Images for RANDOM
        setImages();
    }

    private void setImages() {
        mapImages.put(0, R.raw.inosuke_avatar);
        mapImages.put(1, R.raw.shinobu_avatar);
        mapImages.put(2, R.raw.ubuyashiki_avatar);
        mapImages.put(3, R.raw.tanjiro_avatar);
        mapImages.put(4, R.raw.nezuko_avatar);
        mapImages.put(5, R.raw.kanao_avatar);
        mapImages.put(6, R.raw.zenistu_avatar);
        mapImages.put(7, R.raw.rengoku_avatar);
        mapImages.put(8, R.raw.kokushibo_avatar);
        mapImages.put(9, R.raw.tanjiro_demon);
        mapImages.put(10, R.raw.nezuko_demon);
        mapImages.put(11, R.raw.mitsuri_avatar);
        mapImages.put(12, R.raw.muichiro_avatar);
        mapImages.put(13, R.raw.muzan_avatar);
        mapImages.put(14, R.raw.enmu_avatar);
        mapImages.put(15, R.raw.kukoshibo_avatar_2);
        mapImages.put(16, R.raw.gyomei_avatar);
        mapImages.put(17, R.raw.sabito_avatar);
        mapImages.put(18, R.raw.shinazugawa_avatar);
        mapImages.put(19, R.raw.tamayo_avatar);
        mapImages.put(20, R.raw.tomioka_avatar);
        mapImages.put(21, R.raw.yoriichi_avatar);
        mapImages.put(22, R.raw.yuugiri_geisha_avatar);
        mapImages.put(23, R.raw.uzui_avatar);
        mapImages.put(24, R.raw.sakonji_urokodaki_avatar);
        mapImages.put(25, R.raw.susamaru_avatar);
        mapImages.put(26, R.raw.spider_mother);
        mapImages.put(27, R.raw.obanai_avatar);
        mapImages.put(28, R.raw.junikizuki_avatar);
        mapImages.put(29, R.raw.douma_avatar);
        mapImages.put(30, R.raw.daki_avatar);
        mapImages.put(31, R.raw.akaza_avatar);
    }

    private int getImage(@NonNull Map map) {
        Random render = new Random();
        int x = render.nextInt(map.size());
        return Objects.requireNonNull(map.get(x)).hashCode();
    }
}