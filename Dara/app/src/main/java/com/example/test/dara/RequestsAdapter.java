package com.example.test.dara;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


class RequestsAdapter extends BaseAdapter {

    private Context mContext;
    private int mResource;
    private String[] mAttributes;

    RequestsAdapter(Context context, int resource, String[] attributes) {
        super();
        mContext = context;
        mResource = resource;
        mAttributes = attributes;
    }

    @Override
    public int getCount() {
        return mAttributes.length;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return mAttributes[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int pos, View convertView, @NonNull ViewGroup parent) {

        // Inflate new View if needed
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            convertView = inflater.inflate(mResource, parent, false);
        }

        // Get list item content
        String[] attrs = mAttributes[pos].split("@@@");
        String title = attrs[0];
        String status = attrs[1];

        // Set attribute label and value
        TextView tv1 = convertView.findViewById(R.id.label);
        tv1.setText(title);
        TextView tv2 = convertView.findViewById(R.id.status);
        tv2.setText(status);

        return convertView;
    }
}