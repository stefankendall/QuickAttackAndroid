package com.stefankendall.QuickAttack.views;

import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.stefankendall.QuickAttack.SingleFragmentActivity;
import com.stefankendall.QuickAttack.data.DataLoader;
import com.stefankendall.QuickAttack.views.PokemonListFragment;

public class PokemonListActivity extends SingleFragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Crashlytics.start(this);
    }

    @Override
    protected Fragment createFragment() {
        return new PokemonListFragment();
    }
}
