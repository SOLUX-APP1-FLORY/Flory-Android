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
import com.solux.flory.util.context.stringOf
import com.solux.flory.util.setupToolbarClickListener

class WriteMessageActivity : BindingActivity<ActivityWriteMessageBinding>({
    ActivityWriteMessageBinding.inflate(it)
}) {
    lateinit var bouquetInfo: BouquetInfo
    private val viewModel by viewModels<SendViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initToolbar()
        gotoNext()
    }

    fun initView() {
        bouquetInfo = (intent.getSerializableExtra(FLOWER_KEY) as BouquetInfo?)!!

        binding.ivBouquet.load(bouquetInfo.imageUrl)
        binding.tvBouquetName.text = bouquetInfo.name
        binding.tvBouquetMeaning.text = bouquetInfo.meaning
    }

    private fun initToolbar() {
        with(binding.toolbarWriteMessage) {
            tvToolbarTitle.text = stringOf(com.solux.flory.R.string.tv_gift_toolbar_title)
            setupToolbarClickListener(ibToolbar2LeftIcon)
        }
    }

    fun gotoNext() {
        binding.btnGoNext.setOnClickListener {
            Intent(this, SelectCardActivity::class.java).apply {
                putExtra(MESSAGE, binding.etGiftMessage.text.toString())
                putExtra(FLOWER_KEY, bouquetInfo)
                startActivity(this)
            }
        }
    }


    companion object {
        const val FLOWER_KEY = "selectedFlower"
        const val MESSAGE = "message"
    }
}