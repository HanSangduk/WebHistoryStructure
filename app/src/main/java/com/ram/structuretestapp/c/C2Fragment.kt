package com.ram.structuretestapp.c

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ram.structuretestapp.MainActivity
import com.ram.structuretestapp.R
import com.ram.structuretestapp.base.BaseFragment
import com.ram.structuretestapp.databinding.A1FragmentBinding
import com.ram.structuretestapp.databinding.CFragmentBinding

class C2Fragment : BaseFragment<CFragmentBinding>(R.layout.c_fragment) {

    override fun CFragmentBinding.initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        tvC.text = "C2"
//        btnC.setOnClickListener {
//            findNavController().navigate(R.id.action_a1Fragment_to_a2Fragment)
//        }
    }
}