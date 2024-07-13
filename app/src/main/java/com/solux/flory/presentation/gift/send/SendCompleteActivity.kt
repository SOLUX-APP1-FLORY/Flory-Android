package com.solux.flory.presentation.gift.send

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ActivitySendCompleteBinding
import com.solux.flory.presentation.main.MainActivity
import com.solux.flory.util.base.BindingActivity

class SendCompleteActivity : BindingActivity<ActivitySendCompleteBinding>(ActivitySendCompleteBinding::inflate) {
    lateinit var bouquetInfo: BouquetInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //bouquet
        bouquetInfo = (intent.getSerializableExtra("bouquet") as BouquetInfo?)!!
        binding.bouquetImg.load(bouquetInfo.imageUrl)

        binding.goNextBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("gotoFragment", "GiftFragment")
            }
            startActivity(intent)
        }

    }
}