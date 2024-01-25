package com.android.developer.prof.reda.deliveats.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.android.developer.prof.reda.deliveats.R
import com.android.developer.prof.reda.deliveats.databinding.ActivityOnboardingBinding
import com.android.developer.prof.reda.deliveats.home.HomeActivity

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_onboarding
        )

        val viewpagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.addOnPageChangeListener(listener)
        binding.viewPager.adapter = viewpagerAdapter

        binding.nextBtn.setOnClickListener{
            val currentItem = binding.viewPager.currentItem
            if (currentItem == 0){
                binding.viewPager.currentItem = binding.viewPager.currentItem + 1
            }else {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    private val listener = object: ViewPager.OnPageChangeListener{
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            if (position == 0){
                binding.nextBtn.visibility = View.VISIBLE
                binding.nextBtn.isEnabled = true
                binding.nextBtn.text = "Next"
            }else {
                binding.nextBtn.visibility = View.VISIBLE
                binding.nextBtn.isEnabled = true
                binding.nextBtn.text = "Next"
            }
        }

        override fun onPageSelected(position: Int) {
        }

        override fun onPageScrollStateChanged(state: Int) {
        }

    }
}