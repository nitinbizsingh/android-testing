package com.example.hydrateme

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val model = IntakeModel()

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intake: Int = result.data?.getIntExtra("intake", 0) ?: 0

            val intakeEntry = IntakeEntry(intake)
            model.addEntry(intakeEntry)

            updateTodaysTotal()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: View = findViewById(R.id.create_entry_fab)
        fab.setOnClickListener { view ->
            startForResult.launch(Intent(this@MainActivity, CreateEntryActivity::class.java))
        }

        updateTodaysTotal()
    }

    fun updateTodaysTotal() {
        val totalTextView: TextView = findViewById(R.id.total)
        val messageTextView: TextView = findViewById(R.id.message)
        val total = model.getTodaysIntake()
        val text = total.toString() + " ml"

        totalTextView.setText(text)

        if(model.isTodaysIntakeSufficient()) {
            totalTextView.setTextColor(Color.GREEN)
            messageTextView.setText(R.string.done)
        } else {
            totalTextView.setTextColor(Color.RED)
            messageTextView.setText(R.string.not_done)
        }
    }
}