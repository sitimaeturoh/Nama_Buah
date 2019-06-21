package com.sitimaeturoh.androiddasar3list;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String [] namaBuah={
            "Alpukat",
            "Apel",
            "Ceri",
            "Duarian",
            "Jambu Air",
            "Manggis",
            "Strawberry"
    };
    int[] gambarBuah = {
            //ctrl+D = duplikat 1 baris
            R.drawable.alpukat,
            R.drawable.apel,
            R.drawable.ceri,
            R.drawable.durian,
            R.drawable.jambuair,
            R.drawable.manggis,
            R.drawable.strawberry,
    };

    int[] suaraBuah = {
            R.raw.alpukat,
            R.raw.apel,
            R.raw.ceri,
            R.raw.durian,
            R.raw.jambuair,
            R.raw.manggis,
            R.raw.strawberry,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listview);

       // ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, namaBuah);
        CustomListAdapter adapter = new CustomListAdapter(MainActivity.this, namaBuah, gambarBuah);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer.create(MainActivity.this, R.raw.alpukat).start();

                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra(Konstanta.DATANAMA, namaBuah[position]);
                i.putExtra(Konstanta.DATAGAMBAR, gambarBuah[position]);
                startActivity(i);
            }
        });
    }
}
