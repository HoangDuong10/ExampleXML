package com.example.layout

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.layout.adapter.InfoAdapter
import com.example.layout.adapter.TagAdapter
import com.example.layout.adapter.ViewPagerAdapter
import com.example.layout.databinding.ActivityMainBinding
import com.example.layout.databinding.CustomTablayoutBinding
import com.example.layout.model.Info
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityBinding: ActivityMainBinding
    private lateinit var customTablayoutBinding: CustomTablayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)
        displayListInfo()
        displayListTag()
        setUpTabLayout()


    }

    private fun displayListInfo(){
        val infoAdapter = InfoAdapter(getListInfo())
        val layoutManager = GridLayoutManager(this,3)
        mainActivityBinding.rcvInfo.layoutManager = layoutManager
        mainActivityBinding.rcvInfo.adapter = infoAdapter
    }

    private fun displayListTag(){
        val tagAdapter = TagAdapter(getListTag())

        val layoutManager = FlexboxLayoutManager(this).apply {
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.FLEX_START
        }
        mainActivityBinding.rcvTag.layoutManager = layoutManager
        mainActivityBinding.rcvTag.adapter = tagAdapter
    }
    private fun setUpTabLayout(){
        mainActivityBinding.viewAdapter.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(mainActivityBinding.tabLayout, mainActivityBinding.viewAdapter) { tab, position ->
            tab.customView = getTabView(position)
        }.attach()

        updateBadgeCount(1, 5)
        val tabBackground = ContextCompat.getDrawable(this, R.drawable.tab_bg_selected)
        val tab = mainActivityBinding.tabLayout.getTabAt(0)
        tab?.view?.background = tabBackground
        tab?.customView?.let {
            customTablayoutBinding = CustomTablayoutBinding.bind(it)
            customTablayoutBinding.tvTitle.setTextColor(Color.BLACK)
        }
        mainActivityBinding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.view?.background = tabBackground
                tab?.customView?.let {
                    customTablayoutBinding = CustomTablayoutBinding.bind(it)
                    customTablayoutBinding.tvTitle.setTextColor(Color.BLACK)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Để lại mặc định khi tab bị bỏ chọn
                tab?.view?.background = null
                tab?.customView?.let {
                    customTablayoutBinding = CustomTablayoutBinding.bind(it)
                    customTablayoutBinding.tvTitle.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.text_grey))
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Xử lý khi tab được chọn lại
            }
        })

    }
    private fun getListInfo(): List<Info> {
        val list: MutableList<Info> = mutableListOf()
        list.add(Info("Chi tiêu TB", "3,3 Tr"))
        list.add(Info("Tỉ lệ chốt", "30%"))
        list.add(Info("Tốc độ chốt", "4 bánh"))
        list.add(Info("SP Mẹ & bé", "20 ĐH"))
        list.add(Info("Chu kì mua", "19 ngày"))
        list.add(Info("Tỷ lệ matching", "90%"))

        return list
    }

    private fun getListTag() : List<String>{
        val list: MutableList<String> = mutableListOf()
        list.add("#Thích bảo hành")
        list.add("#Thích đủ thứ")
        list.add("#Thích đủ giao nhanh")
        list.add("#Thích đổi trả2")
        list.add("#Thích đổi trả3")
        list.add("#Thích đổi trả4")
        list.add("#Thích đổi trả5")

        return list
    }



    private fun getTabView(position: Int): View {
        customTablayoutBinding = CustomTablayoutBinding.inflate(layoutInflater)
        val titles = arrayOf("Hành trình", "Đơn hàng", "Hoạt động")
        customTablayoutBinding.tvTitle.text = titles[position]
        return customTablayoutBinding.root
    }

    private fun updateBadgeCount(tabIndex: Int, count: Int) {
        val tab = mainActivityBinding.tabLayout.getTabAt(tabIndex)
        tab?.customView?.let {
            customTablayoutBinding = CustomTablayoutBinding.bind(it)
            if (count > 0) {
                customTablayoutBinding.tvQuantity.text = count.toString()
                customTablayoutBinding.tvQuantity.visibility = View.VISIBLE
            } else {
                customTablayoutBinding.tvQuantity.visibility = View.GONE
            }
        }
    }
}