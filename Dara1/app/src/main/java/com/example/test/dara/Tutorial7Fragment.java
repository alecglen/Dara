package com.example.test.dara;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tutorial7Fragment extends Fragment {


    public Tutorial7Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tutorial7, container, false);

        // Make button lead to the Tutorial
        Button newUser = view.findViewById(R.id.create_account_button);
        newUser.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           Intent myIntent = new Intent(getActivity(), HomeScreenActivity.class);
                                           Bundle bundle = new Bundle();
                                           ArrayList<String> requests = new ArrayList<>(Collections.singleton("No requests yet!@@@Select New Request to get started."));
                                           ArrayList<String> trips = new ArrayList<>(Collections.singleton("No trips yet!@@@Select New Trip to get started."));
                                           bundle.putStringArrayList("requests",requests);
                                           bundle.putStringArrayList("trips", trips);
                                           myIntent.putExtras(bundle);
                                           getActivity().startActivity(myIntent);
                                       }
                                   });

        // Inflate the layout for this fragment
        return view;
    }

}

