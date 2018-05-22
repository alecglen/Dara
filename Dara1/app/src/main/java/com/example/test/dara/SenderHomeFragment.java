package com.example.test.dara;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressWarnings("ALL")
public class SenderHomeFragment extends Fragment {

    public SenderHomeFragment() {
        // Required empty public constructor
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_sender_home, container, false);

        // Make button lead to the New Request interface
        Button newReq = view.findViewById(R.id.new_req_button);
        newReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), NewReqActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Pick-up Location", "Not Set");
                bundle.putString("Drop-off Location", "Not Set");
                bundle.putString("Item Description", "Not Set");
                bundle.putString("Initial Offer", "Not Set");
                bundle.putString("Due Date", "Not Set");
                myIntent.putExtras(bundle);
                getActivity().startActivity(myIntent);
            }
        });

        // Populate Requests list
        final Bundle bundle = getArguments();
        ArrayList<String> requests;
        if (bundle != null && bundle.containsKey("requests")) {
            requests = getArguments().getStringArrayList("requests");
        } else {
            requests = new ArrayList<>(Collections.singleton("No requests yet!@@@Select New Request to get started."));
        }
        RequestsAdapter adapter = new RequestsAdapter(getActivity(), R.layout.job_lists, requests);
        ListView listView = view.findViewById(R.id.reqs_list);
        listView.setAdapter(adapter);

        // Set ListView clickListeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (bundle != null && bundle.containsKey("requests")) {
                    ArrayList<String> requests2 = getArguments().getStringArrayList("requests");
                    if (requests2.get(0).substring(0, 2) != "No") {
                        Intent myIntent = new Intent(getActivity(), CarrierDataActivity.class);
                        myIntent.putExtras(bundle);
                        getActivity().startActivity(myIntent);
                    }
                }
            }
        });

        return view;
    }



}




