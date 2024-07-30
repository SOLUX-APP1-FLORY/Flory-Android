package com.solux.flory.presentation.gift.send

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.viewModels
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.ActivitySelectCardBinding
import com.solux.flory.presentation.gift.send.viewModel.SendViewModel
import com.solux.flory.presentation.main.MainActivity
import com.solux.flory.util.base.BindingActivity
import com.solux.flory.util.context.stringOf
import com.solux.flory.util.setupToolbarClickListener

class SelectCardActivity : BindingActivity<ActivitySelectCardBinding>(ActivitySelectCardBinding::inflate) {
    private val viewModel by viewModels<SendViewModel>()

//    var selectedImageView: ImageView? = null
    lateinit var bouquetInfo: BouquetInfo
    var message: String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //message
        message = intent.getStringExtra(MESSAGE)!!
        viewModel.setMessage(message)
        //bouquet
        bouquetInfo = (intent.getSerializableExtra(FLOWER_KEY) as BouquetInfo?)!!
        viewModel.setBouquetInfo(bouquetInfo)

        initView()
        initToolbar()
        selectColor()
        sendPresent()
    }

    fun initView() {
        binding.ivBouquet.load(bouquetInfo.imageUrl)
        binding.tvCardMessage.text = viewModel.message.value.toString()
        // peach 로 기본 설정
        viewModel.setImageView(binding.ivSelectPeach)
    }

    private fun initToolbar() {
        with(binding.toolbarSelectCard) {
            tvToolbarTitle.text = stringOf(com.solux.flory.R.string.tv_gift_toolbar_title)
            setupToolbarClickListener(ibToolbar2LeftIcon)
        }
    }


    fun selectColor() {

        initPeachClickListener()
        initGrayClickListener()
        initBlueClickListener()
        initPurpleClickListener()
        initYellowClickListener()

    }

    fun initPeachClickListener() {
        // peach
        binding.ivSelectPeach.setOnClickListener {
            if(viewModel.selectedImageView != binding.ivSelectPeach) {
                viewModel.setImageView(binding.ivSelectPeach)
                binding.ivCard.setImageResource(R.drawable.ic_card_peach)
                viewModel.setCardColor("peach")
            }
        }
    }

    fun initGrayClickListener() {
        // gray
        binding.ivSelectGray.setOnClickListener {
            if(viewModel.selectedImageView != binding.ivSelectGray) {
                viewModel.setImageView(binding.ivSelectGray)
                binding.ivCard.setImageResource(R.drawable.ic_card_gray)
                viewModel.setCardColor("gray")
            }
        }
    }

    fun initBlueClickListener() {
        // blue
        binding.ivSelectBlue.setOnClickListener {
            if(viewModel.selectedImageView != binding.ivSelectBlue) {
                viewModel.setImageView(binding.ivSelectBlue)
                binding.ivCard.setImageResource(R.drawable.ic_card_blue)
                viewModel.setCardColor("blue")
            }
        }
    }

    fun initPurpleClickListener() {
        // purple
        binding.ivSelectPurple.setOnClickListener {
            if(viewModel.selectedImageView != binding.ivSelectPurple) {
                viewModel.setImageView(binding.ivSelectPurple)
                binding.ivCard.setImageResource(R.drawable.ic_card_purple)
                viewModel.setCardColor("purple")
            }
        }
    }

    fun initYellowClickListener() {
        // yellow
        binding.ivSelectYellow.setOnClickListener {
            if(viewModel.selectedImageView != binding.ivSelectYellow) {
                viewModel.setImageView(binding.ivSelectYellow)
                binding.ivCard.setImageResource(R.drawable.ic_card_yellow)
                viewModel.setCardColor("yellow")
            }
        }
    }

    fun sendPresent() {
        binding.btnSelectCardNext.setOnClickListener {
            Intent(this, SendCompleteActivity::class.java).apply {
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