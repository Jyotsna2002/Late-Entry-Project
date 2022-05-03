package com.example.lateentryproject

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table")
data class Table(
	val pic: Bitmap
) {
	@PrimaryKey(autoGenerate = true)
	var id: Long = 0L
}