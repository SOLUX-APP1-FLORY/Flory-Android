package com.solux.flory.presentation.date

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil.setContentView
import com.solux.flory.R
import com.solux.flory.databinding.ActivitySelectFlowerBinding
import com.solux.flory.util.base.BindingActivity

class SelectFlowerActivity : BindingActivity<ActivitySelectFlowerBinding>({
    ActivitySelectFlowerBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}