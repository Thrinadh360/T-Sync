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

import org.telegram.csync.core.utils.DeviceInfo;
import org.telegram.csync.core.utils.Validation;
import org.telegram.csync.models.RegisterRequest;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;

public class CSyncRegistrationActivity extends BaseFragment {

    private EditText etName;
    private EditText etMobile;
    private EditText etEmail;
    private EditText etCollegeId;
    private EditText etCollege;

    private Spinner spRole;
    private Spinner spDepartment;
    private Spinner spYear;

    private TextView txtDevice;

    private Button btnRegister;

    @Override
    public View createView(Context context) {

        fragmentView = LayoutInflater.from(context)
                .inflate(R.layout.activity_csync_registration, null);

        //-------------------------
        // EditTexts
        //-------------------------

        etName = fragmentView.findViewById(R.id.etName);
        etMobile = fragmentView.findViewById(R.id.etMobile);
        etEmail = fragmentView.findViewById(R.id.etEmail);
        etCollegeId = fragmentView.findViewById(R.id.etCollegeId);
        etCollege = fragmentView.findViewById(R.id.etCollege);

        //-------------------------
        // Spinners
        //-------------------------

        spRole = fragmentView.findViewById(R.id.spRole);
        spDepartment = fragmentView.findViewById(R.id.spDepartment);
        spYear = fragmentView.findViewById(R.id.spYear);

        //-------------------------
        // Device Text
        //-------------------------

        txtDevice = fragmentView.findViewById(R.id.txtDevice);

        //-------------------------
        // Register Button
        //-------------------------

        btnRegister = fragmentView.findViewById(R.id.btnRegister);

        //------------------------------------------------
        // Role Spinner
        //------------------------------------------------

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

        //------------------------------------------------
        // Department Spinner
        //------------------------------------------------

        String[] departments = {
                "Computer Science",
                "Artificial Intelligence",
                "Commerce",
                "Physics",
                "Chemistry",
                "Mathematics",
                "English",
                "Other"
        };

        ArrayAdapter<String> departmentAdapter =
                new ArrayAdapter<>(
                        context,
                        android.R.layout.simple_spinner_dropdown_item,
                        departments
                );

        spDepartment.setAdapter(departmentAdapter);

        //------------------------------------------------
        // Year Spinner
        //------------------------------------------------

        String[] years = {
                "I Year",
                "II Year",
                "III Year",
                "PG",
                "Faculty",
                "Staff"
        };

        ArrayAdapter<String> yearAdapter =
                new ArrayAdapter<>(
                        context,
                        android.R.layout.simple_spinner_dropdown_item,
                        years
                );

        spYear.setAdapter(yearAdapter);

        //------------------------------------------------
        // Device Information
        //------------------------------------------------

        String deviceName = Build.MANUFACTURER + " " + Build.MODEL;
        txtDevice.setText(deviceName);

        //------------------------------------------------
        // Register Button
        //------------------------------------------------

        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String mobile = etMobile.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String collegeId = etCollegeId.getText().toString().trim();
            String college = etCollege.getText().toString().trim();

            String role = spRole.getSelectedItem().toString();
            String department = spDepartment.getSelectedItem().toString();
            String year = spYear.getSelectedItem().toString();

            //-------------------------
            // Validation
            //-------------------------

            if (Validation.isEmpty(name)) {
                etName.setError("Enter your full name");
                etName.requestFocus();
                return;
            }

            if (!Validation.isValidMobile(mobile)) {
                etMobile.setError("Enter a valid mobile number");
                etMobile.requestFocus();
                return;
            }

            if (!Validation.isValidEmail(email)) {
                etEmail.setError("Enter a valid email");
                etEmail.requestFocus();
                return;
            }

            if (Validation.isEmpty(collegeId)) {
                etCollegeId.setError("Enter Student / Employee ID");
                etCollegeId.requestFocus();
                return;
            }

            if (Validation.isEmpty(college)) {
                etCollege.setError("Enter College Name");
                etCollege.requestFocus();
                return;
            }

            //-------------------------
            // Create Request Object
            //-------------------------

            RegisterRequest request = new RegisterRequest();

            request.fullName = name;
            request.mobile = mobile;
            request.email = email;

            request.collegeId = collegeId;

            request.role = role;
            request.department = department;
            request.year = year;

            request.deviceId = DeviceInfo.getAndroidId(context);
            request.deviceName = DeviceInfo.getDeviceName();

            request.platform = DeviceInfo.getPlatform();
            request.appVersion = "1.0";

            //-------------------------
            // Temporary
            //-------------------------

            Toast.makeText(
                    context,
                    "Registration request prepared successfully.",
                    Toast.LENGTH_LONG
            ).show();

            // Next Phase:
            // UserRepository.register(request);
        });

        return fragmentView;
    }
}