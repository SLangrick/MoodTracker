package com.example.moodtracker
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

val DATABASENAME = "MY DATABASE"
val TABLENAME = "Users"
val COL_NAME = "name"
val COL_AGE = "age"
val COL_ID = "id"
class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
    1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLENAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " VARCHAR(256)," + COL_AGE + " INTEGER)"
        db?.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db);
    }
    fun insertData(model: Model) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, model.Feel)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }
    fun readData(): MutableList<Model> {
        val list: MutableList<Model> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val model = Model(Calendar.getInstance().time, 2)
                model.Feel = result.getInt(result.getColumnIndex(COL_NAME))
                list.add(model)
            }
            while (result.moveToNext())
        }
        return list
    }

    fun deleteData(id : Int){
        val database = this.writableDatabase
        val query = "Select * from $TABLENAME"
        database.delete(query,  "id="+id,null)
    }

}