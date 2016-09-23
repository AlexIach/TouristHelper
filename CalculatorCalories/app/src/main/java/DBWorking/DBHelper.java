package DBWorking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Alex Iachimov on 5/6/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    final String LOG_TAG = "dbHelperLogs";
    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table usertable ("
                + "id integer primary key autoincrement,"
                + "height integer,"
                + "weight integer,"
                + "age integer,"
                + "name text,"
                + "password text,"
                + "pol text,"
                + "life_style text,"
                + "goal text" + ");");

        Log.d(LOG_TAG, "Creating table PRODUCTS");

        db.execSQL("create table products ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "proteins text,"
                + "fats text,"
                + "carbohydrate text,"
                + "callories integer" + ");");

        Log.d(LOG_TAG, "Table products has been created");

        Log.d(LOG_TAG, "Creating table eatenproducts");

        db.execSQL("create table eatenproducts ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "amount integer,"
                + "yearTime text,"
                + "monthTime text,"
                + "dayTime text,"
                + "hourTime text,"
                + "userId text,"
                + "minTime text" + ");");


        db.execSQL("create table eatenproducts1 ("
                + "id integer primary key autoincrement,"
                + "name1 text,"
                + "minTime1 text" + ");");




        /*

         db.execSQL("INSERT INTO eatenproducts (name,amount,yearTime,monthTime,dayTime,hourTime,minTime)\n" +
                        "VALUES ('Peas',100,'116','4','1','11','44');");
                        */

        /*
        db.execSQL("INSERT INTO products (name,proteins,fats,carbohydrate,callories)\n" +
                "VALUES ('Peas','20.3','1.2','56.3',303);\n" +
                "INSERT INTO products (name,proteins,fats,carbohydrate,callories)\n" +
                "VALUES ('Rice','7.3','2.6','63.1',284);\n" +
                "INSERT INTO products (name,proteins,fats,carbohydrate,callories)\n" +
                "VALUES ('Wheat bread','8.1','1.2','42.0',203);\n" +
                "INSERT INTO products (name,proteins,fats,carbohydrate,callories)\n" +
                "VALUES ('Potatoes','2.0','0.1','19.7',83);\n" +
                "INSERT INTO products (name,proteins,fats,carbohydrate,callories)\n" +
                "VALUES ('Ham','10.0','35.0','0.0',355);\n" +
                "INSERT INTO products (name,proteins,fats,carbohydrate,callories)\n" +
                "VALUES ('Chicken eggs','12.7','11.5','0.7',157);\n" +
                "INSERT INTO products (name,proteins,fats,carbohydrate,callories)\n" +
                "VALUES ('Milk 1.5%','2.9','1.5','4.7',44);\n" +
                "INSERT INTO products (name,proteins,fats,carbohydrate,callories)\n" +
                "VALUES ('Source cream 10%','3.0','10.0','2.9',116);\n" +
                "INSERT INTO products (name,proteins,fats,carbohydrate,callories)\n" +
                "VALUES ('Curd','16.7','9.0','2.0',159);\n");


        Log.d(LOG_TAG, "All carteges have been added");
        */

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

}
}
