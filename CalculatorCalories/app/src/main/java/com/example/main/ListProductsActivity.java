package com.example.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import DBWorking.DBHelper;
import DBWorking.DBMethods;
import adapters.CustomListAdapter;
import adapters.ProductListAdapter;
import model.Product;

public class ListProductsActivity extends AppCompatActivity {
    final String LOG_TAG = "List_Products";
    DBMethods dbMethods;
    DBHelper dbHelper;
    Button buttonSearch;
    EditText etSearchProduct;
    String strProduct;
    ArrayList<Product> productsList = new ArrayList<Product>();
    ProductListAdapter productListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);
        dbHelper = new DBHelper(this);
        dbMethods = new DBMethods();
        buttonSearch = (Button)findViewById(R.id.btnSearchProduct);
        etSearchProduct = (EditText)findViewById(R.id.etSearchTheProduct);

        fillData();

        productListAdapter = new ProductListAdapter(this, productsList);

        ListView lvMain = (ListView) findViewById(R.id.lvProductsList);
        lvMain.setAdapter(productListAdapter);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        fillData();
    }

    public void fillData(){
        productsList = dbMethods.getAllProducts(dbHelper);
        Log.d(LOG_TAG, "Array size = " + productsList.size());
   }

    public void onSearchTheProduct(View view){
        strProduct = etSearchProduct.getText().toString();
        if(strProduct.length()>0){
            for (int i=0;i<productsList.size();i++){
                if(productsList.get(i).getName().equalsIgnoreCase(strProduct)){
                    Toast.makeText(getApplicationContext(),"Product's name = " + productsList.get(i).getName() + " Product's calories  = "+productsList.get(i).getCalorie() +  "Product's info = " + productsList.get(i).getProteine() + "/"+ productsList.get(i).getFats()+ "/"+ productsList.get(i).getCarbohydrates()+"",Toast.LENGTH_LONG ).show();
                    break;
                }
            }
        }else Toast.makeText(getApplicationContext(),"Fill the row ",Toast.LENGTH_LONG).show();
    }
}
