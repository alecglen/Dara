package com.example.test.dara;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


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
        Button newTrip = view.findViewById(R.id.new_req_button);
        newTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Testing New Trip Button", Toast.LENGTH_SHORT).show();
            }
        });

        // Populate Requests list
        String[] requests = {"No trips yet!"};
        //noinspection ConstantConditions
        @SuppressWarnings("ConstantConditions") ArrayAdapter adapter = new ArrayAdapter<>(getActivity(),R.layout.job_lists,requests);
        ListView listView = view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        return view;
    }



}









