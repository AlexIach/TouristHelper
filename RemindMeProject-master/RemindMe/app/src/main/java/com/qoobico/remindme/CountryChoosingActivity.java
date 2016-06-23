package com.qoobico.remindme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CountryChoosingActivity extends AppCompatActivity {
    private String choosingCountry;
    Spinner spinner;
    String[] data = {"Moldova", "Russia", "Italy", "USA", "France","United Kingdom"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_choosing);
        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt(getString(R.string.countries));
        // выделяем элемент
        spinner.setSelection(0);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента

                choosingCountry = spinner.getSelectedItem().toString();
                //Toast.makeText(getBaseContext(), "Position = " + position + "Chosen cuntry  = " + choosingCountry, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
    public void  goToSightsList(View v){
        choosingCountry = spinner.getSelectedItem().toString();
        //Toast.makeText(getBaseContext(), "Position = " + spinner.getSelectedItemPosition() + "Chosen cuntry  = " + spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ListSightsActivity.class);
        intent.putExtra("country",choosingCountry);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_country_choosing, menu);
        return true;
    }


}
