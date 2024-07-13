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
import com.solux.flory.util.base.BindingActivity

class SelectCardActivity : BindingActivity<ActivitySelectCardBinding>(ActivitySelectCardBinding::inflate) {
    private val viewModel by viewModels<SendViewModel>()

    var selectedImageView: ImageView? = null
    lateinit var bouquetInfo: BouquetInfo
    var message: String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //message
        message = intent.getStringExtra("message")!!
        viewModel.setMessage(message)
        //bouquet
        bouquetInfo = (intent.getSerializableExtra("bouquet") as BouquetInfo?)!!
        viewModel.setBouquetInfo(bouquetInfo)

        initView()
        selectColor()
        sendPresent()

    }

    fun initView() {
        binding.bouquetImg.load(bouquetInfo.imageUrl)
        binding.cardMessage.text = viewModel.message.value.toString()
        // peach 로 기본 설정
        setImageView(binding.selectPeach)
    }

    fun selectColor() {

        // peach
        binding.selectPeach.setOnClickListener {
            if(selectedImageView != binding.selectPeach) {
                setImageView(binding.selectPeach)
                binding.ivCard.setImageResource(R.drawable.ic_card_peach)
                viewModel.setCardColor("peach")
            }
        }
        // gray
        binding.selectGray.setOnClickListener {
            if(selectedImageView != binding.selectGray) {
                setImageView(binding.selectGray)
                binding.ivCard.setImageResource(R.drawable.ic_card_gray)
                viewModel.setCardColor("gray")
            }
        }
        // blue
        binding.selectBlue.setOnClickListener {
            if(selectedImageView != binding.selectBlue) {
                setImageView(binding.selectBlue)
                binding.ivCard.setImageResource(R.drawable.ic_card_blue)
                viewModel.setCardColor("blue")
            }
        }
        // purple
        binding.selectPurple.setOnClickListener {
            if(selectedImageView != binding.selectPurple) {
                setImageView(binding.selectPurple)
                binding.ivCard.setImageResource(R.drawable.ic_card_purple)
                viewModel.setCardColor("purple")
            }
        }
        // yellow
        binding.selectYellow.setOnClickListener {
            if(selectedImageView != binding.selectYellow) {
                setImageView(binding.selectYellow)
                binding.ivCard.setImageResource(R.drawable.ic_card_yellow)
                viewModel.setCardColor("yellow")
            }
        }

    }

    fun setImageView(currentImageView: ImageView) {

        selectedImageView?.run {
            isSelected = false
            // width, height
            layoutParams.width = resources.getDimensionPixelSize(R.dimen.unselected_width)
            layoutParams.height = resources.getDimensionPixelSize(R.dimen.unselected_height)
            // margin
            val marginLayoutParams = layoutParams as ViewGroup.MarginLayoutParams
            marginLayoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.unselected_margin)
            requestLayout()
        }

        currentImageView.run {
            isSelected = true
            //width, height
            layoutParams.width = resources.getDimensionPixelSize(R.dimen.selected_width)
            layoutParams.height = resources.getDimensionPixelSize(R.dimen.selected_height)
            // margin
            val marginLayoutParams = layoutParams as ViewGroup.MarginLayoutParams
            marginLayoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.selected_margin)
            requestLayout()
        }

        selectedImageView = currentImageView
    }

    fun sendPresent() {
        binding.goNextBtn.setOnClickListener {
            val intent = Intent(this, SendCompleteActivity::class.java).apply {
                putExtra("bouquet", bouquetInfo)
            }
            startActivity(intent)
        }
    }
}