package com.jvmfrog.quickmath.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jvmfrog.quickmath.R;
import com.jvmfrog.quickmath.databinding.FragmentMainBinding;
import com.jvmfrog.quickmath.game_manager.GameManager;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);

        NavHostFragment navHostFragment =
                (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        binding.easeMode.setOnClickListener(view -> {
            navController.navigate(R.id.easeModeFragment);
            GameManager.getInstance().reset();
        });

        return binding.getRoot();
    }
}