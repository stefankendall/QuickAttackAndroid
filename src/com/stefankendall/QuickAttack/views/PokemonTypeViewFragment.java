package com.stefankendall.QuickAttack.views;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.data.PokemonStore;
import com.stefankendall.QuickAttack.data.TypeCalculator;

import java.util.List;

public class PokemonTypeViewFragment extends Fragment {
    public static String EXTRA_POKEMON_NAME = "extra_pokemon_name";
    private String pokemon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        this.pokemon = getArguments().getString(EXTRA_POKEMON_NAME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pokemon_types, null);

        List<String> superEffectiveTypes = new TypeCalculator().superEffectiveTypes(PokemonStore.instance().typesFor(this.pokemon));
        List<String> notEffectiveTypes = new TypeCalculator().notEffectiveTypes(PokemonStore.instance().typesFor(this.pokemon));
        List<String> immuneTypes = new TypeCalculator().immuneTypes(PokemonStore.instance().typesFor(this.pokemon));

        LinearLayout superEffective = (LinearLayout) v.findViewById(R.id.type_super_effective);
        LinearLayout notEffective = (LinearLayout) v.findViewById(R.id.type_not_effective);
        LinearLayout immune = (LinearLayout) v.findViewById(R.id.type_immune);

        if (superEffectiveTypes.size() == 0) {
            superEffective.setVisibility(LinearLayout.GONE);
        }
        if (immuneTypes.size() == 0) {
            immune.setVisibility(LinearLayout.GONE);
        }
        if(notEffectiveTypes.size() == 0){
            notEffective.setVisibility(LinearLayout.GONE);
        }

        ListView superEffectiveList = (ListView) superEffective.findViewById(android.R.id.list);
        ListView notEffectiveList = (ListView) notEffective.findViewById(android.R.id.list);
        ListView immuneList = (ListView) immune.findViewById(android.R.id.list);

        superEffectiveList.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, superEffectiveTypes));
        notEffectiveList.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, notEffectiveTypes));
        immuneList.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, immuneTypes));

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
