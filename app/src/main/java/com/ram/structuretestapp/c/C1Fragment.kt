package com.ram.structuretestapp.c

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ram.structuretestapp.MainActivity
import com.ram.structuretestapp.R
import com.ram.structuretestapp.base.BaseActivity
import com.ram.structuretestapp.base.BaseFragment
import com.ram.structuretestapp.databinding.A1FragmentBinding
import com.ram.structuretestapp.databinding.CFragmentBinding

class C1Fragment : BaseFragment<CFragmentBinding>(R.layout.c_fragment) {

    override fun CFragmentBinding.initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        tvC.text = "C1"
        btnC.setOnClickListener {
            findNavController().navigate(R.id.action_categoryFollowFragment_to_c2Fragment)
        }
    }

    override fun onBackBtn() {
        (activity as CMainActivity).finishAndNoAnim()
    }
}