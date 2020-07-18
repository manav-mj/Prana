package com.studios.prana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnboardingActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.onboarding_slider_container)
    View onboardingSliderContainer;
    @BindView(R.id.skip_button)
    TextView skipButton;
    @BindView(R.id.continue_button)
    View continueButton;

    IntroPagerAdapter mPagerAdapter = new IntroPagerAdapter();

    private int[] layouts = {R.layout.layout_onboarding_importance, R.layout.layout_onboarding_how_to_build, R.layout.layout_onboarding_habit_tracker, R.layout.layout_onboarding_home_remedies};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        ButterKnife.bind(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(mPagerAdapter);
        viewPager.setOffscreenPageLimit(layouts.length);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == layouts.length - 1){
                    skipButton.setText(getString(R.string.text_continue));
                } else {
                    skipButton.setText(getString(R.string.text_skip));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onboardingSliderContainer.startAnimation(AnimationUtils.loadAnimation(OnboardingActivity.this, android.R.anim.fade_out));
                onboardingSliderContainer.setVisibility(View.GONE);
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnboardingActivity.this, MainActivity.class));
            }
        });
    }

    class IntroPagerAdapter extends PagerAdapter {
        private LayoutInflater mLayoutInflater;

        public IntroPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            mLayoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = mLayoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}