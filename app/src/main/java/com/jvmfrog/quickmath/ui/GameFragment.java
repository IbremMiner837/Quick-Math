package com.jvmfrog.quickmath.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import com.jvmfrog.quickmath.databinding.FragmentGameBinding;
import com.jvmfrog.quickmath.game_manager.Game;
import com.jvmfrog.quickmath.game_manager.GameManager;
import com.jvmfrog.quickmath.ui.components.KeyboardView;

public class GameFragment extends Fragment {

    private FragmentGameBinding binding;

    private Handler handler = new Handler();
    private Handler handler1 = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGameBinding.inflate(inflater, container, false);

        Game.generateInts();
        Game.generateRandomMathExample();
        binding.question.setText(GameManager.getInstance().getMathExample());

        InputConnection ic = binding.answer.onCreateInputConnection(new EditorInfo());
        binding.keyboard.setInputConnection(ic);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Game.generateInts();
                //Game.generateMathPlusExample();
                //binding.question.setText(GameManager.getInstance().getMathExample());
                binding.level.setText("Level: " + String.valueOf(GameManager.getInstance().getLevel()) + "/40");
                binding.live.setText("Live: " + String.valueOf(GameManager.getInstance().getLives()));
                binding.score.setText("Score: " + String.valueOf(GameManager.getInstance().getScore()));
                handler.postDelayed(this, 100);
            }
        }, 100);

        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Game.generateInts();
                Game.generateRandomMathExample();
                binding.question.setText(GameManager.getInstance().getMathExample());
                handler1.postDelayed(this, 3000);
            }
        }, 3000);

        return binding.getRoot();
    }
}