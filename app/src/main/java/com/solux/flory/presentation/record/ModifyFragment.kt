package com.solux.flory.presentation.record

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentModifyBinding
import com.solux.flory.presentation.date.DateInfo
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.fragment.toast
import com.solux.flory.util.setupToolbarClickListener

class ModifyFragment : BindingFragment<FragmentModifyBinding>(FragmentModifyBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initView()
        modifyFlowerAreaClick()
        confirmBtnClick()
        cancelBtnClick()
    }

    private fun initToolbar() {
        with(binding.toolbarModify) {
            tvToolbarTitle.text = stringOf(R.string.tv_modify_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    private fun initView() {
        val date = arguments?.getSerializable("date") as DateInfo
        binding.tvModifyDate.text = "2024. ${date.month}. ${date.dayOfWeek}"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val flower = data?.getSerializableExtra("flower") as Flower
            with(binding) {
                ivModifyFlowerAvatar.load(flower.imageUrl)
                tvModifyFlowerMeaning.text = flower.meaning
                tvModifyFlowerName.text = flower.name
            }
        }
    }

    private fun confirmBtnClick() {
        binding.btnModifyConfirm.setOnClickListener {
            toast("수정되었습니다.")
            navigateToDateFragment()
        }
    }

    private fun cancelBtnClick() {
        binding.btnModifyCancel.setOnClickListener {
            navigateToDateFragment()
        }
    }

    private fun modifyFlowerAreaClick() {
        binding.clModifyFlowerImage.setOnClickListener {
            val intent = Intent(requireActivity(), SelectFlowerActivity::class.java)
            startActivityForResult(intent, 0)
        }
    }

    private fun navigateToDateFragment() {
        findNavController().navigate(R.id.action_fragment_modify_to_fragment_date)
    }
}
