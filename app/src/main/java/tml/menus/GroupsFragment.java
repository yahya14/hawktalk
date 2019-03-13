package tml.menus;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.widget.ListView;
import tml.hawktalk.R;
import tml.listadapter.ChatList;
import tml.listadapter.ChatListAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupsFragment extends Fragment {


    public GroupsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_groups, container, false);
        // Listener
        FloatingActionButton fab = view.findViewById(R.id.fab_group_search);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayList<ChatList> chats = new ArrayList<>();
        chats.add(new ChatList("CP264","You: Hi! Nice to meet everyone!", "1:06 pm"));
        chats.add(new ChatList("CP216","You: When is the midterm happening tomorrow?", "10:23 am"));
        chats.add(new ChatList("CP213","Junaid: I got you bro I can help.", "6:22 pm"));
        chats.add(new ChatList("BU111","Jacob: lol", "7:45 pm"));
        chats.add(new ChatList("BU208","Emily: How did everyone do on the midterm? :)", "5:45 pm"));
        chats.add(new ChatList("MA201","Hassan: I don't understand this question can someone help?", "10:45 pm"));

        ChatListAdapter adapter = new ChatListAdapter(view.getContext(), R.layout.adapter_view_layout, chats);
        ((ListView) view.findViewById(R.id.lst_chats)).setAdapter(adapter);
        return view;
    }

}
