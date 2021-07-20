package com.ram.structuretestapp.b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ram.structuretestapp.R
import com.ram.structuretestapp.base.BaseFragment
import com.ram.structuretestapp.databinding.A1FragmentBinding
import com.ram.structuretestapp.databinding.BFragmentBinding

class B2Fragment : BaseFragment<BFragmentBinding>(R.layout.b_fragment) {
    override fun BFragmentBinding.initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        tvB.text = "B2"
//        btnB.setOnClickListener {
//            findNavController().navigate(R.id.action_b1Fragment_to_b2Fragment)
//        }
    }

}