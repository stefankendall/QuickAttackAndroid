package com.stefankendall.QuickAttack.views;

import android.app.Fragment;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import com.stefankendall.QuickAttack.SingleFragmentActivity;

public class PokemonListActivity extends SingleFragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Crashlytics.start(this);
        getActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    protected Fragment createFragment() {
        return new PokemonListFragment();
    }
}
