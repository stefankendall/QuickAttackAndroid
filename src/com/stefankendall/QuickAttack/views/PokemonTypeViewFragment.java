package com.stefankendall.QuickAttack.views;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;

public class PokemonTypeViewFragment extends ListFragment {
    public static String EXTRA_POKEMON_NAME = "extra_pokemon_name";
    private String pokemon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        this.pokemon = getArguments().getString(EXTRA_POKEMON_NAME);
        this.setListAdapter(new PokemonTypeListAdapter(this.pokemon));
    }

    public static Fragment newInstance(String pokemon) {
        PokemonTypeViewFragment fragment = new PokemonTypeViewFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_POKEMON_NAME, pokemon);
        fragment.setArguments(args);
        return fragment;
    }
}
