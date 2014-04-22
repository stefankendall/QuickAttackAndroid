package com.stefankendall.QuickAttack.views.type;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.*;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.stats.PokemonStatsActivity;

public class PokemonTypeViewFragment extends ListFragment implements MegaDelegate {
    public static String EXTRA_POKEMON_NAME = "extra_pokemon_name";
    private String pokemon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        this.pokemon = getArguments().getString(EXTRA_POKEMON_NAME);
        this.setListAdapter(new PokemonTypeListAdapter(getArguments().getString(EXTRA_POKEMON_NAME), this));

        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.getListView().setSelector(R.drawable.not_selectable);
        this.getListView().setCacheColorHint(Color.TRANSPARENT);
    }

    public static Fragment newInstance(String pokemon) {
        PokemonTypeViewFragment fragment = new PokemonTypeViewFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_POKEMON_NAME, pokemon);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.type_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.stats) {
            Intent intent = new Intent(getActivity(), PokemonStatsActivity.class);
            intent.putExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME, this.pokemon);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    public void switchTo(String pokemon) {
        Intent intent = new Intent(getActivity(), PokemonTypeViewActivity.class);
        intent.putExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME, pokemon);
        startActivity(intent);
        this.getActivity().finish();
    }
}
