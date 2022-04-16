package com.amit.chargingstations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Object> viewItem = new ArrayList<>();

    private  RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerAdapter(this,viewItem);
        mRecyclerView.setAdapter(mAdapter);


        addItemFromJson();
    }

    private void addItemFromJson() {
        try {
            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i=0; i <jsonArray.length(); ++i)
            {
                JSONObject itemObj = jsonArray.getJSONObject(i);

                String place_name = itemObj.getString("location");
                String latitude = itemObj.getString("latitude");
                String longitude = itemObj.getString("longitude");
                String type = itemObj.getString("type");
                String rating = itemObj.getString("rating");
                String availability = itemObj.getString("availability");

                data data = new data(place_name, latitude, longitude, type, rating, availability);
                viewItem.add(data);
            }
        } catch (JSONException | IOException e){
            Toast.makeText(ListsActivity.this, "AddItemFromJson "+e, Toast.LENGTH_SHORT).show();
        }
    }
    private String readJSONDataFromFile() throws IOException {
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {
            String jsonString = null;
            inputStream = getResources().openRawResource(R.raw.data);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((jsonString = bufferedReader.readLine()) != null){
                builder.append(jsonString);
            }
        } finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
        return new String(builder);
    }
}