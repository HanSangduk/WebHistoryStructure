package com.ram.structuretestapp.b

import android.content.Intent
import android.util.Log
import androidx.appcompat.widget.TooltipCompat
import androidx.core.view.forEach
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ram.structuretestapp.MainActivity
import com.ram.structuretestapp.R
import com.ram.structuretestapp.base.BaseActivity
import com.ram.structuretestapp.c.CMainActivity
import com.ram.structuretestapp.databinding.ActivityMainBBinding

class BMainActivity: BaseActivity<ActivityMainBBinding>(R.layout.activity_main_b) {

    val fnc by lazy {
        findNavController(R.id.frMainB)
    }

    override fun ActivityMainBBinding.initVIew() {
        Log.d("alskaejr", "ok activity 1")

        with(bottomNavi){
            itemIconTintList = null
            setupWithNavController(fnc)
            menu.forEach { // longpress tooltip disable
                TooltipCompat.setTooltipText(
                    findViewById(it.itemId),
                    null
                )

                it.setOnMenuItemClickListener {
                    Log.d("alskaejr","click ${it.title}")
                    when(it.title){
                        getString(R.string.home) -> {
                            val intent = Intent(this@BMainActivity, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                            startActivity(intent)
                            overridePendingTransition(R.anim.anim_none, R.anim.anim_none)
                        }
                        getString(R.string.search) -> {
//                            val intent = Intent(this@MainActivity, BMainActivity::class.java)
//                            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
//                            startActivity(intent)
                        }
                        getString(R.string.follow) -> {
                            val intent = Intent(this@BMainActivity, CMainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                            startActivity(intent)
                            overridePendingTransition(R.anim.anim_none, R.anim.anim_none)
                        }
                    }
                    false
                }
            }
        }

//        bottomA.setOnClickListener {
//            val intent = Intent(this@BMainActivity, MainActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
////            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
//            startActivity(intent)
//        }
//
//        bottomB.setOnClickListener {
//            finish()
//        }
    }

    fun rootBack(){
        val intent = Intent(this@BMainActivity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        overridePendingTransition(R.anim.anim_none, R.anim.anim_none)
    }
}