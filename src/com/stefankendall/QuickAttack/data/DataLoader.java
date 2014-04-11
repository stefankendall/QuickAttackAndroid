package com.stefankendall.QuickAttack.data;

import android.util.Log;

import java.io.IOException;

public class DataLoader {
    public void load() {
        try {
            PokemonStore.instance().load();
        } catch (IOException e) {
            Log.e("DataLoader", "Could not load data");
        }
    }
}
