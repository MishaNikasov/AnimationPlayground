package com.nikasov.animationplayground.ui.plus_anim.activity

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nikasov.animationplayground.R
import com.nikasov.animationplayground.databinding.ActivityPlusStartBinding
import com.nikasov.animationplayground.ui.plus_anim.adapter.HeaderImageAdapter

class PlusStartActivity : AppCompatActivity() {

    private lateinit var binging: ActivityPlusStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = DataBindingUtil.setContentView(this, R.layout.activity_plus_start)
        setupViews()
    }

    private fun setupViews() {

        val interaction = object : HeaderImageAdapter.Interaction {
            override fun onItemSelected(position: Int, item: String, view: View) {
                val intent = Intent(applicationContext, PlusEndActivity::class.java)
                intent.putExtra("image", item)
                val options =
                    ActivityOptions.makeSceneTransitionAnimation(
                        this@PlusStartActivity,
                        Pair.create(view, "image_transition")
                    )
                intent.apply {
                    startActivity(this, options.toBundle())
                }
            }
        }

        binging.list = getImageList()
        binging.interaction = interaction
    }

    private fun getImageList(): MutableList<String>? {
        val imageList = arrayListOf<String>()
        imageList.apply {
            add("https://images.unsplash.com/photo-1600284858934-d05fde407182?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=25")
            add("https://images.unsplash.com/photo-1600226281056-6a85c8e8e212?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1489&q=25")
            add("https://images.unsplash.com/photo-1600110099493-db8e356ed121?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1351&q=25")
            add("https://images.unsplash.com/photo-1599929030406-9eb77b536798?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=25")
        }
        return imageList
    }
}