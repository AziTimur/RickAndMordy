package com.example.rickandmordy.ui.ui.charakter_list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.rickandmordy.R;
import com.example.rickandmordy.databinding.FragmentCharakterBinding;
import com.example.rickandmordy.ui.App;
import com.example.rickandmordy.ui.MainActivity;
import com.example.rickandmordy.ui.data.models.Charakter;
import com.example.rickandmordy.ui.data.models.MainResponse;
import com.example.rickandmordy.ui.ui.character_detail.DetailFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CharakterFragment extends Fragment {
    private FragmentCharakterBinding binding;
    private CharacterAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharakterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new CharacterAdapter();

        App.service.fetcharakters().enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setList((ArrayList<Charakter>) response.body().getResults());
                    binding.recycler.setAdapter(adapter);
                } else {
                    Toast.makeText(requireContext(), "аовылрпшдгурйгпшцшгпийшцп", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                Toast.makeText(requireContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
        binding.recycler.setAdapter(adapter);
        adapter.setClickListener(new CharacterAdapter.AdapterClickListener() {
            @Override
            public void onClick(Charakter charakter) {
                DetailFragment fragment = new DetailFragment();
                Bundle bundle = new Bundle();
                Log.d("ololo", "inClickItem: " + charakter.getName());
                bundle.putSerializable("details",charakter);
                getParentFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
                fragment.setArguments(bundle);
            }
        });

    }
}
