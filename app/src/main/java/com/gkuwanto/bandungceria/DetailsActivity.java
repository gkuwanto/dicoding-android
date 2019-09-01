package com.gkuwanto.bandungceria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;



public class DetailsActivity extends AppCompatActivity {
    protected String summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempat);
        Intent i = getIntent();
        String name = i.getStringExtra("NAME");
        this.summary = i.getStringExtra("SUMMARY");
        setTitle(name);

        ImageView ivDetail = findViewById(R.id.ivDetail);
        TextView tvSummary = findViewById(R.id.tvSummary);

        tvSummary.setText(summary);

        switch (name){
            case "Farmhouse Lembang":
                ivDetail.setImageResource(R.drawable.farmhouse);
                break;
            case "Kebun Teh Sukawana":
                ivDetail.setImageResource(R.drawable.kebun_teh);
                break;
            case "Pinisi Resto Dan Glamping Lakeside Ciwidey":
                ivDetail.setImageResource(R.drawable.pinisi_resto);
                break;
            case "Curug Cinulang Cicalengka":
                ivDetail.setImageResource(R.drawable.curug_cinulang);
                break;
            case "Kawah Putih Ciwidey":
                ivDetail.setImageResource(R.drawable.kawah_putih);
                break;
            case "Danau Situ Patenggang":
                ivDetail.setImageResource(R.drawable.situ_patenggang);
                break;
            case "Maribaya Bandung":
                ivDetail.setImageResource(R.drawable.maribaya_bandung);
                break;
            case "Museum Geologi Bandung":
                ivDetail.setImageResource(R.drawable.geologi);
                break;
            case "Observatorium Bosscha":
                ivDetail.setImageResource(R.drawable.observatorium_boscha);
                break;
            case "Tebing Keraton Bandung":
                ivDetail.setImageResource(R.drawable.tebingkeraton);
                break;
            default:
                ivDetail.setImageResource(R.drawable.profile);
                break;
        }
    }

}
