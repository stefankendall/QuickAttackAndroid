package com.stefankendall.QuickAttack.views;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.my.MyPokemonSelectListActivity;
import com.stefankendall.QuickAttack.views.type.PokemonTypeViewFragment;

public class PokemonListCompareFragment extends PokemonListFragment {
    public static Fragment newInstance(String title) {
        PokemonListCompareFragment fragment = new PokemonListCompareFragment();
        Bundle args = new Bundle();
        args.putString(PokemonSelectActivity.EXTRA_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Compare to");
        if (savedInstanceState != null) {
            String title = savedInstanceState.getString(PokemonSelectActivity.EXTRA_TITLE);
            if (title != null) {
                getActivity().setTitle(title);
            }
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String pokemon = (String) this.getListAdapter().getItem(position);
        finishWithPokemon(pokemon);
    }

    private void finishWithPokemon(String pokemon) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME, pokemon);
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.compare_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        setupSearchForMenuItem(searchItem);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().setResult(Activity.RESULT_OK, null);
            getActivity().finish();
            return true;
        } else if (item.getItemId() == R.id.mine) {
            Intent intent = new Intent(getActivity(), MyPokemonSelectListActivity.class);
            startActivityForResult(intent, 0);
            return true;
        }

        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            Log.i("TAG", "Finishing with pokemon: " + data.getStringExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME));
        if (resultCode == Activity.RESULT_OK) {
            this.finishWithPokemon(data.getStringExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME));
        }
    }
}
