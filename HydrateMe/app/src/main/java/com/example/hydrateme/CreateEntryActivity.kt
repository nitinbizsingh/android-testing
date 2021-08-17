package com.example.hydrateme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "CreateEntryActivity"

class CreateEntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_entry)

        setTitle(R.string.create_entry)

        val addButton: View = findViewById(R.id.add_entry_button)
        val entryEditText: EditText = findViewById(R.id.intake_edit_text)
        addButton.setOnClickListener { view ->
            val intakeInMl = entryEditText.text.toString().toInt()
            val data = Intent()

            data.putExtra("intake", intakeInMl)
            setResult(RESULT_OK, data)
            finish()
        }
    }
}