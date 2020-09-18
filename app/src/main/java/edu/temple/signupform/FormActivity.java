package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    Button saveButton;
    EditText enterName,enterEmail,password,confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding fields using id
        enterName = findViewById(R.id.nameInput);
        enterEmail = findViewById(R.id.emailInput);
        password = findViewById(R.id.pw1Input);
        confirmPassword = findViewById(R.id.pw2Input);
        // Save Button
        saveButton = findViewById(R.id.saveButton);

        // Save Button Listener
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enterName.getText().toString().isEmpty() ||
                        enterEmail.getText().toString().isEmpty() ||
                        password.getText().toString().isEmpty() ||
                        confirmPassword.getText().toString().isEmpty()) {
                    Toast.makeText(FormActivity.this, "Must enter all information", Toast.LENGTH_LONG).show();
                    // If any field is empty then toast will display this message

                } else if(!password.getText().toString().equals(confirmPassword.getText().toString())) {
                    Toast.makeText(FormActivity.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                    // If passwords do not match then toast will display this message

                } else {
                    AlertDialog.Builder success = new AlertDialog.Builder(FormActivity.this);
                    success.setTitle("SUCCESS!");
                    success.setMessage("Welcome, " + enterName.getText() + " to the SignUpForm App!");
                    success.setCancelable(true);
                    success.show();
                    // Alert dialog box will open and welcome user by name when all fields have information and passwords match
                    // User can then click outside of dialog box to start over, setting false would disable
                }

                }
        });
    }
}