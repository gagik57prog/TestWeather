package cz.martykan.forecastie.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import cz.martykan.forecastie.R;
import cz.martykan.forecastie.adapters.MyRecyclerViewAdapter;

    public class BaseActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

        MyRecyclerViewAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ArrayList<String> townNames = new ArrayList<>();
            townNames.add("Yerevan");
            townNames.add("Moscow");
            townNames.add("London");
            townNames.add("Berlin");
            townNames.add("Madrid");

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvAnimals);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new MyRecyclerViewAdapter(this, townNames);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);
        }

        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("name", adapter.getItem(position));
            startActivity(intent);


        }
    }