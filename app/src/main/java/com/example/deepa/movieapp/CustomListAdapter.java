package com.example.deepa.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class CustomListAdapter extends BaseAdapter {

    Context context;
    List<DataHandler> data;
    LayoutInflater inflater;

    public CustomListAdapter(Context context, List<DataHandler> data){
        this.context= context;
        this.data= data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null) {
            inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.list_item, parent, false);
            holder= new ViewHolder();
            holder.name= (TextView)convertView.findViewById(R.id.name);
            holder.count= (TextView)convertView.findViewById(R.id.vote_count);
            holder.id= (TextView)convertView.findViewById(R.id.id);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder)convertView.getTag();
        }

        holder.name.setText(data.get(position).getName());
        holder.id.setText("Id: "+data.get(position).getId()+"");
        holder.count.setText("Votes: "+data.get(position).getVote_count()+"");

        return convertView;
    }

    class ViewHolder{
        TextView name, id, count;
    }
}
