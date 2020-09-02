package trial.example.med51;

public class Constants5 {
    // db name
    public static final String DB_NAME5 = "Bhavnagar.db";
    // db version
    public static final int DB_VERSION5 = 1;
    // db table name
    public static final String TABLE_NAME5 = "tbl_bhavnagar";

    // columns of table
    public static final String C_ID = "ID";
    public static final String C_NAME = "NAME";
    public static final String C_ADDRESS = "ADDRESS";
    public static final String C_PHONE = "PHONE";
    public static final String C_IMAGE = "IMAGE";
    public static final String C_ADD_TIMESTAMP = "TIMESTAMP";
    public static final String C_UPDATE_TIMESTAMP = "UPDATED_TIMESTAMP";
    // create table query
    public static final String CREATE_TABLE5 = "CREATE TABLE " + TABLE_NAME5 + " ("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + C_NAME + " TEXT,"
            + C_ADDRESS + " TEXT,"
            + C_PHONE + " TEXT,"
            + C_IMAGE + " TEXT,"
            + C_ADD_TIMESTAMP + " TEXT,"
            + C_UPDATE_TIMESTAMP + " TEXT"
            + ");";
}
