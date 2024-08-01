package com.solux.flory.presentation.record

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.fragment.findNavController
import coil.load
import com.solux.flory.R
import com.solux.flory.databinding.FragmentModifyBinding
import com.solux.flory.presentation.date.DateFragment.Companion.DATE_KEY
import com.solux.flory.presentation.date.DateInfo
import com.solux.flory.presentation.record.FlowerDialogFragment.Companion.FLOWER_KEY
import com.solux.flory.util.UiState
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.fragment.toast
import com.solux.flory.util.setupToolbarClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import java.time.LocalDate

@AndroidEntryPoint
class ModifyFragment : BindingFragment<FragmentModifyBinding>(FragmentModifyBinding::inflate) {
    private val modifyViewModel by viewModels<ModifyViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initView()
        modifyFlowerAreaClick()
        confirmBtnClick()
        cancelBtnClick()
        observePatchDiaryState()
    }

    private fun observePatchDiaryState() {
        modifyViewModel.patchDiaryState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Loading -> Unit
                is UiState.Success -> {
                    toast(stringOf(R.string.tv_modify_complete))
                    navigateToDateFragment()
                }

                is UiState.Empty -> Unit
                is UiState.Failure -> Unit
            }
        }
    }

    private fun initToolbar() {
        with(binding.toolbarModify) {
            tvToolbarTitle.text = stringOf(R.string.tv_modify_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    private fun initView() {
        val date = arguments?.getSerializable(DATE_KEY) as DateInfo
        val now = LocalDate.now()
        with(binding) {
            tvModifyDate.text = "${date.year}. ${date.month}. ${date.dayOfMonth}"
            ivModifyFlowerAvatar.load(date.imageUrl)
            if (now.year == date.year && now.monthValue == date.month && now.dayOfMonth == date.dayOfMonth) {
                btnModifyConfirm.visibility = View.VISIBLE
                etModifyTitle.isEnabled = true
                etModifyContent.isEnabled = true
            } else {
                btnModifyConfirm.visibility = View.INVISIBLE
                etModifyTitle.isEnabled = false
                etModifyContent.isEnabled = false
            }
            // 추후 꽃 이름과 의미 넣기
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val flower = data?.getSerializableExtra(FLOWER_KEY) as Flower
            with(binding) {
                ivModifyFlowerAvatar.load(flower.imageUrl)
                tvModifyFlowerMeaning.text = flower.meaning
                tvModifyFlowerName.text = flower.name
            }
        }
    }

    private fun confirmBtnClick() {
        binding.btnModifyConfirm.setOnClickListener {
            with(binding) {
                modifyViewModel.patchDiary(
                    1,
                    tvModifyFlowerName.text.toString(),
                    etModifyTitle.text.toString(),
                    etModifyContent.text.toString()
                )
            }
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
