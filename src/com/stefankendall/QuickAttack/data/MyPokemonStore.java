package com.stefankendall.QuickAttack.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

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
}

