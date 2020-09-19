package com.nikasov.animationplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.nikasov.animationplayground.databinding.ActivityMainBinding
import com.nikasov.animationplayground.ui.plus_anim.activity.PlusStartActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {
        binding.onClick = this
    }

    override fun onClick(v: View?) {
        when (v) {
            plusAnimation -> {
                val intent = Intent(this, PlusStartActivity::class.java)
                intent.apply {
                    startActivity(this)
                }
            }
        }
    }
}