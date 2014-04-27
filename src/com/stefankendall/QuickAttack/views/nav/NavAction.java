package com.stefankendall.QuickAttack.views.nav;

import android.content.Context;
import android.content.Intent;

public class NavAction {
    public void run(Context context) {
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"to@email.com"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");

        context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }
}