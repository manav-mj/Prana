package com.studios.prana.ui.tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.studios.prana.R;
import com.studios.prana.models.Alarm;
import com.studios.prana.models.TrackerData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HabitTrackerFragment extends Fragment {

    @BindView(R.id.alarm_container)
    LinearLayout mContainerLayout;

    private HabitTrackerViewModel habitTrackerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        habitTrackerViewModel = new HabitTrackerViewModel(getContext());
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        ButterKnife.bind(this, root);
        habitTrackerViewModel.getText().observe(getViewLifecycleOwner(), new Observer<TrackerData>() {
            @Override
            public void onChanged(TrackerData trackerData) {
                for (int i = 0; i < trackerData.alarms.size(); i++) {
                    Alarm alarm = trackerData.alarms.get(i);

                    View view = getLayoutInflater().inflate(R.layout.item_alarm, mContainerLayout, false);
                    ((TextView) view.findViewById(R.id.time)).setText(alarm.time);
                    ((TextView) view.findViewById(R.id.title)).setText(alarm.title);
                    ((TextView) view.findViewById(R.id.streak)).setText(String.valueOf(alarm.streak));

                    mContainerLayout.addView(view);
                }
            }
        });
        return root;
    }
}