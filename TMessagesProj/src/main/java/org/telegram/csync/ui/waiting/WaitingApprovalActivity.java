package org.telegram.csync.ui.waiting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;

public class WaitingApprovalActivity extends BaseFragment {

    @Override
    public View createView(Context context) {

        fragmentView = LayoutInflater
                .from(context)
                .inflate(
                        R.layout.activity_waiting_approval,
                        null
                );

        return fragmentView;
    }
}