package com.hitesh.genie

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager

import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Build
import android.view.View


class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

//    private lateinit var viewPager: ViewPager
//
//    lateinit var menuItem: MenuItem

    var quotes = Quotes()
    var thoughts = Thoughts()
    var yoga = Yoga()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().setStatusBarColor(getColor(R.color.white));
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }


        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_quotes -> setCurrentFragment(quotes)
                R.id.nav_thoughts -> setCurrentFragment(thoughts)
                R.id.nav_yoga -> setCurrentFragment(yoga)
            }
            return@setOnNavigationItemSelectedListener false
        }


        /* viewPager.addOnPageChangeListener(object : OnPageChangeListener {
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

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container,Quotes())
//            .commit()

        setupViewPager(viewPager);
    }

    private fun setupViewPager(viewPager: ViewPager?) {

        var ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        var quotes = Quotes()
        var thoughts = Thoughts()
        ViewPagerAdapter.addFragment(quotes)
        ViewPagerAdapter.addFragment(thoughts)
        viewPager!!.adapter = ViewPagerAdapter


    }*/

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }

}