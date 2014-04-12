package com.stefankendall.QuickAttack.views;

import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.stefankendall.QuickAttack.SingleFragmentActivity;
import com.stefankendall.QuickAttack.data.DataLoader;
import com.stefankendall.QuickAttack.views.PokemonListFragment;

public class PokemonListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new PokemonListFragment();
    }
}
