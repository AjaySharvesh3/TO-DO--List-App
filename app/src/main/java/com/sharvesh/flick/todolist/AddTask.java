package com.sharvesh.flick.todolist;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sharvesh.flick.todolist.Database.TaskContract;

public class AddTask extends AppCompatActivity {

    // Declare a member variable to keep track of a task's selected mPriority
    private int mPriority;
    Button addButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        addButton = findViewById(R.id.addButton);

        // Initialize to highest mPriority by default (mPriority = 1)
        ((RadioButton) findViewById(R.id.radButton1)).setChecked(true);
        mPriority = 1;


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Not yet implemented
                // Check if EditText is empty, if not retrieve input and store it in a ContentValues object
                // If the EditText input is empty -> don't create an entry
                String input = ((EditText) findViewById(R.id.editTextTaskDescription)).getText().toString();
                if (input.length() == 0) {
                    return;
                }

                // Insert new task data via a ContentResolver
                // Create new empty ContentValues object
                ContentValues contentValues = new ContentValues();
                // Put the task description and selected mPriority into the ContentValues
                contentValues.put(TaskContract.TaskEntryData.DESCRIPTION, input);
                contentValues.put(TaskContract.TaskEntryData.PRIORITY, mPriority);
                // Insert the content values via a ContentResolver
                Uri uri = getContentResolver().insert(TaskContract.TaskEntryData.FULL_CONTENT_URI, contentValues);

                // Display the URI that's returned with a Toast
                // [Hint] Don't forget to call finish() to return to MainActivity after this insert is complete
                if(uri != null) {
                    Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
                }

                // Finish activity (this returns back to MainActivity)
                finish();

            }
        });
    }




    public void onPrioritySelected(View view) {
        if (((RadioButton) findViewById(R.id.radButton1)).isChecked()) {
            mPriority = 1;
        } else if (((RadioButton) findViewById(R.id.radButton2)).isChecked()) {
            mPriority = 2;
        } else if (((RadioButton) findViewById(R.id.radButton3)).isChecked()) {
            mPriority = 3;
        }
    }
}