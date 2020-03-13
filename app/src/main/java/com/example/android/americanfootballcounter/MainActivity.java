package com.example.android.americanfootballcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declare and initialize Team A's score
    private int scoreTeamA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayPointsTeamA (int points) {
        TextView view = findViewById(R.id.score_teamA_text_view);
        view.setText(getApplicationContext().getString(R.string.number, points));
    }

    /**
     * This method adds 6 points to Team A's score For Touch Downs
     * @param view - called by onClick
     */
    public void addSixPointsTeamA(View view) {
        scoreTeamA += 6;
        displayPointsTeamA(scoreTeamA);
    }

    /**
     * This method adds 3 points to Team A's score for Field Goals
     * @param view - called by onClick
     */
    public void addThreePointsTeamA(View view) {
        scoreTeamA += 3;
        displayPointsTeamA(scoreTeamA);
    }

    /**
     * This method adds 2 points to Team A's score for Two point extra points and Safety
     * @param view - called by onClick
     */
    public void addTwoPointsTeamA(View view) {
        scoreTeamA += 2;
        displayPointsTeamA(scoreTeamA);
    }

    /**
     * This method adds 1 points to Team A's score for extra point
     * @param view - called by onClick
     */
    public void addExtraPointTeamA(View view) {
        scoreTeamA ++;
        displayPointsTeamA(scoreTeamA);
    }
}
