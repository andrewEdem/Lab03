package edu.calvin.akg8.lab03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.SharedPreferences;
import android.widget.TextView.OnEditorActionListener;


/* Lab 3
*CS-262
* @author: Andrew Gbeddy
* @version: 1.0 (Fall 2016)
 */

public class PasswordActivity extends AppCompatActivity {

    // Declare variables for widgets
    private EditText passwordEditText;
    private TextView invalidTextView;
    private ImageView imageAndroid;

    // Define instance variables
    private String passwordString = "";
    private String correctPassword = "lab3";

    // Define SharedPreferences object
    private SharedPreferences savedValues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        invalidTextView = (TextView) findViewById(R.id.invalidTextView);
        invalidTextView.setVisibility(View.GONE);
        imageAndroid = (ImageView) findViewById(R.id.imageAndroid);
        imageAndroid.setVisibility(View.GONE);

        // Implement the listener
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                passwordString = passwordEditText.getText().toString();
                if (passwordString.equals(correctPassword)) {
                    imageAndroid.setVisibility(View.VISIBLE);
                    invalidTextView.setVisibility(View.GONE);
                } else {
                    imageAndroid.setVisibility(View.GONE);
                    invalidTextView.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
    }
}

