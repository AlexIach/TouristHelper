package com.qoobico.remindme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConcreteSightActivity extends AppCompatActivity {
    private TextView tvSightName;
    private TextView tvSightCountry;
    private TextView tvSightDescription;
    private String coordinationToShowOnMap;
    private Button btnShowOnMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concrete_sight);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String country = intent.getStringExtra("country");
        String coordination = intent.getStringExtra("coordination");
        String descriptiton = intent.getStringExtra("description");
        coordinationToShowOnMap = coordination;

        tvSightName = (TextView)findViewById(R.id.tvSightName);
        tvSightCountry = (TextView)findViewById(R.id.tvSightsCountry);
        tvSightDescription = (TextView)findViewById(R.id.tvSightDescription);

        btnShowOnMap = (Button)findViewById(R.id.btnShowOnMap);


        //Toast.makeText(this,"Id = "+ id + " Name = " + name + " Country = " + country + " Coordination = "+ coordination + " Description = " + descriptiton,Toast.LENGTH_LONG).show();
        tvSightName.setText(name);
        tvSightCountry.setText(country);
        tvSightDescription.setText(descriptiton);
    }

    public  void showOnMap(View view){
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("coordination",coordinationToShowOnMap);
        startActivity(intent);
    }

}
