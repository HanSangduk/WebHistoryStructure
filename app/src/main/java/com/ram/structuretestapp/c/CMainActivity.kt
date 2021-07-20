package com.ram.structuretestapp.c

import android.content.Intent
import android.util.Log
import androidx.core.view.forEach
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ram.structuretestapp.MainActivity
import com.ram.structuretestapp.R
import com.ram.structuretestapp.b.BMainActivity
import com.ram.structuretestapp.base.BaseActivity
import com.ram.structuretestapp.databinding.ActivityMainCBinding

class CMainActivity: BaseActivity<ActivityMainCBinding>(R.layout.activity_main_c) {

    val fnc by lazy {
        findNavController(R.id.frMainC)
    }

    override fun ActivityMainCBinding.initVIew() {
        Log.d("alskaejr", "ok activity 1")

        with(bottomNavi){
            itemIconTintList = null
            setupWithNavController(fnc)
            menu.forEach { // longpress tooltip disable
                androidx.appcompat.widget.TooltipCompat.setTooltipText(
                    findViewById(it.itemId),
                    null
                )

                it.setOnMenuItemClickListener {
                    android.util.Log.d("alskaejr","click ${it.title}")
                    when(it.title){
                        getString(com.ram.structuretestapp.R.string.home) -> {
                            val intent = Intent(this@CMainActivity, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                            startActivity(intent)
                            overridePendingTransition(R.anim.anim_none, R.anim.anim_none)
                        }
                        getString(com.ram.structuretestapp.R.string.search) -> {
                            val intent = Intent(this@CMainActivity, BMainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                            startActivity(intent)
                            overridePendingTransition(R.anim.anim_none, R.anim.anim_none)
                        }
                        getString(com.ram.structuretestapp.R.string.create) -> { }
                    }
                    false
                }
            }
        }
    }
}