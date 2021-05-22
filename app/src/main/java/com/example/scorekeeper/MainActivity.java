package com.example.scorekeeper;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_SCORE_A = "extra_score_a";
    private static final String EXTRA_SCORE_B = "extra_score_b";
    private static final String EXTRA_FOUL_A = "extra_foul_a";
    private static final String EXTRA_FOUL_B = "extra_foul_b";
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int foulTeamA = 0;
    private int foulTeamB = 0;
    TextView teamAScoreText, teamBScoreText, teamAFoulText, teamBFoulText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt(EXTRA_SCORE_A, 0);
            scoreTeamB = savedInstanceState.getInt(EXTRA_SCORE_B, 0);
            foulTeamA = savedInstanceState.getInt(EXTRA_FOUL_A, 0);
            foulTeamB = savedInstanceState.getInt(EXTRA_FOUL_B, 0);
        }

        setScore();

        teamAScoreText = findViewById(R.id.teamALayout).findViewById(R.id.scoreValueText);
        teamBScoreText = findViewById(R.id.teamBLayout).findViewById(R.id.scoreValueText);

        teamAFoulText = findViewById(R.id.teamALayout).findViewById(R.id.foulValueText);
        teamBFoulText = findViewById(R.id.teamBLayout).findViewById(R.id.foulValueText);

        findViewById(R.id.teamALayout).findViewById(R.id.addGoalBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreTeamA += 1;
                setScore();
            }
        });

        findViewById(R.id.teamALayout).findViewById(R.id.addFoulBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foulTeamA += 1;
                setScore();
            }
        });

        findViewById(R.id.teamBLayout).findViewById(R.id.addGoalBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreTeamB +=  1;
                setScore();
            }
        });

        findViewById(R.id.teamBLayout).findViewById(R.id.addFoulBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foulTeamB +=  1;
                setScore();
            }
        });


        findViewById(R.id.resetBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreTeamA = 0;
                scoreTeamB = 0;
                foulTeamA = 0;
                foulTeamB = 0;
                setScore();
            }
        });
    }

    private void setScore() {
        teamAFoulText.setText(String.valueOf(foulTeamA));
        teamBFoulText.setText(String.valueOf(foulTeamB));
        teamAScoreText.setText(String.valueOf(scoreTeamA));
        teamBScoreText.setText(String.valueOf(scoreTeamB));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(EXTRA_SCORE_A, scoreTeamA);
        outState.putInt(EXTRA_SCORE_B, scoreTeamB);
        outState.putInt(EXTRA_FOUL_A, foulTeamA);
        outState.putInt(EXTRA_FOUL_B, foulTeamB);
    }
}