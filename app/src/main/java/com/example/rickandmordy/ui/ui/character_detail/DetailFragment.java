package com.example.rickandmordy.ui.ui.character_detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.rickandmordy.databinding.FragmentDetailBinding;
import com.example.rickandmordy.ui.data.models.Charakter;

public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;
    private Charakter charakter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        charakter = (Charakter) getArguments().getSerializable("details");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setData();

    }

    private void setData() {
        Glide
                .with(binding.getRoot())
                .load(charakter.getImage())
                .circleCrop()
                .into(binding.detailPhoto);
       binding.name.setText(charakter.getName());
       binding.status.setText(charakter.getStatus());
    }
}