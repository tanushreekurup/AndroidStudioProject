package trial.example.med51;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Constraints;

import java.util.ArrayList;

public class Helper5 extends SQLiteOpenHelper {

    public Helper5(@Nullable Context context) {
        super(context, Constants5.DB_NAME5, null, Constants5.DB_VERSION5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table
        db.execSQL(Constants5.CREATE_TABLE5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Constants5.TABLE_NAME5);
        onCreate(db);
    }

    // insert information
    public long insertInfo(String image, String name, String address, String phone, String addTimeStamp, String updateTimeStamp) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants5.C_NAME, name);
        values.put(Constants5.C_ADDRESS, address);
        values.put(Constants5.C_PHONE, phone);
        values.put(Constants5.C_IMAGE, image);
        values.put(Constants5.C_ADD_TIMESTAMP, addTimeStamp);
        values.put(Constants5.C_UPDATE_TIMESTAMP, updateTimeStamp);
        long id = db.insert(Constants5.TABLE_NAME5, null, values);
        db.close();
        return id;
    }


    public void updateInfo(String id, String image, String name, String address, String phone, String addTimeStamp, String updateTimeStamp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants5.C_NAME, name);
        values.put(Constants5.C_ADDRESS, address);
        values.put(Constants5.C_PHONE, phone);
        values.put(Constants5.C_IMAGE, image);
        values.put(Constants5.C_ADD_TIMESTAMP, addTimeStamp);
        values.put(Constants5.C_UPDATE_TIMESTAMP, updateTimeStamp);

        db.update(Constants5.TABLE_NAME5, values, Constants5.C_ID +" = ?", new String[]{id});
        db.close();
    }

    public void deleteInfo(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Constants5.TABLE_NAME5, Constants5.C_ID + " = ? ", new  String[]{id});
        db.close();
    }

    public ArrayList<Model> getAllData(String orderBy) {

        ArrayList<Model> arrayList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Constants5.TABLE_NAME5 + " ORDER BY " + orderBy;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToNext()) {

            do {
                Model model = new Model(
                        ""+cursor.getInt(cursor.getColumnIndex( Constants5.C_ID)),
                        ""+cursor.getString(cursor.getColumnIndex( Constants5.C_IMAGE)),
                        ""+cursor.getString(cursor.getColumnIndex( Constants5.C_NAME)),
                        ""+cursor.getString(cursor.getColumnIndex( Constants5.C_ADDRESS)),
                        ""+cursor.getString(cursor.getColumnIndex( Constants5.C_PHONE)),
                        ""+cursor.getString(cursor.getColumnIndex( Constants5.C_ADD_TIMESTAMP)),
                        ""+cursor.getString(cursor.getColumnIndex( Constants5.C_UPDATE_TIMESTAMP))
                );

                arrayList.add(model);
            }while (cursor.moveToNext());
        }

        db.close();
        return arrayList;
    }
}
