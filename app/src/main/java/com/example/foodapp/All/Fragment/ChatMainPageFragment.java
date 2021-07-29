package com.example.foodapp.All.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodapp.All.Adapter.ChatAppHead;
import com.example.foodapp.All.Adapter.ChatAppListAdapter;
import com.example.foodapp.All.Models.ChatAppHeadModel;
import com.example.foodapp.All.Models.ChatAppListModel;
import com.example.foodapp.R;

import java.util.ArrayList;


public class ChatMainPageFragment extends Fragment {

    RecyclerView header,list_of_people;
    ArrayList<ChatAppHeadModel> models;
    ArrayList<ChatAppListModel> chatAppListModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_main_page, container, false);

        header = (RecyclerView)view.findViewById(R.id.rcv_top_list_chat);
        list_of_people = (RecyclerView)view.findViewById(R.id.rcv_chat_list_of_people);

        models = new ArrayList<>();
        models.add(new ChatAppHeadModel(R.drawable.face1,R.color.chat_pink));
        models.add(new ChatAppHeadModel(R.drawable.face2,R.color.chat_purple));
        models.add(new ChatAppHeadModel(R.drawable.face3,R.color.chat_yello));
        models.add(new ChatAppHeadModel(R.drawable.face4,R.color.chat_light_green));

        ChatAppHead chatAppHead = new ChatAppHead(getContext(),models);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        header.setLayoutManager(linearLayoutManager);
        header.setAdapter(chatAppHead);

        chatAppListModels = new ArrayList<>();
        chatAppListModels.add(new ChatAppListModel(R.drawable.face1,R.color.chat_blue,"Deesha","Your last message is ","12:30"));
        chatAppListModels.add(new ChatAppListModel(R.drawable.face2,R.color.chat_dark_green,"Addy","Your last message is ","12:10"));
        chatAppListModels.add(new ChatAppListModel(R.drawable.face3,R.color.chat_pink,"Elite","Your last message is ","2:30"));
        chatAppListModels.add(new ChatAppListModel(R.drawable.face4,R.color.chat_purple,"Justin","Your last message is ","7:30"));
        chatAppListModels.add(new ChatAppListModel(R.drawable.face1,R.color.chat_yello,"Komal","Your last message is ","9:30"));
        chatAppListModels.add(new ChatAppListModel(R.drawable.face2,R.color.chat_pink,"Khushbu","Your last message is ","10:30"));

        ChatAppListAdapter chatAppListAdapter = new ChatAppListAdapter(getContext(),chatAppListModels);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        list_of_people.setLayoutManager(linearLayoutManager1);
        list_of_people.setAdapter(chatAppListAdapter);

        return view;
    }
}