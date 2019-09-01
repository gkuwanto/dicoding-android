package com.gkuwanto.bandungceria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPlaces;
    private ArrayList<Place> list = new ArrayList<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedSetMode) {
        switch (selectedSetMode){
            case R.id.action_credits:
                Intent creditsIntent = new Intent(MainActivity.this, CreditsActivity.class);
                startActivity(creditsIntent);
                break;
            case R.id.action_profile:
                Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPlaces = findViewById(R.id.rv_place);
        rvPlaces.setHasFixedSize(true);

        list.addAll(PlaceData.getListData());
        showRecyclerList();
    }


    private void showRecyclerList(){
        rvPlaces.setLayoutManager(new LinearLayoutManager(this));
        ListPlaceAdapter listPlaceAdapter = new ListPlaceAdapter(list);
        rvPlaces.setAdapter(listPlaceAdapter);

        listPlaceAdapter.setOnItemClickCallback(new ListPlaceAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Place data) {
                showSelectedPlace(data);
            }
        });
    }

    private void showSelectedPlace(Place place) {
        Intent selectedIntent = new Intent(MainActivity.this, DetailsActivity.class);
        selectedIntent.putExtra("NAME", place.getName());
        selectedIntent.putExtra("SUMMARY", place.getSummary());
        startActivity(selectedIntent);
    }
}
