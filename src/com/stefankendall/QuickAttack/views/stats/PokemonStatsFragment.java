package com.stefankendall.QuickAttack.views.stats;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.PokemonCompareActivity;
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

        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.getListView().setSelector(R.drawable.not_selectable);
        this.getListView().setCacheColorHint(Color.TRANSPARENT);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.stats_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.compare) {
            Intent i = new Intent(getActivity(), PokemonCompareActivity.class);
            startActivityForResult(i, 0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null && data.hasExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME)) {
            addComparePokemon(data.getStringExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME));
        } else {
            this.setListAdapter(new PokemonStatsListAdapter(this.pokemon));
        }
    }

    private void addComparePokemon(String comparePokemon) {
        this.setListAdapter(new PokemonStatsCompareListAdapter(this.pokemon, comparePokemon));
    }
}
