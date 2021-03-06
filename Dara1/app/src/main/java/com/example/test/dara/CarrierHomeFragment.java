package com.example.test.dara;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressWarnings("ALL")
public class CarrierHomeFragment extends Fragment {

    public CarrierHomeFragment() {
        // Required empty public constructor
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carrier_home, container, false);

        // Make button lead to the New Request interface
        Button newReq = view.findViewById(R.id.new_trip_button);
        newReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), NewTripActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Starting Location", "Not Set");
                bundle.putString("Destination", "Not Set");
                bundle.putString("Cargo Capacity", "Not Set");
                bundle.putString("Arrival Date", "Not Set");
                myIntent.putExtras(bundle);
                getActivity().startActivity(myIntent);
            }
        });

        // Populate Requests list
        Bundle bundle = getArguments();
        ArrayList<String> trips;
        if (bundle != null && bundle.containsKey("trips")) {
            trips = getArguments().getStringArrayList("trips");
        } else {
            trips = new ArrayList<>(Collections.singleton("No trips yet!@@@Select New Trip to get started."));
        }
        RequestsAdapter adapter = new RequestsAdapter(getActivity(), R.layout.job_lists, trips);
        ListView listView = view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        return view;
    }



}










