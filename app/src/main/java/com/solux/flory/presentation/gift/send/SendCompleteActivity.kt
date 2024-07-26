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
    lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // bouquet
        bouquetInfo = (intent.getSerializableExtra("FLOWER_KEY") as? BouquetInfo)!!
        // name
        userName = "userName" // 선물페이지2에서 받아서 연결

        binding.ivBouquet.load(bouquetInfo.imageUrl)
        binding.tvCompleteMessage.text = getString(R.string.send_complete, userName)

        binding.btnGoNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("GOTO_FRAGMENT", "GIFT_FRAGMENT")
            }
            startActivity(intent)
        }

    }
}