package com.ram.structuretestapp.b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ram.structuretestapp.MainActivity
import com.ram.structuretestapp.R
import com.ram.structuretestapp.base.BaseFragment
import com.ram.structuretestapp.c.CMainActivity
import com.ram.structuretestapp.databinding.A1FragmentBinding
import com.ram.structuretestapp.databinding.BFragmentBinding

class B1Fragment : BaseFragment<BFragmentBinding>(R.layout.b_fragment) {
    override fun BFragmentBinding.initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        tvB.text = "B1"
        btnB.setOnClickListener {
            findNavController().navigate(R.id.action_newSearchFragment_to_b2Fragment)
        }
    }

    override fun onBackBtn() {
        (activity as BMainActivity).finishAndNoAnim()
//        (activity as BMainActivity).rootBack()
        
    }


}