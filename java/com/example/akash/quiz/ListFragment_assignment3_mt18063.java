package com.example.akash.quiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment  {

    ArrayList<String> question=new ArrayList<String>();



    public ListFragment() {
        // Required empty public constructor
    }



//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.question_list_fragment, container, false);
        initialize();
        RecyclerView recyclerView=view.findViewById(R.id.recyclerView);
        ListAdapter listAdapter=new ListAdapter(question,getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(30);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

    void initialize()
    {
        question.add("Question 1");
        question.add("Question 2");
        question.add("Question 3");
        question.add("Question 4");
        question.add("Question 5");
        question.add("Question 6");
        question.add("Question 7");
        question.add("Question 8");
        question.add("Question 9");
        question.add("Question 10");
        question.add("Question 11");
        question.add("Question 12");
        question.add("Question 13");
        question.add("Question 14");
        question.add("Question 15");
        question.add("Question 16");
        question.add("Question 17");
        question.add("Question 18");
        question.add("Question 19");
        question.add("Question 20");
        question.add("Question 21");
        question.add("Question 22");
        question.add("Question 23");
        question.add("Question 24");
        question.add("Question 25");
        question.add("Question 26");
        question.add("Question 27");
        question.add("Question 28");
        question.add("Question 29");
        question.add("Question 30");



    }


}
