package Task3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS +
                "("
                + KEY_ID + " INTEGER PRIMARY KEY UNIQUE ,"
                + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" +
                ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void addContact (Contact contact)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String nullColumnHack =null;
        ContentValues values=new ContentValues();
        if (contact.getId()!=-1)
        {
            values.put(KEY_ID, contact.getId());
            values.put(KEY_NAME,contact.getName());
            values.put(KEY_PH_NO,contact.getPhoneNumber());

        }
        db.insert(TABLE_CONTACTS,nullColumnHack,values);
        db.close();
    }

    public Contact getContact(int id)
    {
        Contact contact=null;
        SQLiteDatabase db=this.getReadableDatabase();
        String[] fields ={KEY_ID,KEY_NAME,KEY_PH_NO};
        String criterials=KEY_ID + "=?";
        String [] parameters= {String.valueOf(id)};
        try{
            Cursor cursor =db.query(TABLE_CONTACTS,fields,criterials,parameters,null,null,null);
            if (cursor!=null) {
                cursor.moveToFirst();
            }else return null;
            contact=new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));

        }
        catch (CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException)
        {
            cursorIndexOutOfBoundsException.getCause();
        }
        return contact;

    }

    public List<Contact> getAllContacts(){
        List<Contact> contacts=new ArrayList<Contact>();
        String [] criterial=null;
        String selectQuery="SELECT * FROM " +TABLE_CONTACTS;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,criterial);
        if (cursor.moveToFirst())
        {
            do{
                Contact contact=new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));

                contacts.add(contact);
            }while (cursor.moveToNext());
        }
        return contacts;
    }

    public int updateContact(Contact contact)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(KEY_ID,contact.getId());
        values.put(KEY_NAME,contact.getName());
        values.put(KEY_PH_NO,contact.getPhoneNumber());
        String whereClause=KEY_ID +"=?";
        String[] whereArgs={String.valueOf(contact.getId())};
        return db.update(TABLE_CONTACTS,values,whereClause,whereArgs);
    }
    public void deleteContact(Contact contact){
        SQLiteDatabase db =this.getWritableDatabase();
        String whereClause="id=?";
        String [] whereArgs ={String.valueOf(contact.getId())};
        db.delete(TABLE_CONTACTS,whereClause,whereArgs);
    }
}
