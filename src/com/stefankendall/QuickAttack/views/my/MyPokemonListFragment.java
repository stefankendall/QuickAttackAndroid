package com.stefankendall.QuickAttack.views.my;

import android.app.ListFragment;
import android.os.Bundle;

public class MyPokemonListFragment extends ListFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        setHasOptionsMenu(true);
        getActivity().setTitle("My Pokemon");

        this.setListAdapter(new MyPokemonListAdapter());
    }
}
