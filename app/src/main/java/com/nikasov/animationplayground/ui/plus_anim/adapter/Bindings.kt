package com.nikasov.animationplayground.ui.plus_anim.adapter

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.nikasov.animationplayground.R

@BindingAdapter("glide")
fun ImageView.glide(image: String){
    Glide
        .with(this.context)
        .load(image)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .error(ContextCompat.getDrawable(this.context, R.drawable.ic_error))
        .placeholder(android.R.color.white)
        .centerCrop()
        .into(this)
}

@BindingAdapter("image_adapter", "image_interaction")
fun RecyclerView.setImageAdapter(list: List<String>, interaction: HeaderImageAdapter.Interaction){
    val imageAdapter = HeaderImageAdapter(interaction)
    imageAdapter.submitList(list)
    val linearLayoutManager = LinearLayoutManager(context)
    linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
    this.apply {
        adapter = imageAdapter
        layoutManager = linearLayoutManager
    }
}