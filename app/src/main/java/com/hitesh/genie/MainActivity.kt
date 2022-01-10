package com.hitesh.genie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager

import com.google.android.material.bottomnavigation.BottomNavigationView

import androidx.annotation.NonNull
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.hitesh.genie.adapter.ViewPagerAdapter
import com.hitesh.genie.adapter.quotesAdapter


class MainActivity : AppCompatActivity() {

    /*lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var viewPager: ViewPager

    lateinit var quotes:Quotes
    lateinit var thoughts:Thoughts

    lateinit var menuItem: MenuItem
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*viewPager = findViewById<ViewPager>(R.id.viewpager)

        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_quotes -> viewPager.currentItem = 0
                R.id.nav_thoughts -> viewPager.currentItem = 1
                R.id.nav_task -> viewPager.currentItem = 2
                R.id.nav_thoughts -> viewPager.currentItem = 3
                R.id.nav_networking -> viewPager.currentItem = 4
            }
            return@setOnNavigationItemSelectedListener false
        }

        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (menuItem != null) {
                    menuItem.setChecked(false)
                } else {
                    bottomNavigationView.menu.getItem(0).isChecked = false
                }
                Log.d("page", "onPageSelected: $position")
                bottomNavigationView.menu.getItem(position).isChecked = true
                menuItem = bottomNavigationView.menu.getItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
*/
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, Quotes())
            .commit()
/*
        setupViewPager(viewPager);
    }

    private fun setupViewPager(viewPager: ViewPager?) {

        var ViewPaggerAdapter = ViewPagerAdapter(supportFragmentManager)



    }*/

    }
}