package com.example.main;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import DBWorking.DBHelper;
import DBWorking.DBMethods;
import model.User;

public class EditUser extends AppCompatActivity {

    EditText etEditName;
    EditText etEditAge;
    EditText etEditHeight;
    String LOG_TAG = "MyLogsEdit";
    EditText etEditWeight;
    Spinner spinnerGoal;
    Spinner spinnerLifeStyle;
    String newName;
    String newAge;
    String newHeight;
    String newWeight;
    String newGoal;
    String newLifeStyle;
    FloatingActionButton editUserPropButton;
    public final int ARRAY_GOALS = R.array.goals;
    public final int ARRAY_LIFE_STYLE = R.array.life_style;
    public final int LAYOUT_SPINNER_ITEM = R.layout.spinner_item;
    public final int LAYOUT_SPINNER_ITEM_DROP_DOWN = R.layout.spinner_dropdown_item;
    User editUser;

    DBMethods dbMethods;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        dbHelper = new DBHelper(this);
        dbMethods = new DBMethods();

        editUser = (User) getIntent().getParcelableExtra(User.class.getCanonicalName());

        etEditName = (EditText)findViewById(R.id.etEditName);
        etEditAge = (EditText)findViewById(R.id.etEditAge);
        etEditHeight = (EditText)findViewById(R.id.etEditHeight);
        etEditWeight = (EditText)findViewById(R.id.etEditWeight);
        spinnerGoal = (Spinner)findViewById(R.id.spinnerEditGoal);
        spinnerLifeStyle = (Spinner)findViewById(R.id.spinnerEditLifeStyle);
        editUserPropButton = (FloatingActionButton)findViewById(R.id.fabEditUserPropButton);


        ArrayAdapter<CharSequence> goalAdapter = ArrayAdapter.createFromResource(this,ARRAY_GOALS, LAYOUT_SPINNER_ITEM);
        goalAdapter.setDropDownViewResource(LAYOUT_SPINNER_ITEM_DROP_DOWN);
        spinnerGoal.setAdapter(goalAdapter);
        spinnerGoal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] choose = getResources().getStringArray(R.array.goals);
                newGoal = choose[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> adapterLifeStyle = ArrayAdapter.createFromResource(this,ARRAY_LIFE_STYLE, LAYOUT_SPINNER_ITEM);
        // Определяем разметку для использования при выборе элемента
        adapterLifeStyle.setDropDownViewResource(LAYOUT_SPINNER_ITEM_DROP_DOWN);
        // Применяем адаптер к элементу spinner
        spinnerLifeStyle.setAdapter(adapterLifeStyle);
        //Обработчик

        spinnerLifeStyle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] choose = getResources().getStringArray(R.array.life_style);
                newLifeStyle = choose[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        editUserPropButton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Snackbar.make(v, getString(R.string.reg),Snackbar.LENGTH_LONG).
                        setAction(R.string.yes, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (etEditName.getText().toString().length() == 0) {
                                    Toast.makeText(getApplicationContext(), "Some rows are not filled!", Toast.LENGTH_SHORT).show();

                                } else if (etEditHeight.getText().toString().length() == 0) {
                                    Toast.makeText(getApplicationContext(), "Some rows are not filled!", Toast.LENGTH_SHORT).show();

                                } else if (etEditAge.getText().toString().length() == 0) {
                                    Toast.makeText(getApplicationContext(), "Some rows are not filled!", Toast.LENGTH_SHORT).show();

                                } else if (etEditWeight.getText().toString().length() == 0) {
                                    Toast.makeText(getApplicationContext(), "Some rows are not filled!", Toast.LENGTH_SHORT).show();

                                } else {

                                    newName = etEditName.getText().toString();
                                    newAge = etEditAge.getText().toString();
                                    newHeight = etEditHeight.getText().toString();
                                    newWeight = etEditWeight.getText().toString();

                                    /*
                                    Log.d(LOG_TAG, "New Name = " + newName);
                                    Log.d(LOG_TAG, "New Age = " + newAge);
                                    Log.d(LOG_TAG, "New H = " + newHeight);
                                    Log.d(LOG_TAG, "New W = " + newWeight);
                                    Log.d(LOG_TAG, "New G = " + newGoal);
                                    Log.d(LOG_TAG, "New LS = " + newLifeStyle);
                                    */

                                    Log.d(LOG_TAG, "Old Edit user ID = " + editUser.getId());
                                    Log.d(LOG_TAG, "Old Edit user name = " + editUser.getName());
                                    Log.d(LOG_TAG, "Old Edit user goal = " + editUser.getGoal());
                                    Log.d(LOG_TAG, "Old Edit user life_style = " + editUser.getLifeStyle());
                                    Log.d(LOG_TAG, "Old Edit user height = " + editUser.getHeight());
                                    Log.d(LOG_TAG, "Old Edit user weight = " + editUser.getWeight());
                                    Log.d(LOG_TAG, "Old Edit user age = " + editUser.getAge());
                                    Log.d(LOG_TAG, "Old Edit user sex = " + editUser.getSex());



                                    User newUserProp = new User(editUser.getId(), editUser.getPassword(), Integer.parseInt(newAge), Integer.parseInt(newHeight), Integer.parseInt(newWeight), editUser.getSex(), newName, newLifeStyle, newGoal);
                                    Log.d(LOG_TAG, "New Edit user ID = " + newUserProp.getId());
                                    Log.d(LOG_TAG, "New Edit user name = " + newUserProp.getName());
                                    Log.d(LOG_TAG, "New Edit user goal = " + newUserProp.getGoal());
                                    Log.d(LOG_TAG, "New Edit user life_style = " + newUserProp.getLifeStyle());
                                    Log.d(LOG_TAG, "New Edit user height = " + newUserProp.getHeight());
                                    Log.d(LOG_TAG, "New Edit user weight = " + newUserProp.getWeight());
                                    Log.d(LOG_TAG, "New Edit user age = " + newUserProp.getAge());
                                    Log.d(LOG_TAG, "New Edit user sex = " + newUserProp.getSex());

                                    dbMethods.updateUser(newUserProp, dbHelper);


                                    etEditName.setText("");
                                    etEditAge.setText("");
                                    etEditHeight.setText("");
                                    etEditWeight.setText("");

                                }
                            }
                        }).show();
            }
        });



    }
}
