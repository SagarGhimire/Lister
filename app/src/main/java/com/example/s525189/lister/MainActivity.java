package com.example.s525189.lister;

import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> drinks = new ArrayList<>();
    ArrayList<Double> prices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drinks.add("Water");
        drinks.add("Coke");
        drinks.add("Pepsi");
        drinks.add("Fanta");
        prices.add(1.99);
        prices.add(2.00);
        prices.add(0.50);
        prices.add(0.90);
        ListAdapter drinkSource = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,android.R.id.text1, drinks){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getView(position,convertView,parent);
                TextView priceTV = v.findViewById(android.R.id.text2);
                priceTV.setText(prices.get(position)+"$");
                return v;

            }
        };
        ListView drinkLV = (ListView)findViewById(R.id.drinkTV);
        drinkLV.setAdapter(drinkSource);


    }
}
