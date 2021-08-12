package com.example.hydrateme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

private const val TAG = "CreateEntryActivity"

class CreateEntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_entry)

        setTitle(R.string.create_entry)

        val addButton: View = findViewById(R.id.add_entry_button)
        val entryEditText: EditText = findViewById(R.id.intake_edit_text)
        addButton.setOnClickListener { view ->
            Log.d(TAG, entryEditText.text.toString())
        }
    }
}