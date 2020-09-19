package com.nikasov.animationplayground.ui.plus_anim.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nikasov.animationplayground.R
import com.nikasov.animationplayground.databinding.ActivityPlusEndBinding

class PlusEndActivity : AppCompatActivity() {

    private lateinit var bindings: ActivityPlusEndBinding

    private var image: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this, R.layout.activity_plus_end)
        getData()
        setupViews()
    }

    private fun getData() {
        image = intent.extras?.getString("image")
    }

    private fun setupViews() {
        bindings.image = image
    }
}