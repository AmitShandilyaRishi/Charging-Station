package com.amit.chargingstations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button View_List_Of_Charging_Station;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View_List_Of_Charging_Station = findViewById(R.id.View_List_Of_Charging_Station);

        View_List_Of_Charging_Station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListsActivity.class);
                startActivity(intent);
            }
        });
    }
}