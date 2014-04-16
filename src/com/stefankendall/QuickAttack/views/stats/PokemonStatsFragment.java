package com.stefankendall.QuickAttack.views.stats;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import com.stefankendall.QuickAttack.views.type.PokemonTypeViewFragment;

public class PokemonStatsFragment extends ListFragment {
    private String pokemon;

    public static Fragment newInstance(String pokemon) {
        PokemonStatsFragment fragment = new PokemonStatsFragment();
        Bundle args = new Bundle();
        args.putString(PokemonTypeViewFragment.EXTRA_POKEMON_NAME, pokemon);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        this.pokemon = getArguments().getString(PokemonTypeViewFragment.EXTRA_POKEMON_NAME);
        getActivity().getActionBar().setTitle(this.pokemon);
        this.setListAdapter(new PokemonStatsListAdapter(this.pokemon));
    }
}
