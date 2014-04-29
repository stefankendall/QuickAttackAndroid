package com.stefankendall.QuickAttack.views.my;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.stefankendall.QuickAttack.views.PokemonSelectActivity;
import com.stefankendall.QuickAttack.views.type.PokemonTypeViewFragment;

public class MyPokemonListFragment extends ListFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        setHasOptionsMenu(true);
        getActivity().setTitle("My Pokemon");

        this.setListAdapter(new MyPokemonListAdapter());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (position == 0) {
            Intent i = new Intent(getActivity(), PokemonSelectActivity.class);
            i.putExtra(PokemonSelectActivity.EXTRA_TITLE, "Add");
            startActivityForResult(i, 0);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null && data.hasExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME)) {
            addPokemon(data.getStringExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME));
        }
    }

    private void addPokemon(String pokemon) {
        Log.i("TAG", pokemon);
    }
}
