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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import DBWorking.DBHelper;
import DBWorking.DBMethods;
import model.User;

public class RegistrationActivity extends AppCompatActivity {
    final String LOG_TAG = "Register_Logs";
    public final int ARRAY_GOALS = R.array.goals;
    public final int ARRAY_LIFE_STYLE = R.array.life_style;
    public final int LAYOUT_SPINNER_ITEM = R.layout.spinner_item;
    public final int LAYOUT_SPINNER_ITEM_DROP_DOWN = R.layout.spinner_dropdown_item;

    public User user;
    public String sex = null;
    public String userName= null;
    public String userPassword= null;
    public int userAge = 0;
    public int userWeight = 0;
    public int userHeight =0;
    public String userGoal= null;
    public String userLifeStyle= null;
    DBHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // создаем объект для создания и управления версиями БД
        dbHelper = new DBHelper(this);



        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioSex);
        final RadioButton radioButtonMale =(RadioButton)findViewById(R.id.radioMale);
        final RadioButton radioButtonFemale =(RadioButton)findViewById(R.id.radioFemale);
        final EditText editTextUserName = (EditText)findViewById(R.id.editTextUserName);
        final EditText editTextUserAge = (EditText)findViewById(R.id.editTextUserAge);
        final EditText editTextUserWeight = (EditText)findViewById(R.id.editTextUserWeight);
        final EditText editTextUserHeight = (EditText)findViewById(R.id.editTextUserHeight);
        final EditText editTextUserPassword = (EditText)findViewById(R.id.editTextUserPassword);




        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinnerLifeStyle = (Spinner) findViewById(R.id.spinnerLifeStyle);
        FloatingActionButton register = (FloatingActionButton)findViewById(R.id.fabRegister);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,ARRAY_GOALS, LAYOUT_SPINNER_ITEM);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(LAYOUT_SPINNER_ITEM_DROP_DOWN);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);
        //Обработчик
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] choose = getResources().getStringArray(R.array.goals);
                userGoal = choose[position];
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
                userLifeStyle = choose[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Log.d(LOG_TAG, "No choice");
                        break;
                    case R.id.radioMale:
                        sex = "male";
                        Log.d(LOG_TAG, sex);
                        break;
                    case R.id.radioFemale:
                        sex = "female";
                        Log.d(LOG_TAG, sex);
                        break;
                    default:
                        break;
                }
            }
        });



        register.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {


                Snackbar.make(v, getString(R.string.reg), Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (!radioButtonMale.isChecked() && !radioButtonFemale.isChecked()) {
                                    Toast.makeText(getApplicationContext(), "Rows are not filled!", Toast.LENGTH_SHORT).show();
                                } else if (editTextUserName.getText().toString().length() == 0) {
                                    Toast.makeText(getApplicationContext(), "Rows are not filled!", Toast.LENGTH_SHORT).show();

                                } else if (editTextUserPassword.getText().toString().length() == 0) {
                                    Toast.makeText(getApplicationContext(), "Rows are not filled!", Toast.LENGTH_SHORT).show();

                                } else if (editTextUserAge.getText().toString().length() == 0) {
                                    Toast.makeText(getApplicationContext(), "Rows are not filled!", Toast.LENGTH_SHORT).show();

                                } else if (editTextUserHeight.getText().toString().length() == 0) {
                                    Toast.makeText(getApplicationContext(), "Rows are not filled!", Toast.LENGTH_SHORT).show();

                                } else if (editTextUserWeight.getText().toString().length() == 0) {
                                    Toast.makeText(getApplicationContext(), "Rows are not filled!", Toast.LENGTH_SHORT).show();

                                } else {
                                    userName = editTextUserName.getText().toString();
                                    userAge = Integer.parseInt(editTextUserAge.getText().toString());
                                    userHeight = Integer.parseInt(editTextUserHeight.getText().toString());
                                    userWeight = Integer.parseInt(editTextUserWeight.getText().toString());
                                    userPassword = editTextUserPassword.getText().toString();


                                    editTextUserName.setText("");
                                    editTextUserHeight.setText("");
                                    editTextUserWeight.setText("");
                                    editTextUserPassword.setText("");
                                    editTextUserAge.setText("");
                                    radioButtonFemale.setChecked(false);
                                    radioButtonMale.setChecked(false);

                                    user = new User(1,userPassword, userAge, userHeight, userWeight, sex, userName, userLifeStyle, userGoal);

                                    Log.d(LOG_TAG, "Name =|" + user.getName() + "|");
                                    Log.d(LOG_TAG, "Password =|" + user.getPassword() + "|");
                                    Log.d(LOG_TAG, "Sex =|" + user.getSex() + "|");
                                    Log.d(LOG_TAG, "Age =|" + user.getAge() + "|");
                                    Log.d(LOG_TAG, "Height =|" + user.getHeight() + "|");
                                    Log.d(LOG_TAG, "Weight =|" + user.getWeight() + "|");
                                    Log.d(LOG_TAG, "Goal =|" + user.getGoal() + "|");
                                    Log.d(LOG_TAG, "LifeStyle =|" + user.getLifeStyle() + "|");


                                    DBMethods dbm = new DBMethods();
                                    dbm.registerAccaunt(user,dbHelper);

                                    Toast.makeText(getApplicationContext(), R.string.you_reg_your_account, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegistrationActivity.this,RegLogActivity.class);
                                    startActivity(intent);
                                }

                            }
                        }).show();

            }
        });


    }


}
