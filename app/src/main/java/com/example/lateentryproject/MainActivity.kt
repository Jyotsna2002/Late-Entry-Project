package com.example.lateentryproject

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.room.Room
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.lateentryproject.UI.Fragment.Login
import com.example.lateentryproject.databinding.ActivityMainBinding
import com.example.lateentryproject.UI.FrontPageFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, FrontPageFragment())
        transaction.commit()

		AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

		database = Room.databaseBuilder(applicationContext, PicDatabase::class.java, "picDB")
			.build()

		supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Login())
			.commit()
		binding.apply {
//			try {
//				val field = CursorWindow::class.java.getDeclaredField("sCursorWindowSize")
//				field.isAccessible = true
//				field.set(null, 100 * 1024 * 1024) //the 100MB is the new size
//			} catch (e: Exception) {
//				e.printStackTrace()
//			}
//			GlobalScope.launch {
//				val pic = Table(getBitmap())
//				database.myDao().insertPic(pic)
//			}

//			recyclerView.isNestedScrollingEnabled = false
//			database.myDao().getPics().observe(this@MainActivity) {
//				adapter = RecyclerAdapter(it)
//				recyclerView.adapter = adapter
			}
		}
	}

//	private suspend fun getBitmap(): Bitmap {
//		val loading = ImageLoader(this)
//		val request = ImageRequest.Builder(this)
//			.data("https://firebasestorage.googleapis.com/v0/b/si-project-1640520939795.appspot.com/o/87.jpg?alt=media&token=51dcb2cb-792b-4b29-93af-634e2a74e5b2")
//			.build()
//
//		val result = (loading.execute(request) as SuccessResult).drawable
//		val bm = (result as BitmapDrawable).bitmap
//		val compressedBm = Bitmap.createScaledBitmap(bm, 300, 300, false)
//		Log.e("aaaa", compressedBm.byteCount.toString())
//		bm.recycle()
//		return compressedBm
//	}