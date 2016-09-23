package com.example.main;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import DBWorking.DBHelper;
import DBWorking.DBMethods;
import calculations.Calculations;
import model.EatenProduct;
import model.Information;
import model.Product;
import model.User;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    final String LOG_TAG = "MainActivity_Logs";
    final String LOG_TAG1 = "MainActivity_Logs1";
    Calculations calculations;
    DBMethods dbMethods;
    DBHelper dbHelper;
    ArrayList<EatenProduct> eatenProductArrayList = new ArrayList<EatenProduct>();
    ArrayList<Information> informationArrayList = new ArrayList<Information>();

    int colories = 0;
    DateFormat dateFormat ;
    Calendar calendar;
    Date date ;
    String year ;
    String month;
    String day ;
    String hour ;
    String min ;
    User logedUser;
    public TextView textViewlogedUserName ;
    TextView textViewlogedUserAge ;
    TextView textViewlogedUserHeight ;
    TextView textViewlogedUserWeight ;
    TextView textViewlogedUserGoal;
    TextView textViewlogedUserLifeStyle;
    TextView textViewlogedUserNormalCalories ;
    TextView textViewlogedUserNormalCurrentCallories ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = Calendar.getInstance();
        colories = 0;

        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = new Date();
        dateFormat.format(date);
        year = String.valueOf(calendar.get(calendar.YEAR));
        month = String.valueOf(calendar.get(calendar.MONTH)+1);
        day = String.valueOf(calendar.get(calendar.DAY_OF_MONTH));
        hour = String.valueOf(date.getHours());
        min = String.valueOf(date.getMinutes());
        dbHelper = new DBHelper(this);
        dbMethods = new DBMethods();


        logedUser = (User) getIntent().getParcelableExtra(User.class.getCanonicalName());
        Log.d(LOG_TAG1, "Size information array = " + informationArrayList.size());

        eatenProductArrayList = dbMethods.getAllEatenProducts(dbHelper, dbMethods.getAllProducts(dbHelper), month,day,100,logedUser.getId()+"");





        Product peas = new Product(1,"Peas",81,"5","0.4","14.0");
        Product rice = new Product(1,"Rice",284,"7.3","2.6","63.1");
        Product wheat_bread = new Product(1,"Wheat bread",203,"8.1","1.2","42.0");
        Product potatoes = new Product(1,"Potatoes",83,"2.0","0.1","19.7");
        Product ham = new Product(1,"Ham",355,"10.0","35.0","0.0");
        Product chicken_eggs = new Product(1,"Chicken eggs",157,"12.7","11.5","0.7");
        Product milk = new Product(1,"Milk 1.5%",44,"2.9","1.5","4.7");
        Product source_cream = new Product(1,"Source cream 10%",116,"3.0","10.0","2.9");
        Product curd = new Product(1,"Curd",159,"16.7","9.0","2.0");


        dbMethods.addNewProduct(peas,dbHelper);
        dbMethods.addNewProduct(rice,dbHelper);
        dbMethods.addNewProduct(wheat_bread,dbHelper);
        dbMethods.addNewProduct(potatoes,dbHelper);
        dbMethods.addNewProduct(chicken_eggs,dbHelper);
        dbMethods.addNewProduct(ham,dbHelper);
        dbMethods.addNewProduct(milk,dbHelper);
        dbMethods.addNewProduct(source_cream,dbHelper);
        dbMethods.addNewProduct(curd,dbHelper);


        Log.d(LOG_TAG, "Loged user ID = " + logedUser.getId());
        Log.d(LOG_TAG, "Loged user name = " + logedUser.getName());
        Log.d(LOG_TAG, "Loged user goal = " + logedUser.getGoal());
        Log.d(LOG_TAG, "Loged user life_style = " + logedUser.getLifeStyle());
        Log.d(LOG_TAG, "Loged user height = " + logedUser.getHeight());
        Log.d(LOG_TAG, "Loged user weight = " + logedUser.getWeight());
        Log.d(LOG_TAG, "Loged user age = " + logedUser.getAge());
        Log.d(LOG_TAG, "Loged user sex = " + logedUser.getSex());



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        calculations = new Calculations();

        textViewlogedUserName = (TextView) findViewById(R.id.newName);
        textViewlogedUserAge = (TextView) findViewById(R.id.newAge);
        textViewlogedUserHeight = (TextView) findViewById(R.id.newHeight);
        textViewlogedUserWeight = (TextView) findViewById(R.id.newWeight);
        textViewlogedUserGoal = (TextView) findViewById(R.id.textViewLogedUserGoal);
        textViewlogedUserNormalCalories = (TextView) findViewById(R.id.textViewLogedUserNormalCalories);
        textViewlogedUserNormalCurrentCallories = (TextView) findViewById(R.id.textViewLogedUserCturrentCallories);
        textViewlogedUserLifeStyle = (TextView)findViewById(R.id.textViewLogedUserLifeStyle);

        textViewlogedUserName.setText("Name: "+logedUser.getName());
        textViewlogedUserAge.setText("Age: "+logedUser.getAge());
        textViewlogedUserHeight.setText("Height: "+logedUser.getHeight());
        textViewlogedUserWeight.setText("Weight: "+logedUser.getWeight());
        textViewlogedUserGoal.setText("Goal: "+logedUser.getGoal());
        textViewlogedUserLifeStyle.setText("Style: " + logedUser.getLifeStyle());
        textViewlogedUserNormalCalories.setText("Normal calories: "+calculations.OnCalcGeneralFormula(logedUser.getHeight(),logedUser.getWeight(),logedUser.getAge(),logedUser.getSex(),logedUser.getLifeStyle(),logedUser.getGoal()));

        for(int i = 0;i<eatenProductArrayList.size();i++){
            colories +=eatenProductArrayList.get(i).getProduct().getCalorie();

        }

        textViewlogedUserNormalCurrentCallories.setText("Curren calories: " + colories);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        colories = 0;

        ArrayList<User> editedUser = new ArrayList<User>();

        editedUser = dbMethods.getAllUsers(dbHelper);

        for (int i= 0;i < editedUser.size();i++){
            if (logedUser.getId()==editedUser.get(i).getId()){
                textViewlogedUserName.setText("Name: " + editedUser.get(i).getName());
                textViewlogedUserAge.setText("Age: "+editedUser.get(i).getAge());
                textViewlogedUserHeight.setText("Height: "+editedUser.get(i).getHeight());
                textViewlogedUserWeight.setText("Weight: "+editedUser.get(i).getWeight());
                textViewlogedUserGoal.setText("Goal: "+editedUser.get(i).getGoal());
                textViewlogedUserLifeStyle.setText("Style: " + editedUser.get(i).getLifeStyle());
                textViewlogedUserNormalCalories.setText("Normal calories: "+calculations.OnCalcGeneralFormula(editedUser.get(i).getHeight(),editedUser.get(i).getWeight(),editedUser.get(i).getAge(),editedUser.get(i).getSex(),editedUser.get(i).getLifeStyle(),editedUser.get(i).getGoal()));
            }
        }


        /*
        textViewlogedUserName.setText("Name: "+logedUser.getName());
        textViewlogedUserAge.setText("Age: "+logedUser.getAge());
        textViewlogedUserHeight.setText("Height: "+logedUser.getHeight());
        textViewlogedUserWeight.setText("Weight: "+logedUser.getWeight());
        textViewlogedUserGoal.setText("Goal: "+logedUser.getGoal());
        textViewlogedUserLifeStyle.setText("Style: " + logedUser.getLifeStyle());
        textViewlogedUserNormalCalories.setText("Normal calories: "+calculations.OnCalcGeneralFormula(logedUser.getHeight(),logedUser.getWeight(),logedUser.getAge(),logedUser.getSex(),logedUser.getLifeStyle(),logedUser.getGoal()));
        */

        eatenProductArrayList = dbMethods.getAllEatenProducts(dbHelper, dbMethods.getAllProducts(dbHelper), month, day, 100,logedUser.getId()+"");

        for(int i = 0;i<eatenProductArrayList.size();i++){
            colories +=eatenProductArrayList.get(i).getProduct().getCalorie();

        }

        textViewlogedUserNormalCurrentCallories.setText("Curren calories: " + colories);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this,EditUser.class);
            intent.putExtra(User.class.getCanonicalName(),logedUser);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.diary) {
            Intent intent = new Intent(MainActivity.this,Colorie_Diary_Activity.class);
            intent.putExtra(User.class.getCanonicalName(),logedUser);
            startActivity(intent);
        } else if (id == R.id.list_products) {
            Intent intent = new Intent(MainActivity.this,ListProductsActivity.class);
            startActivity(intent);
        } else if (id == R.id.calculations) {

            Intent intent = new Intent(MainActivity.this,FormulesActivity.class);
            intent.putExtra(User.class.getCanonicalName(),logedUser);
            startActivity(intent);


        } else if (id == R.id.calendar) {
            Intent intent = new Intent(MainActivity.this,CalendarActivity.class);
            intent.putExtra(User.class.getCanonicalName(),logedUser);

            startActivity(intent);
        } else if (id == R.id.helpful_information) {
            /*
            Intent intent = new Intent(MainActivity.this,InformationActivity.class);
            startActivity(intent);
            */

        } else if (id == R.id.settings) {
            Intent intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
