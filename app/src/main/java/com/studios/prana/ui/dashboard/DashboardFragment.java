package com.studios.prana.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.studios.prana.R;
import com.studios.prana.models.LifestyleData;
import com.studios.prana.models.LifestyleTile;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardFragment extends Fragment {

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.list_container)
    LinearLayout mListContainer;

    private DashboardViewModel dashboardViewModel;
    private final int[] colors = {R.color.seaGreen, R.color.buttonColorLight, R.color.colorAccent, R.color.buttonColorLight, R.color.seaGreen, R.color.colorAccent};
    private final String[] lifestyleTypes = {"Diet", "Wellness", "    Massage", "Cleansing", "Exercise", "Herbs"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new DashboardViewModel(getContext());
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, root);

        for (int i = 0; i < lifestyleTypes.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(lifestyleTypes[i]));
        }

        dashboardViewModel.getData().observe(getViewLifecycleOwner(), new Observer<LifestyleData>() {
            @Override
            public void onChanged(LifestyleData lifestyleData) {
                for (int i = 0; i < lifestyleData.data.size(); i++) {
                    LifestyleTile tile = lifestyleData.data.get(i);
                    View view = getLayoutInflater().inflate(R.layout.item_lifestyle, mListContainer, false);
                    ((TextView) view.findViewById(R.id.date)).setText(tile.date);
                    ((TextView) view.findViewById(R.id.title)).setText(tile.heading);
                    ((TextView) view.findViewById(R.id.content)).setText(tile.content);
                    ((View) view.findViewById(R.id.header_container)).setBackgroundResource(colors[i]);

                    mListContainer.addView(view);
                }
            }
        });
        return root;
    }
}