package com.stefankendall.QuickAttack.views.stats;

import android.app.Fragment;
import android.os.Bundle;
import com.stefankendall.QuickAttack.SingleFragmentActivity;
import com.stefankendall.QuickAttack.views.type.PokemonTypeViewFragment;

public class PokemonStatsActivity extends SingleFragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    protected Fragment createFragment() {
        return PokemonStatsFragment.newInstance(getIntent().getStringExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME));
    }
}
