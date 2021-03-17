package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private String[] data = {"1","2","3"};
    private List<Picture> pictureList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPictures();
        PictureAdapter adapter = new PictureAdapter(MainActivity.this,R.layout.picture_item, pictureList);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                MainActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Picture picture = pictureList.get(position);//判断用户点击的是哪一个子项
                Toast.makeText(MainActivity.this, picture.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initPictures(){
        for (int i = 0; i < 5; i++){
            Picture pic1 = new Picture("Pic1", R.drawable.timg3);
            pictureList.add(pic1);

            Picture pic2 = new Picture("Pic2",R.drawable.timg14);
            pictureList.add(pic2);

            Picture pic3 = new Picture("Pic3",R.drawable.timg22);
            pictureList.add(pic3);

        }
    }

}
