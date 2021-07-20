package com.ram.structuretestapp.base

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.ram.structuretestapp.R

abstract class BaseActivity<B: ViewDataBinding>(val layoutId: Int): AppCompatActivity(), ActViewBindingHolder<B> by ActViewBindingHolderImpl()  {

    abstract fun B.initVIew()
    open fun B.btnSetting(){}
    open fun B.observe(){}

    open fun finishAndNoAnim(){
        finish()
        overridePendingTransition(R.anim.anim_none, R.anim.anim_none)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        overridePendingTransition(R.anim.anim_none, R.anim.anim_none)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d("alskaejr","onAttachedToWindow @@")
//        overridePendingTransition(0, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding(DataBindingUtil.setContentView(this, layoutId),this, lifecycle){
            initVIew()
            btnSetting()
            observe()
        }
    }
}