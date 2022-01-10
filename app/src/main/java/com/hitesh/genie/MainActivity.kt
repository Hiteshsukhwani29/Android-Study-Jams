package com.hitesh.genie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager

import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

//    private lateinit var viewPager: ViewPager
//
//    lateinit var menuItem: MenuItem

    var quotes = Quotes()
    var thoughts = Thoughts()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_quotes -> setCurrentFragment(quotes)
                R.id.nav_thoughts -> setCurrentFragment(thoughts)
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