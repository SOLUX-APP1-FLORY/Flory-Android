package com.solux.flory.presentation.profile

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentProfileModifyBinding
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.setupToolbarClickListener

class ProfileModifyFragment : BindingFragment<FragmentProfileModifyBinding>({
    FragmentProfileModifyBinding.inflate(it)
}) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        maleSelected()
        femaleSelected()
        modifyBtnClick()
    }

    private fun initToolbar() {
        with(binding.toolbarProfileModify) {
            tvToolbarTitle.text = stringOf(R.string.tv_profile_modify_toolbar_title)
            setupToolbarClickListener(ibToolbarIcon)
        }
    }

    private fun modifyBtnClick() {
        binding.btnProfileModify.setOnClickListener {
            Toast.makeText(requireContext(), "회원 정보 수정 완료", Toast.LENGTH_SHORT).show()
            findNavController().navigate(
                R.id.action_fragment_profile_modify_to_fragment_profile
            )
        }
    }

    private fun femaleSelected() {
        with(binding) {
            clModifySexFemale.setOnClickListener {
                clModifySexMale.isSelected = false
                clModifySexFemale.isSelected = true
                ivModifyFemaleCheck.visibility = View.VISIBLE
                ivModifyMaleCheck.visibility = View.INVISIBLE
            }
        }
    }

    private fun maleSelected() {
        with(binding) {
            clModifySexMale.setOnClickListener {
                clModifySexMale.isSelected = true
                clModifySexFemale.isSelected = false
                ivModifyMaleCheck.visibility = View.VISIBLE
                ivModifyFemaleCheck.visibility = View.INVISIBLE
            }
        }
    }

}