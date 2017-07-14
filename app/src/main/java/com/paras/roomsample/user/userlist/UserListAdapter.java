package com.paras.roomsample.user.userlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.paras.roomsample.R;
import com.paras.roomsample.model.datamodel.User;

import java.util.List;

/**
 * Created by Paras on 7/14/2017.
 */

public class UserListAdapter extends BaseAdapter {
    List<User> userList;
    LayoutInflater inflator;

    public UserListAdapter(Context context, List<User> list) {
        this.userList = list;
        inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return userList == null ? 0 : userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList == null ? null : userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null) {
            view = inflator.inflate(R.layout.user_list_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        User user= userList.get(i);
        holder.tvUid.setText(String.valueOf(user.getUid()));
        holder.tvFname.setText(String.valueOf(user.getFirstName()));
        holder.tvLname.setText(String.valueOf(user.getLastName()));
        holder.tvCity.setText(String.valueOf(user.getAddress().getCity()));
        holder.tvState.setText(String.valueOf(user.getAddress().getState()));
        holder.tvPin.setText(String.valueOf(user.getAddress().getPostCode()));
        return view;
    }

    static class ViewHolder {
        TextView tvUid, tvFname, tvLname, tvCity, tvState, tvPin;

        public ViewHolder(View view) {
            tvUid = (TextView) view.findViewById(R.id.uid);
            tvFname = (TextView) view.findViewById(R.id.fname);
            tvLname = (TextView) view.findViewById(R.id.lname);
            tvCity = (TextView) view.findViewById(R.id.city);
            tvState = (TextView) view.findViewById(R.id.state);
            tvPin = (TextView) view.findViewById(R.id.pin);
        }
    }
}