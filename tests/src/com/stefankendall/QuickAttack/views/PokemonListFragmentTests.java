package com.stefankendall.QuickAttack.views;

import android.test.ActivityInstrumentationTestCase2;
import com.stefankendall.QuickAttack.data.DataLoader;
import junit.framework.Assert;

public class PokemonListFragmentTests extends ActivityInstrumentationTestCase2<PokemonListActivity> {
    public PokemonListFragmentTests() {
        super(PokemonListActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        new DataLoader().load();
    }

    public void testHasPokemonInList() {
        PokemonListFragment fragment = (PokemonListFragment) getActivity().fragment;
        Assert.assertEquals(fragment.getListView().getItemAtPosition(0), "Abomasnow");
    }
}
