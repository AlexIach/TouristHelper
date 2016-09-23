package com.example.main;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import DBWorking.DBHelper;
import DBWorking.DBMethods;
import model.User;

public class RegLogActivity extends AppCompatActivity {
    Button buttonLogIn;
    String loginUserName;
    String loginUserPassword;
    final String LOG_TAG = "Login_Logs";
    EditText userName;
    EditText password;
    Button buttonReg;
    ArrayList<User> userArrayList;
    DBMethods dbMethods;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_log);
        buttonLogIn = (Button)findViewById(R.id.buttonLogIn);
        dbHelper = new DBHelper(this);
        dbMethods = new DBMethods();

        buttonReg = (Button)findViewById(R.id.btnR);

    }
    public void onLogIn (View v){
        LayoutInflater li = LayoutInflater.from(this);
        View loginform = li.inflate(R.layout.loginform, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(loginform);
        userName = (EditText) loginform.findViewById(R.id.etUserNameLogin);
        password = (EditText) loginform.findViewById(R.id.etPasswordLogin);

        final Button buttonLogIn = (Button) loginform.findViewById(R.id.buttonLogin);
        alertDialogBuilder.setTitle(R.string.login_form);
        alertDialogBuilder.show();
    }

    public void onLogInMainActivity (View v){

        loginUserName = userName.getText().toString();
        loginUserPassword = password .getText().toString();

        if(loginUserName.length()==0){
            Toast.makeText(getApplicationContext(), "Rows are not filled!", Toast.LENGTH_SHORT).show();
        }else if(loginUserPassword.length()==0){
            Toast.makeText(getApplicationContext(), "Rows are not filled!", Toast.LENGTH_SHORT).show();
        }else {
            userArrayList = dbMethods.getAllUsers(dbHelper);
            User us = new User();

            Log.d(LOG_TAG,"userArrayListSize =" + userArrayList.size());
            for (int i=0;i<userArrayList.size();i++){
                Log.d(LOG_TAG,"userArrayList.Id =" + userArrayList.get(i).getId());
                Log.d(LOG_TAG,"userArrayList.Name =" + userArrayList.get(i).getName());
                Log.d(LOG_TAG,"userArrayList.Password =" + userArrayList.get(i).getName());
                Log.d(LOG_TAG,"You entered loginUserName =" + loginUserName);
                Log.d(LOG_TAG,"You entered loginUserPassw =" + loginUserPassword);



                if(loginUserName.equalsIgnoreCase(userArrayList.get(i).getName()) && loginUserPassword.equalsIgnoreCase(userArrayList.get(i).getPassword())){
                    loginUserName = null;
                    loginUserPassword = null;

                    Intent intent = new Intent(RegLogActivity.this, MainActivity.class);
                    intent.putExtra(User.class.getCanonicalName(), userArrayList.get(i));
                    startActivity(intent);

                    break;

                }
            }
        }
    }

    public void onRegistration (View v){
        Intent intent = new Intent(RegLogActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }

}
