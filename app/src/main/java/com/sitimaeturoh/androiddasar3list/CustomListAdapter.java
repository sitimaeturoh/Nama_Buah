package com.sitimaeturoh.androiddasar3list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {
    private Context context;
    private  String[] namabuah;
    private int[] gambarbuah;

    //klik kanan + generate + constructor

    public CustomListAdapter(Context context, String[] namabuah, int[] gambarbuah) {
        super(context,R.layout.item_buah, namabuah);
        this.context = context;
        this.namabuah = namabuah;
        this.gambarbuah = gambarbuah;
    }

    //getview



    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //aturlayutitem
        View view = LayoutInflater.from(context).inflate(R.layout.item_buah, parent, false);
        //findviewbyid

        TextView tvNamaBuah = view.findViewById(R.id.tv_detail_nama);
        ImageView ivGambarBuah = view.findViewById(R.id.iv_detail_gambar);
        //setadata
        tvNamaBuah.setText(namabuah[position]);
        ivGambarBuah.setImageResource(gambarbuah[position]);

        return view;
    }
}

