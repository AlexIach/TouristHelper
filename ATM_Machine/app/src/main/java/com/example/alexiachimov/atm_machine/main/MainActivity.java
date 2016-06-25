package com.example.alexiachimov.atm_machine.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.util.ArrayList;

import fileWorking.FileWorking;
import model.Banknotes;

public class MainActivity extends AppCompatActivity {
    int allMoney = 0;
    int a[] = {200,100, 50, 20, 10, 5, 1};
    final String LOG_TAG_MAIN = "myLogsMain";

    final String currentMoneyInATM = "200-3,100-2,50-4,20-3,10-49,5-23,1-10"; //1675
    String infoFromFile;
    ArrayList<Banknotes> arr= new ArrayList<Banknotes>();

    FileWorking fileWorking;
    EditText editTextMoney;
    Button buttonGetMoney;
    TextView textViewRating1,textViewRating5,textViewRating10,textViewRating20,textViewRating50,textViewRating100,textViewRating200,textViewMoneyInATM,textViewResult;




    public void onRefresh(View view){

        fileWorking.writeFileSD(currentMoneyInATM);

        infoFromFile = fileWorking.readFileSD();
        arr.clear();
        arr = fileWorking.parsignInfoFromFile(infoFromFile);
        textViewRating200.setText("Кол-во купюр наминалом 200 : " + arr.get(0).getCount());
        textViewRating100.setText("Кол-во купюр наминалом 100: " + arr.get(1).getCount());
        textViewRating50.setText("Кол-во купюр наминалом 50: " + arr.get(2).getCount());
        textViewRating20.setText("Кол-во купюр наминалом 20: " + arr.get(3).getCount());
        textViewRating10.setText("Кол-во купюр наминалом 10: " + arr.get(4).getCount());
        textViewRating5.setText("Кол-во купюр наминалом 5: " + arr.get(5).getCount());
        textViewRating1.setText("Кол-во купюр наминалом 1: " + arr.get(6).getCount());

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fileWorking = new FileWorking();

        editTextMoney = (EditText) findViewById(R.id.editTextSumOfMoney);
        buttonGetMoney = (Button) findViewById(R.id.buttonGetMoney);
        textViewRating1 = (TextView) findViewById(R.id.textViewRating1);
        textViewRating5 = (TextView) findViewById(R.id.textViewRating5);
        textViewRating10 = (TextView) findViewById(R.id.textViewRating10);
        textViewRating20 = (TextView) findViewById(R.id.textViewRating20);
        textViewRating50 = (TextView) findViewById(R.id.textViewRating50);
        textViewRating100 = (TextView) findViewById(R.id.textViewRating100);
        textViewRating200 = (TextView) findViewById(R.id.textViewRating200);
        textViewMoneyInATM = (TextView) findViewById(R.id.textViewMoneInATM);
        textViewResult = (TextView) findViewById(R.id.textViewResult);


        File file = new File("/storage/emulated/0/MyFiles/");

        if (file.exists() && file.isFile() && fileWorking.readFileSD().equalsIgnoreCase(currentMoneyInATM)) {

        } else {
            fileWorking.writeFileSD(currentMoneyInATM);

        }

        infoFromFile = fileWorking.readFileSD();
        Log.d(LOG_TAG_MAIN, "Строка из  файла  = " + infoFromFile);


        arr.clear();
        arr = fileWorking.parsignInfoFromFile(infoFromFile);

        for (int i = 0; i < arr.size(); i++) {
            allMoney += arr.get(i).getDenomination() * arr.get(i).getCount();
        }
        Log.d(LOG_TAG_MAIN, "Всего денег = " + allMoney);
        textViewMoneyInATM.setText("Денег в банкомате = " + allMoney);


        textViewRating200.setText("Кол-во купюр наминалом 200 : " + arr.get(0).getCount());
        textViewRating100.setText("Кол-во купюр наминалом 100: " + arr.get(1).getCount());
        textViewRating50.setText("Кол-во купюр наминалом 50: " + arr.get(2).getCount());
        textViewRating20.setText("Кол-во купюр наминалом 20: " + arr.get(3).getCount());
        textViewRating10.setText("Кол-во купюр наминалом 10: " + arr.get(4).getCount());
        textViewRating5.setText("Кол-во купюр наминалом 5: " + arr.get(5).getCount());
        textViewRating1.setText("Кол-во купюр наминалом 1: " + arr.get(6).getCount());


    }



    public  void getMoneyFromATM(View view){
        String enteredMoney;
        enteredMoney = editTextMoney.getText().toString();
        if(enteredMoney.length()>0){

            Log.d(LOG_TAG_MAIN,"Денег до операции  = " + allMoney);
            String str = algorithmToGetMoney(Integer.parseInt(enteredMoney),arr);
            Log.d(LOG_TAG_MAIN,"Денег после операции  = " + allMoney);
            Log.d(LOG_TAG_MAIN,"Результат = " + str);
            Log.d(LOG_TAG_MAIN,"----------------------------------------------------------------------------------------------------------------------------------");
            textViewResult.setText(str);



        }else {
            Toast.makeText(getApplicationContext(),"Поле не заполнено",Toast.LENGTH_SHORT).show();
        }

    }


