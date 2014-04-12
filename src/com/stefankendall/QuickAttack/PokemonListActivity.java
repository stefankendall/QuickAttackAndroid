package com.stefankendall.QuickAttack;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import com.stefankendall.QuickAttack.data.DataLoader;
import com.stefankendall.QuickAttack.views.PokemonListFragment;

public class PokemonListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new PokemonListFragment();
    }
}
