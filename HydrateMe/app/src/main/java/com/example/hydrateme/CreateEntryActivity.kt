package com.example.hydrateme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

private const val TAG = "CreateEntryActivity"

class CreateEntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_entry)

        setTitle(R.string.create_entry)

        val addButton: View = findViewById(R.id.add_entry_button)
        val entryEditText: EditText = findViewById(R.id.intake_edit_text)
        addButton.setOnClickListener { view ->
            Snackbar.make(view, resources.getText(R.string.saved), Snackbar.LENGTH_LONG)
                .show()

            val intakeInMl = entryEditText.text.toString().toInt()
            Log.d(TAG, intakeInMl.toString() + " ml")
        }
    }
}