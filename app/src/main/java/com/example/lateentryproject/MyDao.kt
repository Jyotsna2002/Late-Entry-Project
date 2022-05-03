package com.example.lateentryproject

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MyDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertPic(pic: Table)

	@Query("SELECT * FROM `table` ORDER BY id ASC")
	fun getPics(): LiveData<List<Table>>

	@Delete
	suspend fun deletePic(pic: Table)
}