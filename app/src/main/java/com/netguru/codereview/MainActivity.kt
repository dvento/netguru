package com.netguru.codereview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.netguru.codereview.ui.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment()).commitNow()
    }
}
