package com.example.lateentryproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Table::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PicDatabase : RoomDatabase() {
	abstract fun myDao(): MyDao

//	companion object {
//		@Volatile
//		private var INSTANCE: PicDatabase? = null
//
//		fun getDatabase(context: Context): PicDatabase =
//			INSTANCE ?: synchronized(this) {
//				INSTANCE
//					?: buildDatabase(context).also { INSTANCE = it }
//			}
//
//		private fun buildDatabase(context: Context) =
//			Room.databaseBuilder(
//				context.applicationContext, PicDatabase::class.java, "picDB").build()
//	}
}