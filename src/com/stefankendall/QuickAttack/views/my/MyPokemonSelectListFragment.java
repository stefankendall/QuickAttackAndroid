package com.stefankendall.QuickAttack.views.my;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.stefankendall.QuickAttack.data.MyPokemonStore;
import com.stefankendall.QuickAttack.views.type.PokemonTypeViewFragment;

public class MyPokemonSelectListFragment extends ListFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        getActivity().setTitle("My Pokemon");

        this.setListAdapter(new MyPokemonListAdapter(false));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent data = new Intent();
        data.putExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME, MyPokemonStore.instance().getPokemon().get(position));
        getActivity().setResult(Activity.RESULT_OK, data);
        getActivity().finish();
    }
}
