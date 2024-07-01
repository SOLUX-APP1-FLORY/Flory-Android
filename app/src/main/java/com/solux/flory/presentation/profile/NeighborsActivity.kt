package com.solux.flory.presentation.profile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.solux.flory.R
import com.solux.flory.databinding.ActivityNeighborsBinding
import com.solux.flory.util.base.BindingActivity

class NeighborsActivity : BindingActivity<ActivityNeighborsBinding>({
    ActivityNeighborsBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}