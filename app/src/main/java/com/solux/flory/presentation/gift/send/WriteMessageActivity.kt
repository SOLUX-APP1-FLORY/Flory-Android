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

class WriteMessageActivity : AppCompatActivity() {
    lateinit var bouquetInfo: BouquetInfo
    lateinit var bindig: ActivityWriteMessageBinding
    private val viewModel by viewModels<SendViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = DataBindingUtil.setContentView(this, R.layout.activity_write_message)
        bindig.viewModel = viewModel
        bindig.lifecycleOwner = this

        initView()
        gotoNext()
    }

    fun initView() {
        bouquetInfo = (intent.getSerializableExtra("bouquet") as BouquetInfo?)!!

        bindig.bouquetImg.load(bouquetInfo.imageUrl)
        bindig.bouquetName.text = bouquetInfo.name
        bindig.bouquetMeaning.text = bouquetInfo.meaning
    }

    fun gotoNext() {
        bindig.goNextBtn.setOnClickListener {
            val intent = Intent(this, SelectCardActivity::class.java).apply {
                putExtra("message", viewModel.message.value)
                putExtra("bouquet", bouquetInfo)
            }
            startActivity(intent)
        }
    }
}