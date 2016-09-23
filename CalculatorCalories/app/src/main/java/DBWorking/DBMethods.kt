package DBWorking

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import android.widget.Toast

import com.example.main.R
import com.example.main.RegLogActivity
import com.example.main.RegistrationActivity

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date

import model.EatenProduct
import model.Information
import model.Product
import model.User

/**
 * Created by Alex Iachimov on 5/6/2016.
 */
class DBMethods {
    internal val LOG_TAG = "DBMethods"
    internal val LOG_TAG_PR = "LOG_TAG_PR"
    internal val LOG_TAG_PR2 = "LOG_TAG_PR2"

    //final String LOG_TAG_MY = "MyLogs";
    internal val TABLE_NAME_USER = "usertable"
    internal val TABLE_NAME_PRODUCT = "products"
    internal val TABLE_NAME_EATEN_PRODUCT = "eatenproducts"
    internal val TABLE_NAME_INFORMATION = "informationTable"


    fun registerAccaunt(userToReg: User, dbHelper: DBHelper) {
        // создаем объект для данных
        val sd = dbHelper.writableDatabase
        val cv = ContentValues()
        // подключаемся к БД
        Log.d(LOG_TAG, "--- Insert in usertable: ---")

        cv.put("weight", userToReg.weight)
        cv.put("height", userToReg.height)
        cv.put("pol", userToReg.sex)
        cv.put("name", userToReg.name)
        cv.put("age", userToReg.age)
        cv.put("life_style", userToReg.lifeStyle)
        cv.put("password", userToReg.password)
        cv.put("goal", userToReg.goal)


        val rowID = sd.insert("usertable", null, cv)
        Log.d(LOG_TAG, "row inserted, ID = " + rowID)

        sd.close()
        cv.clear()

    }

    fun getAllUsers(dbHelper: DBHelper): ArrayList<User> {
        val userArrayList = ArrayList<User>()
        val db = dbHelper.readableDatabase
        // 2. build query
        val cursor = db.query(TABLE_NAME_USER, // a. table
                null, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null) // h. limit

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (cursor.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            val idColIndex = cursor.getColumnIndex("id")
            val passwordColIndex = cursor.getColumnIndex("password")
            val ageColIndex = cursor.getColumnIndex("age")
            val heightColIndex = cursor.getColumnIndex("height")
            val weightColIndex = cursor.getColumnIndex("weight")
            val sexColIndex = cursor.getColumnIndex("pol")
            val nameColIndex = cursor.getColumnIndex("name")
            val lifeStyleColIndex = cursor.getColumnIndex("life_style")
            val goalStyleColIndex = cursor.getColumnIndex("goal")


            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(LOG_TAG,
                        "ID = " + cursor.getInt(idColIndex) +
                                ",name = " + cursor.getString(nameColIndex) +
                                ",password = " + cursor.getString(passwordColIndex) +
                                ",life_style = " + cursor.getString(lifeStyleColIndex))

                val user = User(cursor.getInt(idColIndex), cursor.getString(passwordColIndex), cursor.getInt(ageColIndex), cursor.getInt(heightColIndex), cursor.getInt(weightColIndex),
                        cursor.getString(sexColIndex), cursor.getString(nameColIndex), cursor.getString(lifeStyleColIndex), cursor.getString(goalStyleColIndex))
                userArrayList.add(user)
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (cursor.moveToNext())
        } else
            Log.d(LOG_TAG, "0 rows")
        cursor.close()

        return userArrayList
    }

    fun loginInAccaunt(userToReg: User, dbHelper: DBHelper) {
        // создаем объект для данных
        val sd = dbHelper.writableDatabase
        val cv = ContentValues()
        // подключаемся к БД
        Log.d(LOG_TAG, "--- Insert in usertable: ---")

        cv.put("weight", userToReg.weight)
        cv.put("height", userToReg.height)
        cv.put("pol", userToReg.sex)
        cv.put("name", userToReg.name)
        cv.put("age", userToReg.age)
        cv.put("life_style", userToReg.lifeStyle)
        cv.put("password", userToReg.password)
        cv.put("goal", userToReg.goal)


        val rowID = sd.insert("usertable", null, cv)
        Log.d(LOG_TAG, "row inserted, ID = " + rowID)

        sd.close()
        cv.clear()
        Log.d(LOG_TAG, "Table products was created")

    }


