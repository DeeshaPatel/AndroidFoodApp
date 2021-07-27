package com.example.foodapp.All.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodapp.All.Adapter.ShoppingListAdapter;
import com.example.foodapp.All.Models.ShoppingListModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class ShoppingList extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ShoppingListModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_list, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_shopping_list);
        list = new ArrayList<ShoppingListModel>();
        list.add(new ShoppingListModel(R.drawable.splash3,"My Meal","Ingrident 1","Indrident 2","Ingrident 3","Ingrident 4","12:30"));
        list.add(new ShoppingListModel(R.drawable.splash3,"My Meal","Ingrident 1","Indrident 2","Ingrident 3","Ingrident 4","12:30"));
        list.add(new ShoppingListModel(R.drawable.splash3,"My Meal","Ingrident 1","Indrident 2","Ingrident 3","Ingrident 4","12:30"));
        list.add(new ShoppingListModel(R.drawable.splash3,"My Meal","Ingrident 1","Indrident 2","Ingrident 3","Ingrident 4","12:30"));
        list.add(new ShoppingListModel(R.drawable.splash3,"My Meal","Ingrident 1","Indrident 2","Ingrident 3","Ingrident 4","12:30"));
        list.add(new ShoppingListModel(R.drawable.splash3,"My Meal","Ingrident 1","Indrident 2","Ingrident 3","Ingrident 4","12:30"));

        ShoppingListAdapter foodDiaryMealaAdapter = new ShoppingListAdapter(getContext(),list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(foodDiaryMealaAdapter);


        return view;
    }
}