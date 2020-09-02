package trial.example.med51;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Constraints;

import java.util.ArrayList;

public class Helper2 extends SQLiteOpenHelper {

    public Helper2(@Nullable Context context) {
        super(context, Constans2.DB_NAME2, null, Constans2.DB_VERSION2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table
        db.execSQL(Constans2.CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Constans2.TABLE_NAME2);
        onCreate(db);
    }

    // insert information
    public long insertInfo(String image, String name, String address, String phone, String addTimeStamp, String updateTimeStamp) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constans2.C_NAME, name);
        values.put(Constans2.C_ADDRESS, address);
        values.put(Constans2.C_PHONE, phone);
        values.put(Constans2.C_IMAGE, image);
        values.put(Constans2.C_ADD_TIMESTAMP, addTimeStamp);
        values.put(Constans2.C_UPDATE_TIMESTAMP, updateTimeStamp);
        long id = db.insert(Constans2.TABLE_NAME2, null, values);
        db.close();
        return id;
    }


    public void updateInfo(String id, String image, String name, String address, String phone, String addTimeStamp, String updateTimeStamp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constans2.C_NAME, name);
        values.put(Constans2.C_ADDRESS, address);
        values.put(Constans2.C_PHONE, phone);
        values.put(Constans2.C_IMAGE, image);
        values.put(Constans2.C_ADD_TIMESTAMP, addTimeStamp);
        values.put(Constans2.C_UPDATE_TIMESTAMP, updateTimeStamp);

        db.update(Constans2.TABLE_NAME2, values, Constans2.C_ID +" = ?", new String[]{id});
        db.close();
    }

    public void deleteInfo(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Constans2.TABLE_NAME2, Constans2.C_ID + " = ? ", new  String[]{id});
        db.close();
    }

    public ArrayList<Model> getAllData(String orderBy) {

        ArrayList<Model> arrayList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Constans2.TABLE_NAME2 + " ORDER BY " + orderBy;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToNext()) {

            do {
                Model model = new Model(
                        ""+cursor.getInt(cursor.getColumnIndex( Constans2.C_ID)),
                        ""+cursor.getString(cursor.getColumnIndex( Constans2.C_IMAGE)),
                        ""+cursor.getString(cursor.getColumnIndex( Constans2.C_NAME)),
                        ""+cursor.getString(cursor.getColumnIndex( Constans2.C_ADDRESS)),
                        ""+cursor.getString(cursor.getColumnIndex( Constans2.C_PHONE)),
                        ""+cursor.getString(cursor.getColumnIndex( Constans2.C_ADD_TIMESTAMP)),
                        ""+cursor.getString(cursor.getColumnIndex( Constans2.C_UPDATE_TIMESTAMP))
                );

                arrayList.add(model);
            }while (cursor.moveToNext());
        }

        db.close();
        return arrayList;
    }
}
