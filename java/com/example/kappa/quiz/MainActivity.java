package com.example.kappa.quiz;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;

import static android.R.attr.drawable;
import static android.R.attr.id;
import static com.example.kappa.quiz.R.id.streak;

public class MainActivity extends AppCompatActivity {

    private QuestionLib QuestionLibrary = new QuestionLib();
    private static final String QUESTION__NUM = "QuestionNumber";
    private static final String TAG = "MainActivity";

    private int prevHighScore,prevStreak;
    private int streakFinal=0;
    private TextView ViewScore;
    private TextView ViewStreak;
    private TextView ViewChance;
    private TextView ViewQuestion;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private ImageView img;


    private String mAnswer;
    private int mScore = 0;
    private int mStreak = 0;
    private int chance = 5;
    private int mQuestionNumber = 0;
    private int i = 0;
    private int FHighScore, FHighStreak;

    //array of image reference
    int[] myImageList = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3,R.drawable.img4,
            R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,
            R.drawable.img10,R.drawable.img11,R.drawable.img12,R.drawable.img13,R.drawable.img14,
            R.drawable.img15,R.drawable.img16,R.drawable.img17,R.drawable.wk};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadScore();
        LoadStreak();


        ViewScore = (TextView) findViewById(R.id.score);
        ViewStreak = (TextView) findViewById(R.id.streak);
        ViewChance = (TextView) findViewById(R.id.chance);
        ViewQuestion = (TextView) findViewById(R.id.question);
        choice1 = (Button) findViewById(R.id.choice1);
        choice2 = (Button) findViewById(R.id.choice2);
        choice3 = (Button) findViewById(R.id.choice3);
        img = (ImageView) findViewById(R.id.image);

        updateimage();
        updatequestion();
        updatchance(chance);


        if (savedInstanceState != null) {
            mQuestionNumber = savedInstanceState.getInt(QUESTION__NUM, 0);

        }


        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice1.getText() == mAnswer) {
                    mStreak = mStreak + 1;
                    //users gets bonus points if they are on a streak
                    calcScore();
                    //update score function
                    updatescore(mScore);
                    //update streak function
                    updatestreak(mStreak);
                    //compare and assign longer streak
                    compareStreak();
                    //update question
                    updatequestion();
                    //update image for each question
                    updateimage();
                    if (mQuestionNumber==18){
                        endGame();
                    }
                    //toast to show if the answer is correct
                    Toast.makeText(MainActivity.this, (R.string.Correct), Toast.LENGTH_SHORT).show();

                }
                 else{
                    //if incorrect answer is chosen, streak will end player will not receive bonus points
                    mStreak=0;
                    updatestreak(mStreak);
                    //chance if reduced if answer is wrong
                    chance--;
                //toast to show if the answer is incorrect
                Toast.makeText(MainActivity.this, (R.string.Incorrect), Toast.LENGTH_SHORT).show();
                //update chance on textview
                updatchance(chance);
                //if no more chance then show end game dialog
                if (chance <= 0) {
                    endGame();
                }}
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice2.getText() == mAnswer) {
                    mStreak = mStreak + 1;
                    calcScore();
                    updatescore(mScore);
                    updatestreak(mStreak);
                    compareStreak();
                    updatequestion();
                    updateimage();
                    if (mQuestionNumber==18){
                        endGame();
                    }
                    Toast.makeText(MainActivity.this, (R.string.Correct), Toast.LENGTH_SHORT).show();
                }
                 else{
                    mStreak=0;
                    updatestreak(mStreak);
                    chance--;
                Toast.makeText(MainActivity.this, (R.string.Incorrect), Toast.LENGTH_SHORT).show();
                updatchance(chance);
                if (chance <= 0) {
                    endGame();
                }}
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice3.getText() == mAnswer) {
                    mStreak = mStreak + 1;
                    calcScore();
                    updatescore(mScore);
                    updatestreak(mStreak);
                    compareStreak();
                    updatequestion();
                    updateimage();
                    if (mQuestionNumber==18){
                        endGame();
                    }
                    Toast.makeText(MainActivity.this, (R.string.Correct), Toast.LENGTH_SHORT).show();

                } else{
                    mStreak=0;
                    updatestreak(mStreak);
                    chance--;
                Toast.makeText(MainActivity.this, (R.string.Incorrect), Toast.LENGTH_SHORT).show();
                updatchance(chance);
                if (chance <= 0) {
                    endGame();
                }}
            }
        });

    }
    //update questions and choices
    public void updatequestion() {
        ViewQuestion.setText(QuestionLibrary.getQuestion(mQuestionNumber));
        choice1.setText(QuestionLibrary.getChoice1(mQuestionNumber));
        choice2.setText(QuestionLibrary.getChoice2(mQuestionNumber));
        choice3.setText(QuestionLibrary.getChoice3(mQuestionNumber));
        mAnswer = QuestionLibrary.getAnswer(mQuestionNumber);
        mQuestionNumber++;
    }

    private void updateimage(){
        img.setImageResource(myImageList[i]);
        i++;
    }

    private void updatescore(int point) {
        ViewScore.setText("" + mScore);
    }

    //bonus if player answer certain number of questions correctly in a row
    private void calcScore(){
        if (mStreak < 3) {
            mScore = mScore + 100;
        } else if (mStreak == 3)
            mScore = mScore + 130;
        else if (mStreak == 4)
            mScore = mScore + 140;
        else if (mStreak == 5)
            mScore = mScore + 150;
        else if (mStreak == 6)
            mScore = mScore + 160;
        else if (mStreak == 7)
            mScore = mScore + 170;
        else if (mStreak == 8)
            mScore = mScore + 180;
        else if (mStreak == 9)
            mScore = mScore + 190;
        else
            mScore = mScore + 200;
    }

    //update chances on textview
    private void updatestreak(int astreak) {
        ViewStreak.setText("" + mStreak);
    }

    private void updatchance(int chances) {
        ViewChance.setText("" + chance);

    }

    //show end game dialog and allow user to choose if they want to replay or return to menu
    private void endGame() {
        //show end game alert dialog
        TextView dialogTitle = new TextView(this);
        dialogTitle.setText("Game Over!");
        dialogTitle.setGravity(Gravity.CENTER);
        dialogTitle.setTextSize(23);

        TextView dialogMessage = new TextView(this);
        dialogMessage.setText("Score: " + mScore + "\nLongest streak: " + mStreak);
        dialogMessage.setGravity(Gravity.CENTER);
        dialogMessage.setTextSize(19);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCustomTitle(dialogTitle);
        dialog.setView(dialogMessage);
        dialog.setCancelable(false);
        dialog.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            //restart activity
            @Override
            public void onClick(DialogInterface dialog, int which) {
                recreate();
            }
        });
        dialog.setNegativeButton("Return to Main Menu", new DialogInterface.OnClickListener() {
            //finish and return to main menu
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });
        dialog.show();
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(QUESTION__NUM, mQuestionNumber);
    }

    //set highscore if activity is destroyed

    protected void onDestroy() {
        endGameScore();
        endGameStreak();
        super.onDestroy();
    }

    //save score using SharedPreferences
    public void SaveScore(String HighScore, int score2) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("HighScore", score2);
        editor.commit();
    }

    //load score using SharedPreferences
    public void LoadScore() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prevHighScore = prefs.getInt("HighScore", 0);
    }

    //save streak using SharedPreferences
    public void SaveStreak(String Streak, int streakFinal) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Streak", streakFinal);
        editor.commit();
    }

    //load streak using SharedPreferences
    public void LoadStreak() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prevStreak = prefs.getInt("Streak", 0);
    }

    //compare current streak and highest streak
    private void compareStreak() {
        if (mStreak > streakFinal) {
            streakFinal = mStreak;
        }
    }

    //compare session streak and previous longest streak
    private void endGameStreak() {
        if (streakFinal > prevStreak) {
            SaveStreak("Streak", streakFinal);
        }
    }

    //check for high score
    private void endGameScore() {
        if (mScore > prevHighScore) {
            SaveScore("HighScore", mScore);
        }
    }


}





