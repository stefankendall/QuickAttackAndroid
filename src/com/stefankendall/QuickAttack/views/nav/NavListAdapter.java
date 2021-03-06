package com.stefankendall.QuickAttack.views.nav;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.widget.DrawerLayout;
import com.stefankendall.QuickAttack.App;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.PokemonListActivity;
import com.stefankendall.QuickAttack.views.lists.SimpleListAdapter;
import com.stefankendall.QuickAttack.views.my.MyPokemonListActivity;

public class NavListAdapter extends SimpleListAdapter {
    public NavListAdapter() {
        super();

        this.items.add(new NavListItem("All Pokemon", android.R.drawable.ic_menu_search, new NavAction() {
            @Override
            public void run(Activity context) {
                start(context, PokemonListActivity.class);
            }
        }));
        this.items.add(new NavListItem("My Pokemon", R.drawable.ic_15_tags2x, new NavAction() {
            @Override
            public void run(Activity context) {
                start(context, MyPokemonListActivity.class);
            }
        }));
        this.items.add(new NavListItem("Feedback", R.drawable.ic_09_chat_22x, new NavAction() {
            @Override
            public void run(Activity context) {
                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"pokemon@stefankendall.com"});
                PackageInfo info = null;
                try {
                    info = App.getContext().getPackageManager().getPackageInfo(App.getContext().getPackageName(), 0);
                } catch (PackageManager.NameNotFoundException ignored) {
                }
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Quick Attack Feedback - v" + info.versionName);

                context.startActivity(Intent.createChooser(emailIntent, "Send Feedback"));
            }
        }));
    }

    private void start(Activity context, Class activity) {
        if (!activity.isInstance(context)) {
            Intent intent = new Intent(context, activity);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }
        else {
            DrawerLayout drawerLayout = (DrawerLayout) context.findViewById(R.id.drawer_layout);
            drawerLayout.closeDrawers();
        }
    }
}