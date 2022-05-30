package com.bishal.algobase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class InformationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        String value = getArguments().getString("YourKey");

       //data structure inflater value receiver-inflater
        if(value.equals("1"))
           return inflater.inflate(R.layout.ds_arrays, container, false);
       else if (value.equals("2"))
           return inflater.inflate(R.layout.ds_linkedlist, container, false);
       else if (value.equals("3"))
           return inflater.inflate(R.layout.ds_trees, container, false);
       else if (value.equals("4"))
           return inflater.inflate(R.layout.ds_stacks, container, false);
       else if (value.equals("5"))
           return inflater.inflate(R.layout.ds_queue, container, false);
       else if (value.equals("6"))
           return inflater.inflate(R.layout.ds_heap, container, false);
       else if (value.equals("7"))
           return inflater.inflate(R.layout.ds_graph, container, false);
       else if (value.equals("8"))
           return inflater.inflate(R.layout.ds_tries, container, false);
       else if (value.equals("9"))
           return inflater.inflate(R.layout.ds_segmenttrees, container, false);
       else if (value.equals("10"))
           return inflater.inflate(R.layout.ds_disjointset, container, false);
        else if (value.equals("11"))
            return inflater.inflate(R.layout.algo_searching, container, false);
        else if (value.equals("12"))
            return inflater.inflate(R.layout.algo_sorting, container, false);
        else if (value.equals("13"))
            return inflater.inflate(R.layout.algo_matrix, container, false);
        else if (value.equals("14"))
            return inflater.inflate(R.layout.algo_hashing, container, false);
        else if (value.equals("15"))
            return inflater.inflate(R.layout.algo_strings, container, false);
        else if (value.equals("16"))
            return inflater.inflate(R.layout.algo_greedy, container, false);
        else if (value.equals("17"))
            return inflater.inflate(R.layout.algo_backtracking, container, false);
        else if (value.equals("18"))
            return inflater.inflate(R.layout.algo_dp, container, false);
        else if (value.equals("19"))
            return inflater.inflate(R.layout.algo_recurssion, container, false);
        else
           return  view;
    }
}