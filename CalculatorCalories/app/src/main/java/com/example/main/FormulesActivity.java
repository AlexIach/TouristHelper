package com.example.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import model.User;

public class FormulesActivity extends AppCompatActivity {
    Button buttonMIfflineSeJeora;
    Button buttonHarrisBenedikt;
    Button buttonHarrisBenediktNew;
    Button woh;
    User user;
    String LOG_TAG = "FormulesActivityLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formules);
        buttonHarrisBenedikt = (Button)findViewById(R.id.buttonMIfflineSeJeora);
        buttonMIfflineSeJeora = (Button)findViewById(R.id.buttonMIfflineSeJeora);
        buttonHarrisBenediktNew = (Button)findViewById(R.id.buttonHarrisBenediktNew);
        woh = (Button)findViewById(R.id.woh);
        user = (User) getIntent().getParcelableExtra(User.class.getCanonicalName());
        Log.d(LOG_TAG, user.getName());
    }

    public void onClickbuttonbuttonMIfflineSeJeora(View v){
        Intent intent = new Intent(FormulesActivity.this,InfoCalculations.class);
        intent.putExtra(User.class.getCanonicalName(),user);
        intent.putExtra("formulaName","mifflineSeJeora");
        startActivity(intent);
    }

    public void onClickbuttonHarrisBenedikt(View v){
        Intent intent = new Intent(FormulesActivity.this,InfoCalculations.class);
        intent.putExtra(User.class.getCanonicalName(),user);
        intent.putExtra("formulaName","harrisBenedikt");
        startActivity(intent);
    }

    public void onClickButtonHarrisBenediktNew(View v){
        Intent intent = new Intent(FormulesActivity.this,InfoCalculations.class);
        intent.putExtra(User.class.getCanonicalName(),user);
        intent.putExtra("formulaName","harrisBenediktNew");
        startActivity(intent);
    }

    public void onClickWoh(View v){
        Intent intent = new Intent(FormulesActivity.this,InfoCalculations.class);
        intent.putExtra(User.class.getCanonicalName(),user);
        intent.putExtra("formulaName","woh");
        startActivity(intent);
    }
}
