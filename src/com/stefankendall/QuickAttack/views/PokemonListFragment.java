package com.stefankendall.QuickAttack.views;

import android.app.ListFragment;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.SearchView;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.type.PokemonTypeViewActivity;
import com.stefankendall.QuickAttack.views.type.PokemonTypeViewFragment;

public class PokemonListFragment extends ListFragment {
    private String currentSearch = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        setHasOptionsMenu(true);
        getActivity().setTitle("Who are you fighting?");
        this.setListAdapter(new PokemonListAdapter(getActivity(), ""));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        setupSearchForMenuItem(searchItem);
    }

    protected void setupSearchForMenuItem(MenuItem searchItem) {
        final SearchView searchView = (SearchView) searchItem.getActionView();

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        ComponentName name = getActivity().getComponentName();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(name));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchView.clearFocus();
                ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(searchView.getWindowToken(), 0);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String filter) {
                currentSearch = filter;
                filterPokemon(filter);
                return false;
            }
        });

        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                SearchView searchView = (SearchView) menuItem.getActionView();
                String oldText = currentSearch;
                searchView.onActionViewExpanded();
                currentSearch = oldText;
                searchView.setQuery(currentSearch, false);
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return true;
            }
        });
    }

    public void filterPokemon(String filter) {
        this.setListAdapter(new PokemonListAdapter(getActivity(), filter));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String pokemon = (String) this.getListAdapter().getItem(position);
        Intent intent = new Intent(getActivity(), PokemonTypeViewActivity.class);
        intent.putExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME, pokemon);
        startActivity(intent);
    }
}