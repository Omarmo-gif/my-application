package com.example.myfirstapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

private CardView sport_card,time_card,life_card,love_card;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

sport_card=root.findViewById(R.id.sport_card);
life_card=root.findViewById(R.id.life_card);
love_card=root.findViewById(R.id.love_card);
time_card=root.findViewById(R.id.time_card);

sport_card.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getContext(), Sport_Books.class);
        getContext().startActivity(intent);
    }
});
        love_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Love_Books.class);
                getContext().startActivity(intent);
            }
        });
        life_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Life_Books.class);
                getContext().startActivity(intent);
            }
        });
        time_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Time_Books.class);
                getContext().startActivity(intent);
            }
        });
        return root;
    }
}