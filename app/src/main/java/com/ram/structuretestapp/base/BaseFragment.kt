package com.ram.structuretestapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<B : ViewDataBinding>(
    private val layoutId: Int
) : Fragment(), ViewBindingHolder<B> by ViewBindingHolderImpl() {

    abstract fun B.initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )

    fun Int.getStringUtil() = requireContext().getString(this)
    fun Int.getStringUtil(param: String) = requireContext().getString(this, param)
    fun getStringUtilIn(resId: Int) = resId.getStringUtil()

    open fun onBackBtn() {
        naviBack()
    }

    open fun onHeaderBackBtn() {
        naviBack()
    }

    open fun onHeaderCloseBtn() {
        naviBack()
    }

    //상속 받은 뷰에서 해당 버튼 눌러서 삭제하는 APi 호출용도
    open fun onHeaderDeleteBtn() {}

    protected fun naviBack() {
        findNavController().navigateUp()
    }

    protected fun goNavi(action: NavDirections) {
        findNavController().navigate(action)
    }
    protected fun goNavi(destination: Int, args: Bundle? = null) {
        findNavController().navigate(destination, args)
    }

    open fun B.btnSetting() {}
    open fun B.vmObserve() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = initBinding(DataBindingUtil.inflate(inflater, layoutId, container, false), this) {

        initView(inflater, container, savedInstanceState)
        btnSetting()
        vmObserve()

        requireActivity().onBackPressedDispatcher.addCallback(lifecycleOwner) {
            onBackBtn()
        }
    }
}