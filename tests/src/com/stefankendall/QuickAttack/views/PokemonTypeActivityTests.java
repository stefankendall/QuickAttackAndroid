package com.stefankendall.QuickAttack.views;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.LinearLayout;
import com.stefankendall.QuickAttack.data.DataLoader;
import junit.framework.Assert;

public class PokemonTypeActivityTests extends ActivityInstrumentationTestCase2<PokemonTypeViewActivity> {
    public PokemonTypeActivityTests() {
        super(PokemonTypeViewActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        new DataLoader().load();
    }

    public void testHidesSectionsWithoutData() {
        Intent intent = new Intent();
        intent.putExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME, "Amaura");
        setActivityIntent(intent);

        PokemonTypeViewFragment fragment = (PokemonTypeViewFragment) getActivity().fragment;
        LinearLayout superEffective = (LinearLayout) fragment.getView().findViewById(com.stefankendall.QuickAttack.R.id.type_super_effective);
        LinearLayout notEffective = (LinearLayout) fragment.getView().findViewById(com.stefankendall.QuickAttack.R.id.type_not_effective);
        LinearLayout immune = (LinearLayout) fragment.getView().findViewById(com.stefankendall.QuickAttack.R.id.type_immune);

        Assert.assertEquals(superEffective.getVisibility(), LinearLayout.VISIBLE);
        Assert.assertEquals(notEffective.getVisibility(), LinearLayout.VISIBLE);
        Assert.assertEquals(immune.getVisibility(), LinearLayout.GONE);
    }
}
