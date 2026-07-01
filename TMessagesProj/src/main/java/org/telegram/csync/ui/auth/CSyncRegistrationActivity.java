package org.telegram.csync.ui.auth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;

public class CSyncRegistrationActivity extends BaseFragment {

    private EditText etName;
    private EditText etMobile;
    private EditText etEmail;
    private EditText etCollegeId;

    private Spinner spRole;

    private Button btnRegister;

    @Override
    public View createView(Context context) {

        fragmentView = LayoutInflater.from(context)
                .inflate(R.layout.activity_csync_registration, null);

        etName = fragmentView.findViewById(R.id.etName);
        etMobile = fragmentView.findViewById(R.id.etMobile);
        etEmail = fragmentView.findViewById(R.id.etEmail);
        etCollegeId = fragmentView.findViewById(R.id.etCollegeId);

        spRole = fragmentView.findViewById(R.id.spRole);

        btnRegister = fragmentView.findViewById(R.id.btnRegister);

        String[] roles = {
                "Student",
                "Faculty",
                "HoD",
                "Parent",
                "Guest",
                "Alumni",
                "Developer"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        context,
                        android.R.layout.simple_spinner_dropdown_item,
                        roles
                );

        spRole.setAdapter(adapter);

        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String mobile = etMobile.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String role = spRole.getSelectedItem().toString();
            String collegeId = etCollegeId.getText().toString().trim();

            // API call will be added next.
        });

        return fragmentView;
    }
}