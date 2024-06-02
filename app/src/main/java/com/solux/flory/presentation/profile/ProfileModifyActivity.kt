package com.solux.flory.presentation.profile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.solux.flory.R
import com.solux.flory.databinding.ActivityProfileModifyBinding

class ProfileModifyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileModifyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileModifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        leftArrowClick()
    }

    private fun leftArrowClick() {
        binding.ivModifyLeftArrow.setOnClickListener {
            finish()
        }
    }
}