package com.stefankendall.QuickAttack.views;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.stefankendall.QuickAttack.R;

public class PokemonTypeViewFragment extends Fragment {
    public static String EXTRA_POKEMON_NAME = "extra_pokemon_name";
    private String pokemon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        if (savedInstanceState != null) {
            this.pokemon = savedInstanceState.getString(EXTRA_POKEMON_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pokemon_types, null);

        LinearLayout superEffective = (LinearLayout) v.findViewById(R.id.type_super_effective);
        LinearLayout immune = (LinearLayout) v.findViewById(R.id.type_immune);
        LinearLayout notEffective = (LinearLayout) v.findViewById(R.id.type_not_effective);

        return v;
    }

    public static Fragment newInstance(String pokemon) {
        PokemonTypeViewFragment fragment = new PokemonTypeViewFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_POKEMON_NAME, pokemon);
        fragment.setArguments(args);
        return fragment;
    }
}
