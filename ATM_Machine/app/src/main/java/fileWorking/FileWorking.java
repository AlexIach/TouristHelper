package fileWorking;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Banknotes;

/**
 * Created by Alex Iachimov on 6/24/2016.
 */
public class FileWorking {
    final String LOG_TAG = "myLogs";
    final String DIR_SD = "MyFiles";
    final String FILENAME_SD = "MyFileSD";


    //запись в Файл на SD
    public void writeFileSD(String s) {
        // проверяем доступность SD
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        // получаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        // создаем каталог
        sdPath.mkdirs();
        // формируем объект File, который содержит путь к файлу
        File sdFile = new File(sdPath, FILENAME_SD);
        try {
            // открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
            // пишем данные
            bw.write(s);
            // закрываем поток
            bw.close();
            Log.d(LOG_TAG, "Файл записан на SD: " + sdFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //чтение файла с SD
    public String  readFileSD() {
        String str = "";
        String result = "";
        // проверяем доступность SD
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
            return "Ошибка";
        }
        // получаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        // формируем объект File, который содержит путь к файлу
        File sdFile = new File(sdPath, FILENAME_SD);
        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new FileReader(sdFile));

            // читаем содержимое
            while ((str = br.readLine()) != null) {
                Log.d(LOG_TAG, str);
                result +=str;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }


    public ArrayList<Banknotes> parsignInfoFromFile(String string){
        ArrayList<Banknotes> banknotesArrayList = new ArrayList<Banknotes>();
        String[] arrayDenominationCount = string.split(",");
        String rating200 = arrayDenominationCount[0];
        String rating100 = arrayDenominationCount[1];
        String rating50 = arrayDenominationCount[2];
        String rating20 = arrayDenominationCount[3];
        String rating10 = arrayDenominationCount[4];
        String rating5 = arrayDenominationCount[5];
        String rating1 = arrayDenominationCount[6];
        Log.d(LOG_TAG,"Не полностью пропарсенные данные = " + rating200+rating100+rating50+rating20+rating10+rating5+rating1);

        banknotesArrayList.add(parsignInfoFromFile2(rating200));
        banknotesArrayList.add(parsignInfoFromFile2(rating100));
        banknotesArrayList.add(parsignInfoFromFile2(rating50));
        banknotesArrayList.add(parsignInfoFromFile2(rating20));
        banknotesArrayList.add(parsignInfoFromFile2(rating10));
        banknotesArrayList.add(parsignInfoFromFile2(rating5));
        banknotesArrayList.add(parsignInfoFromFile2(rating1));

        return  banknotesArrayList;
    }
    public  Banknotes parsignInfoFromFile2(String string){
        Banknotes b = null;
        String[] array = string.split("-");
        String denomination = array[0];
        String count = array[1];
        b = new Banknotes(Integer.parseInt(denomination),Integer.parseInt(count));
        Log.d(LOG_TAG,"Denotination = " + b.getDenomination() + " Count =   !"+ b.getCount());

        return b;
    }



    public String getFILENAME_SD() {
        return FILENAME_SD;
    }

    public String getDIR_SD() {
        return DIR_SD;
    }

    public String getLOG_TAG() {
        return LOG_TAG;
    }



}
