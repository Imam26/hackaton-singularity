package com.example.mobileapp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.mobileapp.R
import com.example.mobileapp.presentation.main.tablayout.LoginAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LoginActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)

        tabLayout.addTab(tabLayout.newTab().setText("Login"))
        tabLayout.addTab(tabLayout.newTab().setText("Signup"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val loginAdapter = LoginAdapter(this)
        viewPager.adapter = loginAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = loginAdapter.getPageTitle(position)
        }.attach()

    }

}