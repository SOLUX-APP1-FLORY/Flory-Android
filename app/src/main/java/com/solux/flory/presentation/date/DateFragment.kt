package com.solux.flory.presentation.date

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.solux.flory.R
import com.solux.flory.databinding.FragmentDateBinding
import com.solux.flory.util.base.BindingFragment
import com.solux.flory.util.fragment.stringOf
import com.solux.flory.util.fragment.toast
import java.time.LocalDate

class DateFragment : BindingFragment<FragmentDateBinding>(FragmentDateBinding::inflate) {
    private val viewModel by activityViewModels<DateViewModel>()
    private lateinit var adapter: DateAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeDateYear()
        observeDateMonth()
        leftArrowClick()
        rightArrowClick()
        addFabClick()
    }

    private fun initAdapter() {
        adapter = DateAdapter() {
            if(it.month == LocalDate.now().monthValue && it.dayOfMonth == LocalDate.now().dayOfMonth) {
                if(it.imageUrl != null) {
                    val bundle = Bundle().apply {
                        putSerializable(DATE_KEY, it)
                    }
                    findNavController().navigate(R.id.action_fragment_date_to_fragment_modify, bundle)
                }
                else {
                    findNavController().navigate(R.id.action_fragment_date_to_fragment_record)
                }
            }
            else {
                toast(stringOf(R.string.tv_date_modify_impossible))
            }
        }
        binding.rvDate.adapter = adapter
        viewModel.dateList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun observeDateYear() {
        viewModel.year.observe(viewLifecycleOwner) {
            binding.tvDateYear.text = it
        }
    }

    private fun observeDateMonth() {
        viewModel.month.observe(viewLifecycleOwner) {
            binding.tvDateMonth.text = it
        }
    }

    private fun leftArrowClick() {
        binding.ivDateLeftArrow.setOnClickListener {
            viewModel.moveToPreviousMonth()
        }
    }

    private fun rightArrowClick() {
        binding.ivDateRightArrow.setOnClickListener {
            viewModel.moveToNextMonth()
        }
    }

    private fun addFabClick() {
        binding.fabDateAdd.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_date_to_fragment_record)
        }
    }

    companion object {
        const val DATE_KEY = "date"
    }

}