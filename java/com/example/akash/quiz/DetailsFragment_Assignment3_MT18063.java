package com.example.akash.quiz;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private String questionnumber;
    private TextView textView;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioselected;
    private Button save;
    private Button submit;
    private RadioGroup radioGroup;
    private QuizDatabaseHelper qdb;
    private String question=null;

    public DetailsFragment() {
        // Required empty public constructor

    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.question_detail_fragment, container, false);

        if(getArguments()!=null)
        {
             questionnumber=getArguments().getString("question number");
            //Toast.makeText(getContext(),questionnumber,Toast.LENGTH_LONG).show();
            //Log.d("abc","argument");

        }

         textView=(TextView) view.findViewById(R.id.textView);

         radioButton1=(RadioButton) view.findViewById(R.id.radioButton);
         radioButton2=(RadioButton) view.findViewById(R.id.radioButton2);
         save=(Button) view.findViewById(R.id.button);
         submit=(Button) view.findViewById(R.id.button2);
         radioGroup=(RadioGroup)view.findViewById(R.id.radioGroup);

         qdb=new QuizDatabaseHelper(getActivity());
         radioGroup.check(R.id.radioButton);
        //Log.d("after_db","dbcreated");

           // Toast.makeText(getContext(),"After DB",Toast.LENGTH_LONG).show();




        Cursor cursor=qdb.readquestion(questionnumber);
        String q=null;

         StringBuffer stringBuffer = new StringBuffer();
         if(cursor.getCount()!=0)
         {
                while (cursor.moveToNext()) {

                 stringBuffer.append(cursor.getString(1));
             }
         }
         else
         {

             Toast.makeText(getContext(),"could not find the question in database",Toast.LENGTH_LONG).show();
         }
         q=stringBuffer.toString();

        textView.setText(q);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int item=radioGroup.getCheckedRadioButtonId();
                View radio_view=radioGroup.findViewById(item);
                int i=radioGroup.indexOfChild(radio_view);
                String answer=null;
                if(i==0)
                {
                    answer="YES";
                    qdb.updateAnswer(questionnumber,question,answer);

                }
                else
                {

                    answer="NO";
                    qdb.updateAnswer(questionnumber,question,answer);
                }
                Toast.makeText(getActivity(),answer,Toast.LENGTH_LONG).show();

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //sqLite
                File dir=new File(Environment.getExternalStorageDirectory(),"");
                Toast.makeText(getContext(),Environment.getExternalStorageState(),Toast.LENGTH_LONG).show();
                if(!dir.exists())
                {

                    dir.mkdirs();
                }
                File file =new File(dir,"answer.csv");
                try
                {
                    file.createNewFile();
                    CSVWriter csvWriter=new CSVWriter(new FileWriter(file));

                    SQLiteDatabase sqdb=qdb.getReadableDatabase();
                    Cursor cursor1=sqdb.rawQuery("SELECT * FROM questions_table",null);
                    csvWriter.writeNext(cursor1.getColumnNames());
                    while(cursor1.moveToNext())
                    {
                        String a[]={cursor1.getString(0),cursor1.getString(1),cursor1.getString(2)};
                        csvWriter.writeNext(a);
                    }
                    csvWriter.close();
                    cursor1.close();
                    if(file.exists()) {
                        Toast.makeText(getContext(), "file saved", Toast.LENGTH_LONG).show();
                    }
                }
                catch(Exception ex)
                {
                    Toast.makeText(getContext(),"Exception",Toast.LENGTH_LONG).show();
                    Log.d("exception",ex.getMessage(),ex);
                }

            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

}
