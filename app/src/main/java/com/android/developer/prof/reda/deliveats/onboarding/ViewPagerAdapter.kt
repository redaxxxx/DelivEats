package com.android.developer.prof.reda.deliveats.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.android.developer.prof.reda.deliveats.R
import com.android.developer.prof.reda.deliveats.databinding.ViewpagerItemBinding

class ViewPagerAdapter(private val context: Context): PagerAdapter() {

    private val images = arrayOf(
        R.drawable.illustartion_1,
        R.drawable.illustration_2
    )

    private val subtitles = arrayOf(
        "Here You Can find a chef or dish for every \n taste and color. Enjoy!",
        "Enjoy a fast and smooth food delivery at \n your doorstep"
    )

    private val titles = arrayOf(
        "Find your Comfort \n Food here",
        "Food Ninja is Where Your \n Comfort Food Lives"
    )
    override fun getCount(): Int {
        return titles.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = DataBindingUtil.inflate<ViewpagerItemBinding>(
            inflater,
            R.layout.viewpager_item,
            container,
            false
        )

        // init views
        binding.illustationImage.setImageResource(images[position])
        binding.titleTv.text = titles[position]
        binding.subtitleTv.text = subtitles[position]
        container.addView(binding.root)

        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}