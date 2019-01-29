package com.example.hwangdahyeon.mvvm_project_03;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hwangdahyeon.mvvm_project_03.databinding.ListItemUserBinding;

public class UserListViewAdapter extends BaseAdapter {

    private ObservableArrayList<UserViewModel> users = new ObservableArrayList<>();

    public void addAll(ObservableArrayList<UserViewModel> users){
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ListItemUserBinding binding;

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            binding = DataBindingUtil.inflate(inflater , R.layout.list_item_user , viewGroup , false);
            view = binding.getRoot();
            view.setTag(binding);
        } else {
            binding = (ListItemUserBinding) view.getTag();
        }

        binding.setUser(users.get(i));

        return view;
    }
}
