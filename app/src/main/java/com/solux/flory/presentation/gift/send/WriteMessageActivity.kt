package com.solux.flory.presentation.gift.send

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ActivityWriteMessageBinding
import com.solux.flory.presentation.gift.send.viewModel.SendViewModel
import com.solux.flory.presentation.main.MainActivity
import com.solux.flory.util.base.BindingActivity

class WriteMessageActivity : BindingActivity<ActivityWriteMessageBinding>({
    ActivityWriteMessageBinding.inflate(it)
}) {
    lateinit var bouquetInfo: BouquetInfo
    private val viewModel by viewModels<SendViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        gotoNext()
        gotoBack()
    }

    fun initView() {
        bouquetInfo = (intent.getSerializableExtra("FLOWER_KEY") as BouquetInfo?)!!

        binding.ivBouquet.load(bouquetInfo.imageUrl)
        binding.tvBouquetName.text = bouquetInfo.name
        binding.tvBouquetMeaning.text = bouquetInfo.meaning
    }

    fun gotoNext() {
        binding.btnGoNext.setOnClickListener {
            Intent(this, SelectCardActivity::class.java).apply {
                putExtra("MESSAGE", binding.etGiftMessage.text.toString())
                putExtra("FLOWER_KEY", bouquetInfo)
                startActivity(this)
            }
        }
    }

    fun gotoBack() {
        binding.btnGoBack.setOnClickListener {
            finish()
        }
        binding.btnClose.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                putExtra("GOTO_FRAGMENT", "GIFT_FRAGMENT")
                startActivity(this)
            }
        }
    }
}