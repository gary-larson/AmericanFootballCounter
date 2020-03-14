package com.example.android.americanfootballcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declare and initialize Team scores
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    // Declare variables for remove last score
    private boolean isTeamA = true;
    private int lastScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *  This method displays the points on the screen for Team A
     * @param points - points to display
     */
    private void displayPointsTeamA (int points) {
        TextView view = findViewById(R.id.score_teamA_text_view);
        view.setText(getApplicationContext().getString(R.string.number, points));
    }

    /**
     *  This method displays the points on the screen for Team B
     * @param points - points to display
     */
    private void displayPointsTeamB (int points) {
        TextView view = findViewById(R.id.score_teamB_text_view);
        view.setText(getApplicationContext().getString(R.string.number, points));
    }

    /**
     * This method adds 6 points to Team A's score For Touch Downs
     * @param view - called by onClick
     */
    public void addSixPointsTeamA(View view) {
        scoreTeamA += 6;
        isTeamA = true;
        lastScore = 6;
        enableRemoveLastScoreButton();
        displayPointsTeamA(scoreTeamA);
    }

    /**
     * This method adds 3 points to Team A's score for Field Goals
     * @param view - called by onClick
     */
    public void addThreePointsTeamA(View view) {
        scoreTeamA += 3;
        isTeamA = true;
        lastScore = 3;
        enableRemoveLastScoreButton();
        displayPointsTeamA(scoreTeamA);
    }

    /**
     * This method adds 2 points to Team A's score for Two point extra points and Safety
     * @param view - called by onClick
     */
    public void addTwoPointsTeamA(View view) {
        scoreTeamA += 2;
        isTeamA = true;
        lastScore = 2;
        enableRemoveLastScoreButton();
        displayPointsTeamA(scoreTeamA);
    }

    /**
     * This method adds 1 points to Team A's score for extra point
     * @param view - called by onClick
     */
    public void addExtraPointTeamA(View view) {
        scoreTeamA ++;
        isTeamA = true;
        lastScore = 1;
        enableRemoveLastScoreButton();
        displayPointsTeamA(scoreTeamA);
    }

    /**
     * This method adds 6 points to Team B's score For Touch Downs
     * @param view - called by onClick
     */
    public void addSixPointsTeamB(View view) {
        scoreTeamB += 6;
        isTeamA = false;
        lastScore = 6;
        enableRemoveLastScoreButton();
        displayPointsTeamB(scoreTeamB);
    }

    /**
     * This method adds 3 points to Team B's score for Field Goals
     * @param view - called by onClick
     */
    public void addThreePointsTeamB(View view) {
        scoreTeamB += 3;
        isTeamA = false;
        lastScore = 3;
        enableRemoveLastScoreButton();
        displayPointsTeamB(scoreTeamB);
    }

    /**
     * This method adds 2 points to Team B's score for Two point extra points and Safety
     * @param view - called by onClick
     */
    public void addTwoPointsTeamB(View view) {
        scoreTeamB += 2;
        isTeamA = false;
        lastScore = 2;
        enableRemoveLastScoreButton();
        displayPointsTeamB(scoreTeamB);
    }

    /**
     * This method adds 1 points to Team B's score for extra point
     * @param view - called by onClick
     */
    public void addExtraPointTeamB(View view) {
        scoreTeamB ++;
        isTeamA = false;
        lastScore = 1;
        enableRemoveLastScoreButton();
        displayPointsTeamB(scoreTeamB);
    }

    /**
     * This method resets both scores and displays on the screen
     * @param view - called by onClick
     */
    public void resetScores(View view) {
        scoreTeamA = 0;
        displayPointsTeamA(scoreTeamA);
        scoreTeamB = 0;
        displayPointsTeamB(scoreTeamB);
        lastScore = 0;
        disableRemoveLastScoreButton();
    }

    /**
     * This method enables Remove Last Score Button
     */
    public void enableRemoveLastScoreButton() {
        Button button = findViewById(R.id.remove_last_score_button);
        button.setEnabled(true);
    }

    /**
     * This method disables Remove Last Score Button
     */
    public void disableRemoveLastScoreButton() {
        Button button = findViewById(R.id.remove_last_score_button);
        button.setEnabled(false);
    }

    /**
     * This method removes last score when referees remove a score after a challenge
     * @param view - called by onClick
     */
    public void removeLastScore(View view) {
        if (lastScore > 0) {
            if (isTeamA) {
                scoreTeamA -= lastScore;
                displayPointsTeamA(scoreTeamA);
            } else {
                scoreTeamB -= lastScore;
                displayPointsTeamB(scoreTeamB);
            }
            lastScore = 0;
            disableRemoveLastScoreButton();
        }
    }

}
