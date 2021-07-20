package com.ram.structuretestapp.a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ram.structuretestapp.R
import com.ram.structuretestapp.base.BaseFragment
import com.ram.structuretestapp.databinding.A1FragmentBinding

class A2Fragment : BaseFragment<A1FragmentBinding>(R.layout.a1_fragment) {
    override fun A1FragmentBinding.initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        tvA.text = "A2"
        btnA.setOnClickListener {
            findNavController().navigate(R.id.action_a2Fragment_to_a3Fragment)
        }
    }

}