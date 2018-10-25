package com.example.akash.quiz;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private ArrayList<String> question=new ArrayList<String>();
    private Context context;

    public ListAdapter(ArrayList<String> question, Context context) {

        this.question=question;
        this.context=context;
    }

    @NonNull
    @Override


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.question_number,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.questionTextView.setText(question.get(i));
    }

    @Override
    public int getItemCount() {
        return question.size();
    }

//    @Override
//    public void onClick(View view) {
//
//        //getAdapterPosition();
//
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView questionTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView=itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int questionnumber=getAdapterPosition()+1;
                    String number=Integer.toString(questionnumber);
                    //Toast.makeText(view.getContext(),"Question "+ questionnumber,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(context,MainActivity.class);
                    intent.putExtra("question number",number);
                    context.startActivity(intent);
                }
            });
        }
    }
}
