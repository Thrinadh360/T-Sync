package org.telegram.csync.ui.auth;

import android.content.Context;
import android.widget.TextView;

import org.telegram.ui.ActionBar.BaseFragment;

public class CSyncRegistrationActivity extends BaseFragment {

    @Override
    public android.view.View createView(Context context) {

        TextView tv = new TextView(context);

        tv.setText("C-Sync Registration");

        fragmentView = tv;

        return fragmentView;
    }
}