package com.stefankendall.QuickAttack.views.my;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.data.MyPokemonStore;
import com.stefankendall.QuickAttack.views.PokemonSelectActivity;
import com.stefankendall.QuickAttack.views.type.PokemonTypeViewFragment;

public class MyPokemonListFragment extends ListFragment {
    private boolean isDeleting;

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
        if (this.isDeleting) {
            MyPokemonStore.instance().remove(MyPokemonStore.instance().getPokemon().get(position));
            this.setupListAdapterForIsDeleting();
        } else if (position == this.getListAdapter().getCount() - 1 && !this.isDeleting) {
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.delete_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete) {
            this.isDeleting = !this.isDeleting;
            this.setupListAdapterForIsDeleting();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupListAdapterForIsDeleting() {
        TextView item = (TextView) getActivity().findViewById(R.id.delete);
        if (this.isDeleting) {
            item.setText("Done");
            this.setListAdapter(new MyPokemonDeletingListAdapter());
        } else {
            item.setText("Delete");
            this.setListAdapter(new MyPokemonListAdapter());
        }
    }

    private void addPokemon(String pokemon) {
        MyPokemonStore.instance().add(pokemon);
        this.setListAdapter(new MyPokemonListAdapter());
    }
}
