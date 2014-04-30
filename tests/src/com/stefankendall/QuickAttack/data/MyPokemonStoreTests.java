package com.stefankendall.QuickAttack.data;

import android.test.AndroidTestCase;
import junit.framework.Assert;

public class MyPokemonStoreTests extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        MyPokemonStore.instance().load();
        MyPokemonStore.instance().empty();
    }

    public void testCanAdd() {
        String pokemon = "Charizard";
        MyPokemonStore.instance().add(pokemon);
        MyPokemonStore.instance().getPokemon().contains(pokemon);
    }

    public void testDoesNotAddDuplciates() {
        String pokemon = "Charizard";
        MyPokemonStore.instance().add(pokemon);
        MyPokemonStore.instance().add(pokemon);
        Assert.assertEquals(MyPokemonStore.instance().getPokemon().size(), 1);
    }

    public void testCanRemove() {
        MyPokemonStore.instance().add("Charizard X");
        MyPokemonStore.instance().add("Charizard Y");
        MyPokemonStore.instance().add("Charizard Z");
        MyPokemonStore.instance().remove("Charizard Z");
        Assert.assertTrue(MyPokemonStore.instance().getPokemon().contains("Charizard X"));
        Assert.assertTrue(MyPokemonStore.instance().getPokemon().contains("Charizard Y"));
    }
}
