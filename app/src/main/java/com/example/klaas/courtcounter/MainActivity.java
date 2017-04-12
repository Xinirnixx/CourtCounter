package com.example.klaas.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int setnumber = 1;

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    int set1A = 0;
    int set1B = 0;

    int set2A = 0;
    int set2B = 0;

    int set3A = 0;
    int set3B = 0;

    int set4A = 0;
    int set4B = 0;

    int set5A = 0;
    int set5B = 0;

    boolean advTeamA = false;
    boolean advTeamB = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ;
    }

    public void addOneForTeamA(View v) {
        if (scoreTeamA == 3 && (advTeamA || scoreTeamB < 3)) {
            switch (setnumber) {
                case 1:
                    if (set1A < 6) {
                        set1A += 1;
                    } else {
                        set2A += 1;
                        setnumber += 1;
                    }
                    break;
                case 2:
                    if (set2A < 6) {
                        set2A += 1;
                    } else {
                        set3A += 1;
                        setnumber += 1;
                    }
                    break;
                case 3:
                    if (set3A < 6) {
                        set3A += 1;
                    } else {
                        set4A += 1;
                        setnumber += 1;
                    }
                    break;
                case 4:
                    if (set4A < 6) {
                        set4A += 1;
                    } else {
                        set5A += 1;
                        setnumber += 1;
                    }
                    break;
                case 5:
                    if (set5A < 6) {
                        set5A += 1;
                    } else {
                        set5A += 1;
                        setnumber += 1;
                    }
                    break;
            }
            resetScores();
        } else if (scoreTeamA == 3 && scoreTeamB == 3) {
            if (advTeamB == false) {
                advTeamA = true;
            } else {
                advTeamB = false;
            }
        } else {
            scoreTeamA += 1;

        }
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAdvantageTeamA(advTeamA);
        displayAdvantageTeamB(advTeamB);
//        displayMessage(createGameInSetSummary());
        displaySummary(set1A, set1B, set2A, set2B, set3A, set3B, set4A, set4B, set5A, set5B);
    }

    public void addOneForTeamB(View v) {
        if (scoreTeamB == 3 && (advTeamB || scoreTeamA < 3)) {
            switch (setnumber) {
                case 1:
                    if (set1B < 6) {
                        set1B += 1;
                    } else {
                        set2B += 1;
                        setnumber += 1;
                    }
                    break;
                case 2:
                    if (set2B < 6) {
                        set2B += 1;
                    } else {
                        set3B += 1;
                        setnumber += 1;
                    }
                    break;
                case 3:
                    if (set3B < 6) {
                        set3B += 1;
                    } else {
                        set4B += 1;
                        setnumber += 1;
                    }
                    break;
                case 4:
                    if (set4B < 6) {
                        set4B += 1;
                    } else {
                        set5B += 1;
                        setnumber += 1;
                    }
                    break;
                case 5:
                    if (set5B < 6) {
                        set5B += 1;
                    } else {
                        set5B += 1;
                        setnumber += 1;
                    }
                    break;
            }
            resetScores();
        } else if (scoreTeamB == 3 && scoreTeamA == 3) {
            if (advTeamA == false) {
                advTeamB = true;
            } else {
                advTeamA = false;
            }
        } else {
            scoreTeamB += 1;
        }
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAdvantageTeamA(advTeamA);
        displayAdvantageTeamB(advTeamB);
//        displayMessage(createGameInSetSummary());
        displaySummary(set1A, set1B, set2A, set2B, set3A, set3B, set4A, set4B, set5A, set5B);
    }

    /**
     * This method resets the points to zero when a tennis game (not match) has won and a new game (not match) starts.
     */
    public void resetScores() {
        scoreTeamA = 0;
        scoreTeamB = 0;

        advTeamA = false;
        advTeamB = false;
    }

    /**
     * This method resets all the points and sets and other data.
     * For example when a new game starts.
     */
    public void resetAll(View view) {
        setnumber = 1;

        scoreTeamA = 0;
        scoreTeamB = 0;

        set1A = 0;
        set1B = 0;

        set2A = 0;
        set2B = 0;

        set3A = 0;
        set3B = 0;

        set4A = 0;
        set4B = 0;

        set5A = 0;
        set5B = 0;

        advTeamA = false;
        advTeamB = false;

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAdvantageTeamA(advTeamA);
        displayAdvantageTeamB(advTeamB);
//      displayMessage(createGameInSetSummary());
        displaySummary(set1A, set1B, set2A, set2B, set3A, set3B, set4A, set4B, set5A, set5B);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(changeScoreIntoTennisScore(score)));
    }

    public void displayAdvantageTeamA(boolean advantage) {

        TextView advantageText = (TextView) findViewById(R.id.team_a_adv);
        if (advantage) {
            advantageText.setVisibility(View.VISIBLE);
        } else {
            advantageText.setVisibility(View.INVISIBLE);
        }
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(changeScoreIntoTennisScore(score)));
    }

    public void displayAdvantageTeamB(boolean advantage) {

        TextView advantageText = (TextView) findViewById(R.id.team_b_adv);
        if (advantage) {
            advantageText.setVisibility(View.VISIBLE);
        } else {
            advantageText.setVisibility(View.INVISIBLE);
        }
    }
    /**
     * This method changes the points (0, 1, 2, 3) into the tennis counting (0, 15, 30, 40).
     */
    private int changeScoreIntoTennisScore(int points) {
        int score_tennis = 0;

        switch(points){
            case 0:
                score_tennis = 0;
                break;
            case 1:
                score_tennis = 15;
                break;
            case 2:
                score_tennis = 30;
                break;
            case 3:
                score_tennis = 40;
                break;
        }

        return score_tennis;
    }

    /**
     * FOR TESTING ONLY
     * This method makes a summary of all the data.
     * I used this to test and debug the java methods.
     */
    private String createGameInSetSummary() {

        TextView textviewA = (TextView) findViewById(R.id.editTextA);
        String nameA = textviewA.getText().toString();

        TextView textviewB = (TextView) findViewById(R.id.editTextB);
        String nameB = textviewB.getText().toString();


        String setSummary = nameA + Integer.valueOf(set1A).toString() + Integer.valueOf(set2A).toString() + Integer.valueOf(set3A).toString() + Integer.valueOf(set4A).toString()
                + Integer.valueOf(set5A).toString() + "\n" + nameB + Integer.valueOf(set1B).toString() + Integer.valueOf(set2B).toString() + Integer.valueOf(set3B).toString() + Integer.valueOf(set4B).toString() + Integer.valueOf(set5B).toString();
        return setSummary;
    }


    /**
     * FOR TESTING ONLY
     * This method displays all the data into a summary text on the screen.
     * I used this to test and debug the java methods.
     */
    private void displayMessage(String message) {
        TextView gamesInSetSummary = (TextView) findViewById(R.id.summary_name_a);
        gamesInSetSummary.setText(message);
    }

    /**
     * This method displays all set points on the screen.
     */
    private void displaySummary(int a1, int b1, int a2, int b2, int a3, int b3, int a4, int b4, int a5, int b5) {

        TextView setSet1A = (TextView) findViewById(R.id.summary_set1_a);
        setSet1A.setText(Integer.toString(a1));

        TextView setSet1B = (TextView) findViewById(R.id.summary_set1_b);
        setSet1B.setText(Integer.toString(b1));

        TextView setSet2A = (TextView) findViewById(R.id.summary_set2_a);
        setSet2A.setText(Integer.toString(a2));

        TextView setSet2B = (TextView) findViewById(R.id.summary_set2_b);
        setSet2B.setText(Integer.toString(b2));

        TextView setSet3A = (TextView) findViewById(R.id.summary_set3_a);
        setSet3A.setText(Integer.toString(a3));

        TextView setSet3B = (TextView) findViewById(R.id.summary_set3_b);
        setSet3B.setText(Integer.toString(b3));

        TextView setSet4A = (TextView) findViewById(R.id.summary_set4_a);
        setSet4A.setText(Integer.toString(a4));

        TextView setSet4B = (TextView) findViewById(R.id.summary_set4_b);
        setSet4B.setText(Integer.toString(b4));

        TextView setSet5A = (TextView) findViewById(R.id.summary_set5_a);
        setSet5A.setText(Integer.toString(a5));

        TextView setSet5B = (TextView) findViewById(R.id.summary_set5_b);
        setSet5B.setText(Integer.toString(b5));

    }
}



