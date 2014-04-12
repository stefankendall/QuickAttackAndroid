package com.stefankendall.QuickAttack.data;

import android.util.Log;
import com.google.common.base.Charsets;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.io.CharStreams;
import com.google.common.io.Closeables;
import com.google.common.io.InputSupplier;
import com.google.gson.Gson;
import com.stefankendall.QuickAttack.App;
import com.stefankendall.QuickAttack.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class PokemonStore {
    static PokemonStore pokemonStore;
    Map<String, Map> pokemonData;

    public static synchronized PokemonStore instance() {
        if (pokemonStore == null) {
            pokemonStore = new PokemonStore();
        }
        return pokemonStore;
    }

    void load() throws IOException {
        if (pokemonData == null) {
            InputStream stream = App.getContext().getResources().openRawResource(R.raw.pokemon);
            String pokemonJson = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
            Closeables.close(stream, true);

            Gson gson = new Gson();
            this.pokemonData = gson.fromJson(pokemonJson, Map.class);
        }
    }

    public List<String> typesFor(String name) {
        return (List<String>) this.pokemonData.get(name).get("types");
    }

    public List<String> names() {
        return Ordering.natural().immutableSortedCopy(this.pokemonData.keySet());
    }

    public List<String> namesMatching(final String name) {
        if( name.equals("")){
            return this.names();
        }
        return Lists.newArrayList(Collections2.filter(this.names(), new Predicate<String>() {
            @Override
            public boolean apply(String pokemon) {
                return pokemon.toLowerCase().indexOf(name.toLowerCase()) == 0;
            }
        }));
    }

    Map<String, Double> statsFor(String name) {
        return (Map<String, Double>) this.pokemonData.get(name).get("stats");
    }

    List<String> megasFor(String pokemon) {
        return this.namesMatching("Mega " + pokemon);
    }
}
