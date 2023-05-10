package com.example.lostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lostandfound.data.DatabaseHelper;
import com.example.lostandfound.model.Post;

import java.util.Calendar;
import java.util.Locale;

public class CreatePost extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        EditText postName = findViewById(R.id.et_name);
        EditText phoneNumber = findViewById(R.id.et_phone);
        EditText postDescription = findViewById(R.id.multi_tv_description);
        EditText postDate = findViewById(R.id.et_date);
        EditText postLocation = findViewById(R.id.et_location);
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        Button createPost = findViewById(R.id.create_post);
        db = new DatabaseHelper(this);

        postDate.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(CreatePost.this,
                    (view, year, monthOfYear, dayOfMonth) -> {
                        String selectedDate = String.format(Locale.forLanguageTag("en-AU"), "%02d-%02d-%04d", dayOfMonth, monthOfYear + 1, year);
                        postDate.setText(selectedDate);
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        });

        createPost.setOnClickListener(view -> {
            String name = postName.getText().toString();
            String phone = phoneNumber.getText().toString();
            String description = postDescription.getText().toString();
            String state = getState(radioGroup);
            String date = postDate.getText().toString();
            String location = postLocation.getText().toString();
            String result = "";
            if (name.equals(""))
                postName.setError("Please enter name");
            else if (phone.equals(""))
                phoneNumber.setError("Please enter phone number");
            else if (description.equals(""))
                postDescription.setError("Please enter description");
            else if (date.equals(""))
                postDate.setError("Please enter date");
            else if (location.equals(""))
                postLocation.setError("Please enter location");
            else
                result = createPost(name, phone, description, state, date, location);
            Toast.makeText(CreatePost.this, result, Toast.LENGTH_LONG).show();
            finish();
        });
    }

    private String getState(RadioGroup radioGroup) {
        String selectedState;
        int checkedId = radioGroup.getCheckedRadioButtonId();
        if (checkedId == R.id.radio_lost)
            selectedState = "Lost";
        else
            selectedState = "Found";
        return selectedState;
    }

    private String createPost(String name, String phone, String description, String state, String date, String location) {
        long result = db.insertPost(new Post(name, phone, description, state, date, location));

        if (result > 0) return "Post has been created successfully..!";
        return "There was an error creating the post";
    }

}