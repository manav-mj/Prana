package com.studios.prana.ui.Remedies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.studios.prana.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RemediesFragment extends Fragment {

    @BindView(R.id.grid_container)
    GridLayout mGridLayout;

    private RemediesViewModel remediesViewModel;

    private int[] icons = {R.drawable.ic_mind, R.drawable.ic_heart, R.drawable.ic_skin, R.drawable.ic_digestive, R.drawable.ic_eye, R.drawable.ic_dental, R.drawable.ic_nose, R.drawable.ic_blood, R.drawable.ic_hair, R.drawable.ic_uterus, R.drawable.ic_feet, R.drawable.ic_sleep, R.drawable.ic_obesity, R.drawable.ic_ear, R.drawable.ic_speech};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        remediesViewModel =
                ViewModelProviders.of(this).get(RemediesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);
        remediesViewModel.getTitle().observe(getViewLifecycleOwner(), new Observer<String[]>() {
            @Override
            public void onChanged(String[] strings) {
                for (int i = 0; i < strings.length; i++) {
                    View view = getLayoutInflater().inflate(R.layout.item_remedy, mGridLayout, false);
                    ((ImageView) view.findViewById(R.id.icon)).setImageResource(icons[i]);
                    ((TextView) view.findViewById(R.id.title)).setText(strings[i]);

                    mGridLayout.addView(view);

                    if (i == 0){
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }
        });
        return root;
    }
}