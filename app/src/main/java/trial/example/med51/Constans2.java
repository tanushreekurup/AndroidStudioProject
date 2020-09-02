package trial.example.med51;

public class Constans2 {

    // db name
    public static final String DB_NAME2 = "Kutch.db";
    // db version
    public static final int DB_VERSION2 = 1;
    // db table name
    public static final String TABLE_NAME2 = "tbl_kutch";

    // columns of table
    public static final String C_ID = "ID";
    public static final String C_NAME = "NAME";
    public static final String C_ADDRESS = "ADDRESS";
    public static final String C_PHONE = "PHONE";
    public static final String C_IMAGE = "IMAGE";
    public static final String C_ADD_TIMESTAMP = "TIMESTAMP";
    public static final String C_UPDATE_TIMESTAMP = "UPDATED_TIMESTAMP";
    // create table query
    public static final String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME2 + " ("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + C_NAME + " TEXT,"
            + C_ADDRESS + " TEXT,"
            + C_PHONE + " TEXT,"
            + C_IMAGE + " TEXT,"
            + C_ADD_TIMESTAMP + " TEXT,"
            + C_UPDATE_TIMESTAMP + " TEXT"
            + ");";
}
