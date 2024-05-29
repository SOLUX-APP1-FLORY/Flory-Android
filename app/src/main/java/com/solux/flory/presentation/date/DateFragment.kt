package com.solux.flory.presentation.date

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.solux.flory.R
import com.solux.flory.databinding.FragmentDateBinding
import com.solux.flory.util.base.BindingFragment
import java.util.Calendar
import java.util.GregorianCalendar

class DateFragment : BindingFragment<FragmentDateBinding>(FragmentDateBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DateAdapter()
        binding.rvDate.adapter = adapter

        val calendar = Calendar.getInstance()
        binding.tvYear.text = calendar.get(Calendar.YEAR).toString()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        val week = calendar.get(Calendar.DAY_OF_WEEK)-1
        val month = calendar.get(Calendar.MONTH)+1
        val list = MutableList(week, init = { DateInfo() })
        for(i in 1..maxDate) {
            list.add(DateInfo(month, i))
        }

        adapter.submitList(list)
    }

}