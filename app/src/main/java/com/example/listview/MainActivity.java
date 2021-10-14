package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String [] data={"霸天邪神","逆天邪神","邪龙邪神","广西表妹","远古狗皇","日地邪神","洗澡邪神","坨子战神","骚俊天帝","天阳圣王","远古邪神"};
    private List<Map<String,Object>> d_list;
    private int[] img={R.drawable.mi,R.drawable.nitian,R.drawable.chenlong,R.drawable.biaomei,R.drawable.p_2,R.drawable.ridi,R.drawable.ahui,
            R.drawable.tuozijie,R.drawable.saojun,R.drawable.djy,R.drawable.suixin};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d_list=new ArrayList<Map<String,Object>>();
        getData();
        DogAdapter list= new DogAdapter(MainActivity.this,R.layout.listview_item,d_list);
        ListView listView=findViewById(R.id.list_view);
        listView.setAdapter(list);
        Map map=d_list.get(0);
        System.out.println(map.get("text"));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Map map=d_list.get(position);
//                Toast.makeText(MainActivity.this,map.get("text").toString(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
        });


    }

    public List<Map<String,Object>> getData() {
        for (int j=0;j<2;j++){
            for(int i=0;i<img.length;i++){
                Map<String,Object> data1=new HashMap<String,Object>();
                data1.put("img",img[i]);
                data1.put("text",data[i]);
                d_list.add(data1);
            }
        }
        return d_list;
    }



}