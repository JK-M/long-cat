package com.example.justina.learningapp.data.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "favourites.db";
    public static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + DBContract.TableFav.TABLE_NAME+ " (" +
                    DBContract.TableFav._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    DBContract.TableFav.FIRST_COL_NAME + " TEXT," +
                    DBContract.TableFav.SECOND_COL_NAME + " TEXT," +
                    DBContract.TableFav.THIRD_COL_NAME + " TEXT," +
                    DBContract.TableFav.FOURTH_COL_NAME + " TEXT," +
                    DBContract.TableFav.FIFTH_COL_NAME + " TEXT" + " );";
    private static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + DBContract.TableFav.TABLE_NAME;
    private static final String SQL_QUERY_TABLE =
            "SELECT * FROM " + DBContract.TableFav.TABLE_NAME +
                    " ORDER BY " + DBContract.TableFav._ID + " DESC LIMIT 1;";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }

    // Save (insert) information about favourites
    public boolean insertData(String firstFav, String secondFav, String thirdFav,
                              String fourthFav, String fifthFav){

        // Get data repository in write mode
        SQLiteDatabase db_write = this.getWritableDatabase();

        // Create a new map
        ContentValues values = new ContentValues();
        values.put(DBContract.TableFav.FIRST_COL_NAME, firstFav);
        values.put(DBContract.TableFav.SECOND_COL_NAME, secondFav);
        values.put(DBContract.TableFav.THIRD_COL_NAME, thirdFav);
        values.put(DBContract.TableFav.FOURTH_COL_NAME, fourthFav);
        values.put(DBContract.TableFav.FIFTH_COL_NAME, fifthFav);

        // Insert new row and check if successful
        long rowId = db_write.insert(DBContract.TableFav.TABLE_NAME, DBContract.TableFav._ID, values);

        if (rowId == -1){
            // Row was not inserted
            return false;
        }
        else{
            // Row was inserted successfully
            return true;
        }
    }

    // Update information about favourties
    public boolean updateData(String ID, String firstFav, String secondFav,
                              String thirdFav,String fourthFav, String fifthFav){

        // Get data repository in read mode
        SQLiteDatabase db_read = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.TableFav.FIRST_COL_NAME, firstFav);
        values.put(DBContract.TableFav.SECOND_COL_NAME, secondFav);
        values.put(DBContract.TableFav.THIRD_COL_NAME, thirdFav);
        values.put(DBContract.TableFav.FOURTH_COL_NAME, fourthFav);
        values.put(DBContract.TableFav.FIFTH_COL_NAME, fifthFav);

        // Update new row and check if successful
        db_read.update(DBContract.TableFav.TABLE_NAME, values, "_ID = " + ID, null);

        return true;
    }

    // Retrieve information about favourites
    public Cursor retrieveData(){

        SQLiteDatabase db_read = this.getReadableDatabase();

        Cursor cGetLastRecord = db_read.rawQuery(SQL_QUERY_TABLE, null);
        return cGetLastRecord;
    }
}
