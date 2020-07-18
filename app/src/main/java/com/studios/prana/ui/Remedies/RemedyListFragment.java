package com.studios.prana.ui.Remedies;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.studios.prana.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RemedyListFragment extends Fragment {

    @BindView(R.id.skin_type_container)
    LinearLayout mSkinTypeContainer;

    private final String[] types = {"Dry Skin", "Oily Skin", "Splinters", "Acne/ Blackheads/ Pimples", "Reducing Scars", "Stretch marks", "Burns", "Wrinkles and Skin Freshner", "Common Rashes", "Sensitive Skin", "Mosquito Bite", "Skin Tightening", "Vitiligo or White Spots"};

    public RemedyListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_remedy_list, container, false);
        ButterKnife.bind(this, root);

        for (int i = 0; i < types.length; i++) {
            String type = types[i];
            View view = getLayoutInflater().inflate(R.layout.item_skin_type, mSkinTypeContainer, false);
            ((TextView) view.findViewById(R.id.title)).setText(type);

            mSkinTypeContainer.addView(view);
        }

        return root;
    }
}