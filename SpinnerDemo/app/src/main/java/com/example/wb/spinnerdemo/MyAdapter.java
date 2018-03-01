package com.example.wb.spinnerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends BaseAdapter {

    private List<City> mList;
    private Context mContext;

    public MyAdapter(Context pContext, List<City> cities) {
        this.mContext = pContext;
        this.mList = cities;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflaterayoutInflater=LayoutInflater.from(mContext);
        convertView = layoutInflaterayoutInflater.inflate(R.layout.spinnerview, null);
        if(convertView != null) {
            TextView textView1 = (TextView)convertView.findViewById(R.id.textView1);
            TextView textView2 = (TextView)convertView.findViewById(R.id.textView2);
            textView1.setText(mList.get(position).getProvince());
            textView2.setText(mList.get(position).getCity());
        }
        return convertView;
    }
}
