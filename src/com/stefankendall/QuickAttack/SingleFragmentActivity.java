package com.stefankendall.QuickAttack;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public abstract class SingleFragmentActivity extends Activity {
    public Fragment fragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("c9827968b82f4049f8e3ba902a642ead")
                .build();

        AdView adView = (AdView) findViewById(R.id.adView);
        adView.loadAd(adRequest);

        this.fragment = getFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (this.fragment == null) {
            this.fragment = createFragment();
            getFragmentManager().beginTransaction().add(R.id.fragmentContainer, this.fragment).commit();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected abstract Fragment createFragment();
}
