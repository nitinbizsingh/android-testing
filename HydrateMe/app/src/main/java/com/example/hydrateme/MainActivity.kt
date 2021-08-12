package com.example.hydrateme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: View = findViewById(R.id.create_entry_fab)
        fab.setOnClickListener { view ->
            startActivity(Intent(this@MainActivity,CreateEntryActivity::class.java))
        }
    }
}