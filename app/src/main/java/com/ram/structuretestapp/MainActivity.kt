package com.ram.structuretestapp

import android.content.Intent
import android.util.Log
import androidx.appcompat.widget.TooltipCompat
import androidx.core.view.forEach
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ram.structuretestapp.b.BMainActivity
import com.ram.structuretestapp.base.BaseActivity
import com.ram.structuretestapp.c.CMainActivity
import com.ram.structuretestapp.databinding.ActivityMainBinding

class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    val fnc by lazy {
        findNavController(R.id.frA)
    }

    override fun ActivityMainBinding.initVIew() {
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
                        getString(R.string.home) -> {}
                        getString(R.string.search) -> {
                            val intent = Intent(this@MainActivity, BMainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                            startActivity(intent)
                            overridePendingTransition(R.anim.anim_none, R.anim.anim_none)
                        }
                        getString(R.string.follow) -> {
                            val intent = Intent(this@MainActivity, CMainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                            startActivity(intent)
                            overridePendingTransition(R.anim.anim_none, R.anim.anim_none)
                        }
                    }
                    false
                }
            }
        }
    }
}