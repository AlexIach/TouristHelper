package com.example.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import calculations.Calculations;
import model.User;

public class CalculationsActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvAge;
    TextView tvHeight;
    TextView tvWeight;
    TextView tvGoal;
    TextView tvStyle;
    Calculations calculations;
    TextView tvNormalCalories;
    User user;
    int calories;
    String formulaName;
    String LOG_TAG = "CalcFormula";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculations);
        Intent intent = getIntent();
        calculations = new Calculations();
        user = (User) getIntent().getParcelableExtra(User.class.getCanonicalName());
        formulaName = intent.getStringExtra("formulaName");



        Log.d(LOG_TAG, "Name =|" + user.getName() + "|");
        Log.d(LOG_TAG, "Password =|" + user.getPassword() + "|");
        Log.d(LOG_TAG, "Sex =|" + user.getSex() + "|");
        Log.d(LOG_TAG, "Age =|" + user.getAge() + "|");
        Log.d(LOG_TAG, "Height =|" + user.getHeight() + "|");
        Log.d(LOG_TAG, "Weight =|" + user.getWeight() + "|");
        Log.d(LOG_TAG, "Goal =|" + user.getGoal() + "|");
        Log.d(LOG_TAG, "LifeStyle =|" + user.getLifeStyle() + "|");
        Log.d(LOG_TAG, "FoemulaName =|" + formulaName + "|");

        tvName = (TextView) findViewById(R.id.newNameNF);
        tvAge = (TextView) findViewById(R.id.newAgeNF);
        tvHeight = (TextView) findViewById(R.id.newHeightNF);
        tvWeight = (TextView) findViewById(R.id.newWeightNF);
        tvGoal = (TextView) findViewById(R.id.textViewLogedUserGoalNF);
        tvNormalCalories = (TextView) findViewById(R.id.textViewLogedUserNormalCaloriesNF);
        tvStyle = (TextView)findViewById(R.id.textViewLogedUserLifeStyleNF);
        Log.d(LOG_TAG, "User name = " + user.getName() + " FormulaName =  " + formulaName);

        tvName.setText("Name: " + user.getName());
        tvAge.setText("Age: " + user.getAge());
        tvHeight.setText("Height: "+user.getHeight());
        tvWeight.setText("Weight: "+user.getWeight());
        tvGoal.setText("Goal: "+user.getGoal());
        tvStyle.setText("LifeStyle: "+user.getLifeStyle());

        if(formulaName.equalsIgnoreCase("mifflineSeJeora")){
            calories = calculations.OnCalcGeneralFormula(user.getHeight(),user.getWeight(),user.getAge(),user.getSex(),user.getLifeStyle(),user.getGoal());
            tvNormalCalories.setText("Normal Callories: " + calories);

        }else if(formulaName.equalsIgnoreCase("harrisBenedikt")){
            calories = calculations.OnCalcHarrisBenediktFormula(user.getHeight(), user.getWeight(), user.getAge(), user.getSex(), user.getLifeStyle(), user.getGoal());
            tvNormalCalories.setText("Normal Callories: " + calories);

        }else if(formulaName.equalsIgnoreCase("harrisBenediktNew")){
            calories = calculations.OnCalcharrisBenediktNewFormula(user.getHeight(), user.getWeight(), user.getAge(), user.getSex(), user.getLifeStyle(), user.getGoal());
            tvNormalCalories.setText("Normal Callories: " + calories);

        }else if(formulaName.equalsIgnoreCase("woh")){
            calories = calculations.OnCalcWohFormula(user.getHeight(),user.getWeight(),user.getAge(),user.getSex(),user.getLifeStyle(),user.getGoal());
            tvNormalCalories.setText("Normal Callories: " + calories);

        }

    }
}
