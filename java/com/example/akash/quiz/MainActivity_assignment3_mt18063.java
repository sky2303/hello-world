package com.example.akash.quiz;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private ArrayList<String> questionNumbers=new ArrayList<String>();
    QuizDatabaseHelper quizDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quizDatabaseHelper=new QuizDatabaseHelper(this);
        Cursor cursor=quizDatabaseHelper.getCount();
        if(cursor.getCount()==0)
        {
            //Toast.makeText(this,"no data in database",Toast.LENGTH_LONG).show();
            quizDatabaseHelper.insertdata("1", "You cannot format text in an e-mail message.", "NA");
            quizDatabaseHelper.insertdata("2", "You must include a subject in any mail message you compose", "NA");
            quizDatabaseHelper.insertdata("3", "If you want to respond to the sender of a message, click the Respond button.", "NA");
            quizDatabaseHelper.insertdata("4", "You type the body of a reply the same way you would type the body of a new message. ", "NA");
            quizDatabaseHelper.insertdata("5", " When you reply to a message, you need to enter the text in the Subject: field.", "NA");
            quizDatabaseHelper.insertdata("6", "You can only print one copy of a selected message.", "NA");
            quizDatabaseHelper.insertdata("7", "You cannot preview a message before you print it.", "NA");
            quizDatabaseHelper.insertdata("8", "There is only one way to print a message.", "NA");
            quizDatabaseHelper.insertdata("9", "When you print a message, it is automatically deleted from your Inbox.", "NA");
            quizDatabaseHelper.insertdata("10", "You need to delete a contact and create a new one to change contact information.", "NA");
            quizDatabaseHelper.insertdata("11", "You must complete all fields in the Contact form before you can save the contact.", "NA");
            quizDatabaseHelper.insertdata("12", "You cannot edit Contact forms.", "NA");
            quizDatabaseHelper.insertdata("13", "You should always open and attachment before saving it.", "NA");
            quizDatabaseHelper.insertdata("14", " All attachment are safe.", "NA");
            quizDatabaseHelper.insertdata("15", "It is impossible to send a worm or virus over the Internet using in attachment.", "NA");
            quizDatabaseHelper.insertdata("16", "You can only send one attachment per e-mail message", "NA");
            quizDatabaseHelper.insertdata("17", "There is only one way to delete a message.", "NA");
            quizDatabaseHelper.insertdata("18", "The Delete key is for deleting text, it will not delete messages from your Inbox. ", "NA");
            quizDatabaseHelper.insertdata("19", "Pressing the Delete key and clicking the Delete button produce the same result.", "NA");
            quizDatabaseHelper.insertdata("20", "In Outlook, you must store all of your messages in the Inbox.", "NA");
            quizDatabaseHelper.insertdata("21", "You can only store messages in a new folder if they are received after you create the folder.", "NA");
            quizDatabaseHelper.insertdata("22", "New folders must all be at the same level.", "NA");
            quizDatabaseHelper.insertdata("23", "There is only one way to create a new folder.", "NA");
            quizDatabaseHelper.insertdata("24", "Your password should be something others will be able to figured out, such as your birthday or wedding anniversary.", "NA");
            quizDatabaseHelper.insertdata("25", "You cannot send a file from a Web-based e-mail account.", "NA");
            quizDatabaseHelper.insertdata("26", "Your e-mail address must be unique. ", "NA");
            quizDatabaseHelper.insertdata("27", "You can sign up for Web-based e-mail without accepting the Web site's terms and conditions.", "NA");
            quizDatabaseHelper.insertdata("28", "Web-based e-mail accounts do not required passwords.", "NA");
            quizDatabaseHelper.insertdata("29", "You can delete e-mails from a Web-based e-mail account.", "NA");
            quizDatabaseHelper.insertdata("30", "You can store Web-based e-mail messages in online folders.", "NA");

        }
        Fragment fragment=new DetailsFragment();
        if(savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.main_container,new ListFragment()).commit();
        }

        Bundle bundle=new Bundle();
        if(getIntent().hasExtra("question number"))
        {
            String number=getIntent().getStringExtra("question number");
            bundle.putString("question number" , number);
            fragment.setArguments(bundle);
            //Toast.makeText(this,number,Toast.LENGTH_LONG).show();
            //fragment=getSupportFragmentManager().findFragmentByTag("list_fragment");
            //if(fragment!=null)
            //fragment=new DetailsFragment();
            //getSupportFragmentManager().beginTransaction().add(R.id.main_container,new DetailsFragment()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();


        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
