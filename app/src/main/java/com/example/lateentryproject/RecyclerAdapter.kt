package com.example.lateentryproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lateentryproject.databinding.PhotoListBinding

class RecyclerAdapter(private val pics: List<Table>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

	inner class ViewHolder(val binding: PhotoListBinding) : RecyclerView.ViewHolder(binding.root)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(PhotoListBinding.inflate(LayoutInflater.from(parent.context), parent,
												   false))
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.binding.apply {
			pic.load(pics[position].pic)
			id.text = pics[position].id.toString()
		}
	}

	override fun getItemCount(): Int {
		return pics.size
	}
}