    public String  algorithmToGetMoney(int enteredMoney,ArrayList<Banknotes> array){
        String result ="";
        int n200=0;
        int n100=0;
        int n50=0;
        int n20=0;
        int n10=0;
        int n5=0;
        int n1=0;

        int t=enteredMoney;
        int tempMoney =0;

        while(t>=200 && enteredMoney < allMoney && tempMoney < enteredMoney && array.get(0).getCount() > 0)
        {

            Log.d(LOG_TAG_MAIN,"Кол-во 200 было: " + array.get(0).getCount());
            t-=200;
            n200++;
            tempMoney+=200;
            array.get(0).setCount(array.get(0).getCount() - 1);
            textViewRating200.setText("Кол-во купюр наминалом 200  : " +  array.get(0).getCount());
            Log.d(LOG_TAG_MAIN,"Кол-во 200 стало: " + array.get(0).getCount());

        };
        while(t>=100&& enteredMoney < allMoney && tempMoney < enteredMoney && array.get(1).getCount() > 0)
        {

            Log.d(LOG_TAG_MAIN,"Кол-во 100 было: " + array.get(1).getCount());
            t-=100;
            n100++;
            tempMoney+=100;
            array.get(1).setCount(array.get(1).getCount() - 1);
            textViewRating100.setText("Кол-во купюр наминалом 100 : " +array.get(1).getCount());
            Log.d(LOG_TAG_MAIN,"Кол-во 100 стало: " + array.get(1).getCount());
        };
        while(t>=50 && enteredMoney < allMoney && tempMoney < enteredMoney && array.get(2).getCount() > 0)
        {

            Log.d(LOG_TAG_MAIN,"Кол-во 50 было: " + array.get(2).getCount());
            t-=50;
            n50++;
            tempMoney+=50;
            array.get(2).setCount(array.get(2).getCount() - 1);
            textViewRating50.setText("Кол-во купюр наминалом 50 : " + array.get(2).getCount());
            Log.d(LOG_TAG_MAIN,"Кол-во 50 стало: " + array.get(2).getCount());
        };
        while(t>=20&& enteredMoney < allMoney && tempMoney < enteredMoney && array.get(3).getCount() > 0)
        {

            Log.d(LOG_TAG_MAIN,"Кол-во 20 было: " + array.get(3).getCount());
            t-=20;
            n20++;
            tempMoney+=20;
            array.get(3).setCount(array.get(3).getCount() - 1);
            textViewRating20.setText("Кол-во купюр наминалом 20 : " + array.get(3).getCount());
            Log.d(LOG_TAG_MAIN,"Кол-во 20 стало: " + array.get(3).getCount());
        };
        while(t>=10&& enteredMoney < allMoney && tempMoney < enteredMoney && array.get(4).getCount() > 0)
        {

            Log.d(LOG_TAG_MAIN,"Кол-во 10 было: " + array.get(4).getCount());
            t-=10;
            n10++;
            tempMoney+=10;
            array.get(4).setCount(array.get(4).getCount() - 1);
            textViewRating10.setText("Кол-во купюр наминалом 10 : " + array.get(4).getCount());
            Log.d(LOG_TAG_MAIN,"Кол-во 10 стало: " + array.get(4).getCount());
        };

        while(t>=5&& enteredMoney < allMoney && tempMoney < enteredMoney && array.get(5).getCount() > 0)
        {

            Log.d(LOG_TAG_MAIN,"Кол-во 5 было: " + array.get(5).getCount());
            t-=5;
            n5++;
            tempMoney+=5;
            array.get(5).setCount(array.get(5).getCount() - 1);
            textViewRating5.setText("Кол-во купюр наминалом 5 : " + array.get(5).getCount());
            Log.d(LOG_TAG_MAIN,"Кол-во 5 стало: " + array.get(5).getCount());
        };
        while(t>=1&& enteredMoney < allMoney && tempMoney < enteredMoney && array.get(6).getCount() > 0)
        {

            Log.d(LOG_TAG_MAIN,"Кол-во 1 было: " + array.get(6).getCount());
            t-=1;
            n1++;
            tempMoney+=1;
            array.get(6).setCount(array.get(6).getCount() - 1);
            textViewRating1.setText("Кол-во купюр наминалом 1 : " +array.get(6).getCount());
            Log.d(LOG_TAG_MAIN,"Кол-во 1 стало: " + array.get(6).getCount());

        };

        if(tempMoney<=enteredMoney && enteredMoney <= allMoney) {
            Log.d(LOG_TAG_MAIN,"TempMoney = " + tempMoney + " enteredMOney = " + enteredMoney);
            result = "Кол-во 200 = " + n200 + "  Кол-во 100 = " + n100 + "  Кол-во 50 = " + n50 + "  Кол-во 20 = " + n20 + "  Кол-во 10 = " + n10 + "  Кол-во 5  = " + n5 + "  Кол-во 1 = " + n1;
            allMoney = allMoney - enteredMoney;
            textViewMoneyInATM.setText("Денег в банкомате = " + allMoney);

            fileWorking.writeFileSD("200-"+array.get(0).getCount()+","
                                   +"100-"+array.get(1).getCount()+","
                                   +"50-"+array.get(2).getCount()+","
                                   +"20-"+array.get(3).getCount()+","
                                   +"10-"+array.get(4).getCount()+","
                                   +"5-"+array.get(5).getCount()+","
                                   +"1-"+array.get(6).getCount());
            editTextMoney.setText("");



        }else{
            Log.d(LOG_TAG_MAIN,"TempMoney = " + tempMoney + " enteredMOney = " + enteredMoney);
            Log.d(LOG_TAG_MAIN,"Ошибка");
            Toast.makeText(getApplicationContext(),"Ошибка",Toast.LENGTH_LONG).show();
        }

        return result;
    }




}
