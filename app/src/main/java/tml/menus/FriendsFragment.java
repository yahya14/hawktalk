package tml.menus;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.*;

import android.widget.ListView;
import tml.hawktalk.R;
import tml.listadapter.ChatList;
import tml.listadapter.ChatListAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {


    public FriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the options menu
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        ArrayList<ChatList> chats = new ArrayList<>();
        chats.add(new ChatList("Emily","Emily: Want to hangout after school? :)", "10:06 am"));
        chats.add(new ChatList("Jordan","You: I love Dragon Ball Z!", "12:46 am"));

        ChatListAdapter adapter = new ChatListAdapter(view.getContext(), R.layout.adapter_view_layout, chats);
        ((ListView) view.findViewById(R.id.lst_friends)).setAdapter(adapter);

        // Inflate the layout for this fragment
        return  view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