    fun getAllProducts(dbHelper: DBHelper): ArrayList<Product> {
        Log.d(LOG_TAG, "Enter in method getAllProducts")
        val productsArrayList = ArrayList<Product>()
        val db = dbHelper.readableDatabase
        Log.d(LOG_TAG, "Array List and SQLiteDAtabase var, has been created")
        // 2. build query
        val cursor = db.query(TABLE_NAME_PRODUCT, // a. table
                null, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null) // h. limit
        Log.d(LOG_TAG, "Cursor created")
        var count = 0
        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (cursor.moveToFirst()) {
            // определяем номера столбцов по имени в выборке
            val idColIndex = cursor.getColumnIndex("id")
            val nameColIndex = cursor.getColumnIndex("name")
            val proteinsColIndex = cursor.getColumnIndex("proteins")
            val fatsColIndex = cursor.getColumnIndex("fats")
            val carbohydrateColIndex = cursor.getColumnIndex("carbohydrate")
            val calloriesColIndex = cursor.getColumnIndex("callories")
            Log.d(LOG_TAG, "Счётчик = " + ++count)

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(LOG_TAG,
                        "ID = " + cursor.getInt(idColIndex) +
                                ", name = " + cursor.getString(nameColIndex) +
                                ", callories = " + cursor.getString(calloriesColIndex))

                val product = Product(cursor.getInt(idColIndex), cursor.getString(nameColIndex), cursor.getInt(calloriesColIndex), cursor.getString(proteinsColIndex), cursor.getString(fatsColIndex), cursor.getString(carbohydrateColIndex))
                productsArrayList.add(product)
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
                Log.d(LOG_TAG, "All carteges were added to array")
            } while (cursor.moveToNext())
        } else
            Log.d(LOG_TAG, "0 rows")
        cursor.close()
        Log.d(LOG_TAG, "Exit method getAllProducts")
        return productsArrayList
    }

    fun addNewProduct(productToAdd: Product, dbHelper: DBHelper) {
        // создаем объект для данных
        val sd = dbHelper.writableDatabase
        val cv = ContentValues()
        // подключаемся к БД
        Log.d(LOG_TAG, "--- Insert in producttable: ---")

        cv.put("name", productToAdd.name)
        cv.put("proteins", productToAdd.proteine)
        cv.put("fats", productToAdd.fats)
        cv.put("carbohydrate", productToAdd.carbohydrates)
        cv.put("callories", productToAdd.calorie)

        val rowID = sd.insert("products", null, cv)
        Log.d(LOG_TAG, "row inserted, ID = " + rowID)

        sd.close()
        cv.clear()
    }



    fun addNewEatenProduct(productsName: String, amount: Int, yearTime: String, monthTime: String, dayTime: String, hourTime: String, minTime: String, existProduct: ArrayList<Product>, context: Context, dbHelper: DBHelper,userId: String) {


        if (isInDatabase(productsName, existProduct)!!) {

            val sd = dbHelper.writableDatabase
            val cv = ContentValues()
            // подключаемся к БД
            Log.d(LOG_TAG, "--- Insert in eatenProducttable: ---")
            cv.put("name", productsName)
            cv.put("amount", amount)
            cv.put("yearTime", yearTime)
            cv.put("monthTime", monthTime)
            cv.put("dayTime", dayTime)
            cv.put("hourTime", hourTime)
            cv.put("minTime", minTime)
            cv.put("userId", userId)

            val rowID = sd.insert("eatenproducts", null, cv)
            Log.d(LOG_TAG, "row inserted, ID = " + rowID)
            Log.d(LOG_TAG_PR, "row inserted, userId = " + userId)
        } else {
            Toast.makeText(context, "This product can not be found in DataBase", Toast.LENGTH_SHORT).show()


        }


    }


    fun getAllEatenProducts(dbHelper: DBHelper, productArrayList: ArrayList<Product>, month: String, day: String, coefficient: Int,userId:String): ArrayList<EatenProduct> {
        Log.d(LOG_TAG, "Enter in method getAllEatenProducts")
        val productsEatenArrayList = ArrayList<EatenProduct>()
        val productsEatenArrayListResult = ArrayList<EatenProduct>()
        val db = dbHelper.readableDatabase
        Log.d(LOG_TAG, "Array List and SQLiteDAtabase var, has been created")

        // 2. build query
        val cursor = db.query(TABLE_NAME_EATEN_PRODUCT, // a. table
                null, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null) // h. limit
        Log.d(LOG_TAG, "Cursor created")
        var count = 0
        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (cursor.moveToFirst()) {
            // определяем номера столбцов по имени в выборке
            val idColIndex = cursor.getColumnIndex("id")
            val nameColIndex = cursor.getColumnIndex("name")
            val amountColIndex = cursor.getColumnIndex("amount")
            val yearTimeColIndex = cursor.getColumnIndex("yearTime")
            val monthTimeColIndex = cursor.getColumnIndex("monthTime")
            val dayTimeColIndex = cursor.getColumnIndex("dayTime")
            val hourTimeColIndex = cursor.getColumnIndex("hourTime")
            val minTimeColIndex = cursor.getColumnIndex("minTime")
            val userIdColIndex = cursor.getColumnIndex("userId")


            Log.d(LOG_TAG, "Счётчик = " + ++count)

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(LOG_TAG_PR,
                        "ID = " + cursor.getInt(idColIndex) +
                                ", name = " + cursor.getString(nameColIndex) +
                                ", amount = " + cursor.getInt(amountColIndex)+
                                ", year, = " + cursor.getInt(yearTimeColIndex)+
                                ", month = " + cursor.getInt(monthTimeColIndex)+
                                ", day = " + cursor.getInt(dayTimeColIndex)+
                                ", hour = " + cursor.getInt(hourTimeColIndex)+
                                ", min = " + cursor.getInt(minTimeColIndex)+
                                ", userId = " + cursor.getString(userIdColIndex)
                                );

                var p = Product()
                for (i in productArrayList.indices) {
                    if (productArrayList[i].name.equals(cursor.getString(nameColIndex), ignoreCase = true)) {
                        p = productArrayList[i]
                        break
                    }
                }

                val eatenProduct = EatenProduct(1, cursor.getString(nameColIndex), cursor.getInt(amountColIndex), cursor.getString(yearTimeColIndex),
                        cursor.getString(monthTimeColIndex),
                        cursor.getString(dayTimeColIndex),
                        cursor.getString(hourTimeColIndex),
                        cursor.getString(minTimeColIndex),
                        p,
                        cursor.getInt(amountColIndex) / coefficient,
                        cursor.getString(userIdColIndex))




                productsEatenArrayList.add(eatenProduct)





                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла

            } while (cursor.moveToNext())
        } else
            cursor.close()
        Log.d(LOG_TAG, "Exit method getAllProducts")




        for (i in productsEatenArrayList.indices) {
            if (month.equals(productsEatenArrayList[i].dayTime, ignoreCase = true) && day.equals(productsEatenArrayList[i].monthTime, ignoreCase = true)) {
                // Log.d(LOG_TAG_MY,"Month = " + month + " productsEatenArrayList.get(i).getDayTime() = " + productsEatenArrayList.get(i).getDayTime() + "Day = " + day + " productsEatenArrayList.get(i).getMonthTime() = " + productsEatenArrayList.get(i).getMonthTime());

                productsEatenArrayListResult.add(productsEatenArrayList[i])
            }
        }



        //Log.d(LOG_TAG_MY,"Current Day = " + day + " Current month = " + month);
        //Log.d(LOG_TAG_MY,"productsEatenArrayListResult = " + productsEatenArrayListResult.size());
        //return productsEatenArrayListResult;
        /*
        val productsEatenArrayListResultFinish = ArrayList<EatenProduct>()

        for (i in productsEatenArrayList.indices) {
            if (userId.equals(productsEatenArrayList[i].userId,ignoreCase = true)) {
                // Log.d(LOG_TAG_MY,"Month = " + month + " productsEatenArrayList.get(i).getDayTime() = " + productsEatenArrayList.get(i).getDayTime() + "Day = " + day + " productsEatenArrayList.get(i).getMonthTime() = " + productsEatenArrayList.get(i).getMonthTime());
                productsEatenArrayListResultFinish.add(productsEatenArrayListResult[i])
                Log.d(LOG_TAG_PR2,"Product ==========  " + productsEatenArrayListResultFinish.get(i).name)
            }
        }
        */
        val productsEatenArrayListResultFinish = ArrayList<EatenProduct>()
        for(i in productsEatenArrayListResult.indices){
            if (userId.equals(productsEatenArrayListResult[i].userId,ignoreCase = true)) {
                productsEatenArrayListResultFinish.add(productsEatenArrayListResult[i])
            }
        }


        return productsEatenArrayListResultFinish

    }

    fun isInDatabase(name: String, productArrayList: ArrayList<Product>): Boolean? {

        var b: Boolean? = null
        for (i in productArrayList.indices) {
            if (name.equals(productArrayList[i].name, ignoreCase = true)) {
                b = true
                break
            } else {
                b = false
            }

        }
        return b


    }

    fun updateUser(user: User, dbHelper: DBHelper) {


        val sd = dbHelper.writableDatabase
        val cv = ContentValues()
        // подключаемся к БД
        Log.d(LOG_TAG, "--- Insert in usertable: ---")

        cv.put("height", user.weight)
        cv.put("weight", user.height)
        cv.put("pol", user.sex)
        cv.put("name", user.name)
        cv.put("age", user.age)
        cv.put("life_style", user.lifeStyle)
        cv.put("password", user.password)
        cv.put("goal", user.goal)

        val updCount = sd.update("usertable", cv, "id = ?",
                arrayOf(user.id.toString()))


    }


}

