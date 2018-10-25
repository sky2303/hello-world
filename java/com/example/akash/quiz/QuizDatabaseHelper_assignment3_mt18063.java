package com.example.akash.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.CopyOnWriteArrayList;

public class QuizDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="questions.db";
    private static final String TABLENAME="questions_table";
    private static final String COLUMN1="ID";
    private static final String COLUMN2="QUESTION";
    private static final String COLUMN3="ANSWER";

    public QuizDatabaseHelper(@Nullable Context context) {
        super(context,DB_NAME,null,2);
        //SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+TABLENAME+" (ID TEXT,QUESTION TEXT,ANSWER TEXT)");
        Log.d("data_creation","databasecrearted");
//        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLENAME,null);
//        if(cursor.getCount()==0) {
//            insert("1", "You cannot format text in an e-mail message.", "NA");
//            insert("2", "You must include a subject in any mail message you compose", "NA");
//            insert("3", "If you want to respond to the sender of a message, click the Respond button.", "NA");
//            insert("4", "You type the body of a reply the same way you would type the body of a new message. ", "NA");
//            insert("5", " When you reply to a message, you need to enter the text in the Subject: field.", "NA");
//            insert("6", "You can only print one copy of a selected message.", "NA");
//            insert("7", "You cannot preview a message before you print it.", "NA");
//            insert("8", "There is only one way to print a message.", "NA");
//            insert("9", "When you print a message, it is automatically deleted from your Inbox.", "NA");
//            insert("10", "You need to delete a contact and create a new one to change contact information.", "NA");
//            insert("11", "You must complete all fields in the Contact form before you can save the contact.", "NA");
//            insert("12", "You cannot edit Contact forms.", "NA");
//            insert("13", "You should always open and attachment before saving it.", "NA");
//            insert("14", " All attachment are safe.", "NA");
//            insert("15", "It is impossible to send a worm or virus over the Internet using in attachment.", "NA");
//            insert("16", "You can only send one attachment per e-mail message", "NA");
//            insert("17", "There is only one way to delete a message.", "NA");
//            insert("18", "The Delete key is for deleting text, it will not delete messages from your Inbox. ", "NA");
//            insert("19", "Pressing the Delete key and clicking the Delete button produce the same result.", "NA");
//            insert("20", "In Outlook, you must store all of your messages in the Inbox.", "NA");
//            insert("21", "You can only store messages in a new folder if they are received after you create the folder.", "NA");
//            insert("22", "New folders must all be at the same level.", "NA");
//            insert("23", "There is only one way to create a new folder.", "NA");
//            insert("24", "Your password should be something others will be able to figured out, such as your birthday or wedding anniversary.", "NA");
//            insert("25", "You cannot send a file from a Web-based e-mail account.", "NA");
//            insert("26", "Your e-mail address must be unique. ", "NA");
//            insert("27", "You can sign up for Web-based e-mail without accepting the Web site's terms and conditions.", "NA");
//            insert("28", "Web-based e-mail accounts do not required passwords.", "NA");
//            insert("29", "You can delete e-mails from a Web-based e-mail account.", "NA");
//            insert("30", "You can store Web-based e-mail messages in online folders.", "NA");
//         Log.d("insertion","data is inserted");


    }

    @Override

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(sqLiteDatabase);

    }

    public void insertdata(String id,String question,String answer)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN1,id);
        contentValues.put(COLUMN2,question);
        contentValues.put(COLUMN3,answer);
        sqLiteDatabase.insert(TABLENAME,null,contentValues);

        //sqLiteDatabase.execSQL("INSERT INTO "+TABLENAME+" VALUES"+"('"+id+"','"+question+"','"+answer+"')");




   }

   public Cursor getCount()
   {
       SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
       Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLENAME,null);
       return cursor;

   }

    public Cursor readquestion(String id)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from " +TABLENAME+" where "+COLUMN1+" LIKE "+"'"+id+"'",null);
        //Toast.makeText(this,"in",Toast.LENGTH_LONG).show();
        return cursor;
    }

    public void updateAnswer(String id,String question,String answer)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN1,id);
        contentValues.put(COLUMN2,question);
        contentValues.put(COLUMN3,answer);
        sqLiteDatabase.update(TABLENAME,contentValues,"ID = "+id,null);

        //return true;

    }
//    public void convertCSV()
//    {
//            QuizDatabaseHelper quizDatabaseHelper=new QuizDatabaseHelper();
//
//    }

}
