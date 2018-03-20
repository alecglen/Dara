package com.example.test.dara;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarrierHomeFragment extends Fragment {

    public CarrierHomeFragment() {
        // Required empty public constructor
    }

    private Button newTrip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carrier_home, container, false);

        // Make button lead to the New Request interface
        newTrip = view.findViewById(R.id.new_req_button);
        newTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Testing New Trip Button", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }



}
