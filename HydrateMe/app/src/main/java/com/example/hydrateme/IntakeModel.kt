package com.example.hydrateme

import java.text.SimpleDateFormat

class IntakeModel {
    private val entries: MutableList<IntakeEntry> = ArrayList()

    fun addEntry(entry: IntakeEntry) {
        entries.add(entry)
    }

    fun getTodaysIntake(): Int {
        val today = formatDateString(System.currentTimeMillis())
        return getDailyEntries().get(today) ?: 0
    }

    fun isTodaysIntakeSufficient(): Boolean {
        return getTodaysIntake() >= 3000
    }

    fun getDailyEntries(): Map<String, Int> {
        var map: MutableMap<String, Int> = mutableMapOf<String, Int>()
        for(entry in entries) {
            val date = formatDateString(entry.timestamp)

            if(!map.containsKey(date)) {
                map.put(date, entry.intake)
            } else {
                map.put(date, map.get(date)!!.plus(entry.intake))
            }
        }
        return map
    }

    fun formatDateString(ts: Long): String {
        return SimpleDateFormat("dd MMM yyyy").format(ts)
    }
}