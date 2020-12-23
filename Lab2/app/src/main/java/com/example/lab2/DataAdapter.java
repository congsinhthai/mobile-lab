package com.example.lab2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends BaseAdapter {
    private Activity activity;
    private List<String> items;

    public DataAdapter( List items) {

        this.items = items;
    }



    @Override

    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewItems;
        if (view==null){
            viewItems=View.inflate(viewGroup.getContext(),R.layout.item,null);
        } else viewItems=view;
        String str=(String)getItem(i);
        ( (TextView) viewItems.findViewById(R.id.tv_name)).setText(String.format(str));
        return viewItems;
    }
}
