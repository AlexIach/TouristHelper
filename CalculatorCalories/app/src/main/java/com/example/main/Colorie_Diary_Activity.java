package com.example.main;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import DBWorking.DBHelper;
import DBWorking.DBMethods;
import adapters.CustomListAdapter;
import model.EatenProduct;
import model.Product;
import model.User;

public class Colorie_Diary_Activity extends AppCompatActivity {
    final String LOG_TAG = "Colorie_Diary_Logs";
    DBMethods dbMethods;
    DBHelper dbHelper;
    EditText editTextProductsName;
    EditText editTextProductsAmount;
    Context context;
    User logedUser;

    ArrayList<EatenProduct> products = new ArrayList<EatenProduct>();
    ArrayList<EatenProduct> eatenProducts = new ArrayList<EatenProduct>();
    CustomListAdapter customAdapter;
    TextView tvResult;

    DateFormat dateFormat ;
    Calendar calendar;
    Date date ;
    String year ;
    String month;
    String day ;
    String hour ;
    String min ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorie__diary);
        calendar = Calendar.getInstance();
        logedUser = (User) getIntent().getParcelableExtra(User.class.getCanonicalName());
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = new Date();
        dateFormat.format(date);
        year = String.valueOf(calendar.get(calendar.YEAR));
        month = String.valueOf(calendar.get(calendar.MONTH)+1);
        day = String.valueOf(calendar.get(calendar.DAY_OF_MONTH));
        hour = String.valueOf(date.getHours());
        min = String.valueOf(date.getMinutes());

        context = this;
        /*Code part to add some products to table Part 1*/
        /*Already added*/

        /*
        Product peas = new Product(1,"Peas",81,"5","0.4","14.0");
        Product rice = new Product(1,"Rice",284,"7.3","2.6","63.1");
        Product wheat_bread = new Product(1,"Wheat bread",203,"8.1","1.2","42.0");
        Product potatoes = new Product(1,"Potatoes",83,"2.0","0.1","19.7");
        Product ham = new Product(1,"Ham",355,"10.0","35.0","0.0");
        Product chicken_eggs = new Product(1,"Chicken eggs",157,"12.7","11.5","0.7");
        Product milk = new Product(1,"Milk 1.5%",44,"2.9","1.5","4.7");
        Product source_cream = new Product(1,"Source cream 10%",116,"3.0","10.0","2.9");
        Product curd = new Product(1,"Curd",159,"16.7","9.0","2.0");

        */
        editTextProductsName = (EditText)findViewById(R.id.editTextCurrentProductsName);
        editTextProductsAmount = (EditText)findViewById(R.id.etCurrentProductsWeight);
        tvResult = (TextView) findViewById(R.id.tvDayResults);
        dbHelper = new DBHelper(this);
        dbMethods = new DBMethods();

        /*Code part to add some products to table Part 2*/
        /*
        dbMethods.addNewProduct(peas,dbHelper);
        dbMethods.addNewProduct(rice,dbHelper);
        dbMethods.addNewProduct(wheat_bread,dbHelper);
        dbMethods.addNewProduct(potatoes,dbHelper);
        dbMethods.addNewProduct(chicken_eggs,dbHelper);
        dbMethods.addNewProduct(ham,dbHelper);
        dbMethods.addNewProduct(milk,dbHelper);
        dbMethods.addNewProduct(source_cream,dbHelper);
        dbMethods.addNewProduct(curd,dbHelper);
        */





        fillData();
        // создаем адаптер
        customAdapter = new CustomListAdapter(this, products);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.listViewEatenFood);
        lvMain.setAdapter(customAdapter);

    }

    public void refresh(View view){

        products = dbMethods.getAllEatenProducts(dbHelper,dbMethods.getAllProducts(dbHelper),month,day,100,logedUser.getId()+"");
        int resultCalories = 0;
        double resultProteins= 0.0;
        double resultFats= 0.0;
        double resultCHyd= 0.0;

        for (int i=0;i<products.size();i++){
            resultCalories += products.get(i).getProduct().getCalorie();
            resultProteins += Double.parseDouble(products.get(i).getProduct().getProteine());
            resultFats += Double.parseDouble(products.get(i).getProduct().getFats());
            resultCHyd += Double.parseDouble(products.get(i).getProduct().getCarbohydrates());
        }

        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formatPr = decimalFormat.format(resultProteins);
        String formatFt = decimalFormat.format(resultFats);
        String formatCHyd = decimalFormat.format(resultCHyd);

        tvResult.setText("Result: Calories = " + resultCalories + "  " + "Pr/Ft/C-Hyd = " + formatPr + "/" + formatFt+ "/" + formatCHyd);
    }
    public void AddEatenProductToDB(View view){

        if(editTextProductsName.getText().length()>0&&editTextProductsAmount.getText().length()>0) {
            eatenProducts = dbMethods.getAllEatenProducts(dbHelper, dbMethods.getAllProducts(dbHelper), month, day, 100,logedUser.getId()+"");

            Log.d(LOG_TAG, "Size  eatenProducts " + eatenProducts.size());

            String prName = editTextProductsName.getText().toString();
            int prAmount = Integer.parseInt(editTextProductsAmount.getText().toString());
            ArrayList<Product> existProducts = dbMethods.getAllProducts(dbHelper);

            //dbMethods.addNewEatenProduct(prName, prAmount, year, month, day, hour, min, existProducts, context, dbHelper);

            dbMethods.addNewEatenProduct(prName, prAmount, year, month, day, hour, min, existProducts, context, dbHelper,logedUser.getId()+"");

            eatenProducts = dbMethods.getAllEatenProducts(dbHelper, dbMethods.getAllProducts(dbHelper), month, day, 100,logedUser.getId()+"");

            Log.d(LOG_TAG, "Size  eatenProducts " + eatenProducts.size());

            customAdapter.updateAdapter(eatenProducts);

            refreshResultData(eatenProducts);

            Toast.makeText(getApplicationContext(), "You added food to the diary !", Toast.LENGTH_LONG).show();
            editTextProductsName.setText("");
            editTextProductsAmount.setText("");
        }else Toast.makeText(getApplicationContext(),"Fill the rows ",Toast.LENGTH_SHORT).show();




    }
    // генерируем данные для адаптера // затем поставить этот метод в обработчик кнопки , которая длобавляет еду в БД
    void fillData() {
        products = dbMethods.getAllEatenProducts(dbHelper,dbMethods.getAllProducts(dbHelper),month,day,100,logedUser.getId()+"");
        Log.d(LOG_TAG, "Array size = " + products.size());

        refreshResultData(products);

    }
    void refreshResultData(ArrayList<EatenProduct> arrayList){
        arrayList = dbMethods.getAllEatenProducts(dbHelper,dbMethods.getAllProducts(dbHelper),month,day,100,logedUser.getId()+"");
        int resultCalories = 0;
        double resultProteins= 0.0;
        double resultFats= 0.0;
        double resultCHyd= 0.0;

        for (int i=0;i<products.size();i++){
            resultCalories += products.get(i).getProduct().getCalorie();
            resultProteins += Double.parseDouble(products.get(i).getProduct().getProteine());
            resultFats += Double.parseDouble(products.get(i).getProduct().getFats());
            resultCHyd += Double.parseDouble(products.get(i).getProduct().getCarbohydrates());
        }

        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formatPr = decimalFormat.format(resultProteins);
        String formatFt = decimalFormat.format(resultFats);
        String formatCHyd = decimalFormat.format(resultCHyd);

        tvResult.setText("Result: Calories = " + resultCalories + "  " + "Pr/Ft/C-Hyd = " + formatPr + "/" + formatFt+ "/" + formatCHyd);

    }
}
