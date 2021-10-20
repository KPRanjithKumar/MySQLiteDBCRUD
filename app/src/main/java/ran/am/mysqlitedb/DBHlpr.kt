package ran.am.mysqlitedb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.location.Location
import java.util.jar.Attributes

class DBHlpr(context: Context) : SQLiteOpenHelper(context, "details.db", null, 1) {

    var sqLiteDatabase: SQLiteDatabase= writableDatabase


    override fun onCreate(db: SQLiteDatabase?) {

        if (db != null) {
            db.execSQL("create table students (Name text , Location text)")
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun savedat(s1: String, s2: String): Long {
        sqLiteDatabase=writableDatabase

        val cv = ContentValues()
        cv.put("Name", s1)
        cv.put("Location", s2)
        return sqLiteDatabase.insert( "students", null, cv)

    }

    fun retrive(s1: String): String {
        //  sqLiteDatabase=writableDatabase

        var c: Cursor = sqLiteDatabase.query(
            "students", null, "Name=?", arrayOf(s1), null, null, null
        )

        if (c.count < 1) {
            return "name not exists"
        }

        c.moveToFirst()

        var loc = c.getString(c.getColumnIndex("Location"))

        return loc
    }

    fun updateloc(s1: String, s2: String): Int {
        sqLiteDatabase=writableDatabase
        val cv = ContentValues()
        cv.put("Location", s2)
        var j = sqLiteDatabase.update("students", cv, "Name = ?", arrayOf(s1))
        return j
    }

    fun delname(s1: String) {
        sqLiteDatabase=writableDatabase

        sqLiteDatabase.delete("students", "Name =?",  arrayOf(s1))
    }
 
}