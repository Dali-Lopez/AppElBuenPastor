package com.aplication.appelbuenpastor.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aplication.appelbuenpastor.R;

public class GalleryFragment extends Fragment {

    private ClasesViewModel clasesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        clasesViewModel =
                new ViewModelProvider(this).get(ClasesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_temas, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        clasesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}