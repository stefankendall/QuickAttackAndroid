package com.stefankendall.QuickAttack.views;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.stefankendall.QuickAttack.R;

public class PokemonListFragment extends ListFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Who are you fighting?");
        this.setListAdapter(new PokemonListAdapter(getActivity()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);

        View v = inflater.inflate(R.layout.fragment_pokemon_list, null);
//        ListView listVIew = (ListView) v.findViewById(android.R.id.list);
        return v;
    }
}
