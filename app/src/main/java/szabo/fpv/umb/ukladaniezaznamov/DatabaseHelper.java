package szabo.fpv.umb.ukladaniezaznamov;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Contry_DB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "countrys";
    private static final String COL1 = "id";
    private static final String COL2 = "country";
    private String createTblCountires =
            "CREATE TABLE " + "country" + " (" +
                    "id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "countryName" + " TEXT)";


    public DatabaseHelper(Context context) {

        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTblCountires);
//        db.execSQL("CREATE TABLE " + TABLE_NAME
//                + "(" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + COL2+ " TEXT );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertDataCountry(String dataName){
        SQLiteDatabase db = this.getWritableDatabase();
        //inserted data is encapsulated in a CV object
        ContentValues values = new ContentValues();
        values.put("countryName",dataName);
        //method Insert put date to the DB (name of table,null - does not alllow an empty line to be inserted,obj CV)
        long id =db.insert("country",null,values);
        db.close();
    }
    public ArrayList<String> GetCountries() {
        ArrayList<String> arrayList = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + "country";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                arrayList.add(cursor.getString(cursor.getColumnIndex("countryName")));
            } while (cursor.moveToNext());
        }
        return arrayList;
    }
}
