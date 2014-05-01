package com.stefankendall.QuickAttack.data;

import android.content.SharedPreferences;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.stefankendall.QuickAttack.App;

import java.util.List;

public class MyPokemonStore {
    static MyPokemonStore myPokemonStore;
    private List<String> pokemon;

    public MyPokemonStore() {
        this.pokemon = Lists.newArrayList();
    }

    public static MyPokemonStore instance() {
        if (myPokemonStore == null) {
            myPokemonStore = new MyPokemonStore();
        }
        return myPokemonStore;
    }

    public List<String> getPokemon() {
        return ImmutableList.copyOf(pokemon);
    }

    public void load() {
        SharedPreferences preferences = App.getContext().getSharedPreferences("MyPokemon", 0);
        String jsonString = preferences.getString("mypokemon", "[]");
        Gson gson = new Gson();
        this.pokemon = gson.fromJson(jsonString, List.class);
    }

    public void empty() {
        this.pokemon = Lists.newArrayList();
    }

    public List<String> all() {
        return Lists.newArrayList();
    }

    public void remove(String pokemon) {
        this.pokemon.remove(pokemon);
    }

    public void add(String pokemon) {
        if (!this.pokemon.contains(pokemon)) {
            this.pokemon.add(pokemon);
        }
    }

    public void save() {
        SharedPreferences preferences = App.getContext().getSharedPreferences("MyPokemon", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("mypokemon", "[" + Joiner.on(',').join(this.pokemon) + "]");
        editor.commit();
    }
}

