package com.example.foodapp.All.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodapp.All.Adapter.ChatPageReceiverAdaper;
import com.example.foodapp.All.Adapter.ChatPageSenderAdaper;
import com.example.foodapp.All.Adapter.ImportMealAdapter;
import com.example.foodapp.All.Models.ChatPageReceiver;
import com.example.foodapp.All.Models.ChatPageSender;
import com.example.foodapp.R;

import java.util.ArrayList;

public class ChatPage extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ChatPageSender> chatPageSenders;
    ArrayList<ChatPageReceiver> chatPageReceivers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_page, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_chat_message);

        chatPageSenders = new ArrayList<>();
        chatPageReceivers = new ArrayList<>();

        chatPageReceivers.add(new ChatPageReceiver("Hello Let's Talk","12:30"));
        chatPageReceivers.add(new ChatPageReceiver("Hey there! What's up is everything? ","12:35"));
        chatPageReceivers.add(new ChatPageReceiver("I am enjoying shopping list and meal plan ","12:38"));
        chatPageReceivers.add(new ChatPageReceiver("Yeah i know. I'm in the some position","2:35"));
        chatPageReceivers.add(new ChatPageReceiver("Enjoy your favourite food and set your goals","2:40"));

        chatPageReceivers.add(new ChatPageReceiver("Hello Let's Talk","12:30"));
        chatPageReceivers.add(new ChatPageReceiver("Hey there! What's up is everything? ","12:35"));
        chatPageReceivers.add(new ChatPageReceiver("I am enjoying shopping list and meal plan ","12:38"));
        chatPageReceivers.add(new ChatPageReceiver("Yeah i know. I'm in the some position","2:35"));
        chatPageReceivers.add(new ChatPageReceiver("Enjoy your favourite food and set your goals","2:40"));

        Receiver(chatPageReceivers);

        return view;
    }
    public void Receiver(ArrayList<ChatPageReceiver> data)
    {
        ChatPageReceiverAdaper adapter = new ChatPageReceiverAdaper(getContext(),data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void Sender(ArrayList<ChatPageSender> data)
    {
        ChatPageSenderAdaper adapter = new ChatPageSenderAdaper(getContext(),data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}