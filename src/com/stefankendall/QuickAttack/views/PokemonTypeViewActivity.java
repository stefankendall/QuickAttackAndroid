package com.stefankendall.QuickAttack.views;

import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.stefankendall.QuickAttack.SingleFragmentActivity;

public class PokemonTypeViewActivity extends SingleFragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(getIntent().getStringExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME));
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment createFragment() {
        return PokemonTypeViewFragment.newInstance(getIntent().getStringExtra(PokemonTypeViewFragment.EXTRA_POKEMON_NAME));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
