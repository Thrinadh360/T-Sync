package org.telegram.csync.ui.auth;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;

public class CSyncRegistrationActivity extends BaseFragment {

    private EditText etName;
    private EditText etMobile;
    private EditText etEmail;
    private EditText etCollegeId;

    private Spinner spRole;
    private Spinner spDepartment;
    private Spinner spYear;

    private TextView txtDevice;

    private Button btnRegister;

    @Override
    public View createView(Context context) {

        fragmentView = LayoutInflater.from(context)
                .inflate(R.layout.activity_csync_registration, null);

        // EditTexts
        etName = fragmentView.findViewById(R.id.etName);
        etMobile = fragmentView.findViewById(R.id.etMobile);
        etEmail = fragmentView.findViewById(R.id.etEmail);
        etCollegeId = fragmentView.findViewById(R.id.etCollegeId);

        // Spinners
        spRole = fragmentView.findViewById(R.id.spRole);
        spDepartment = fragmentView.findViewById(R.id.spDepartment);
        spYear = fragmentView.findViewById(R.id.spYear);

        // Device
        txtDevice = fragmentView.findViewById(R.id.txtDevice);

        // Button
        btnRegister = fragmentView.findViewById(R.id.btnRegister);

        // -----------------------
        // Role Spinner
        // -----------------------

        String[] roles = {
                "Student",
                "Faculty",
                "HoD",
                "Parent",
                "Guest",
                "Alumni",
                "Developer"
        };

        ArrayAdapter<String> roleAdapter =
                new ArrayAdapter<>(
                        context,
                        android.R.layout.simple_spinner_dropdown_item,
                        roles
                );

        spRole.setAdapter(roleAdapter);

        // -----------------------
        // Department Spinner
        // -----------------------

        String[] departments = {
                "Computer Science",
                "Artificial Intelligence",
                "Commerce",
                "Physics",
                "Chemistry",
                "Mathematics"
        };

        ArrayAdapter<String> deptAdapter =
                new ArrayAdapter<>(
                        context,
                        android.R.layout.simple_spinner_dropdown_item,
                        departments
                );

        spDepartment.setAdapter(deptAdapter);

        // -----------------------
        // Year Spinner
        // -----------------------

        String[] years = {
                "I Year",
                "II Year",
                "III Year",
                "PG"
        };

        ArrayAdapter<String> yearAdapter =
                new ArrayAdapter<>(
                        context,
                        android.R.layout.simple_spinner_dropdown_item,
                        years
                );

        spYear.setAdapter(yearAdapter);

        // -----------------------
        // Device Info
        // -----------------------

        String deviceName = Build.MANUFACTURER + " " + Build.MODEL;
        txtDevice.setText(deviceName);

        // -----------------------
        // Register Button
        // -----------------------

        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String mobile = etMobile.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String collegeId = etCollegeId.getText().toString().trim();

            String role = spRole.getSelectedItem().toString();
            String department = spDepartment.getSelectedItem().toString();
            String year = spYear.getSelectedItem().toString();

            if (name.isEmpty()) {
                etName.setError("Enter your full name");
                etName.requestFocus();
                return;
            }

            if (mobile.length() != 10) {
                etMobile.setError("Enter a valid 10-digit mobile number");
                etMobile.requestFocus();
                return;
            }

            if (email.isEmpty()) {
                etEmail.setError("Enter your email");
                etEmail.requestFocus();
                return;
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Invalid email address");
                etEmail.requestFocus();
                return;
            }

            if (collegeId.isEmpty()) {
                etCollegeId.setError("Enter Student / Employee ID");
                etCollegeId.requestFocus();
                return;
            }

            String message =
                    "Registration Details\n\n" +
                            "Name: " + name +
                            "\nRole: " + role +
                            "\nDepartment: " + department +
                            "\nYear: " + year +
                            "\nDevice: " + deviceName;

            Toast.makeText(context, message, Toast.LENGTH_LONG).show();

            // TODO:
            // Call C-Sync Registration API here.
            // POST https://api.csync.top/api/register
        });

        return fragmentView;
    }
}