package com.stefankendall.QuickAttack.views;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
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
        Intent resultIntent = new Intent();
        resultIntent.putExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME, pokemon);
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().setResult(Activity.RESULT_OK, null);
            getActivity().finish();
            return true;
        }
        return false;
    }
}
