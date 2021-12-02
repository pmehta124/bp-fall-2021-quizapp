package com.example.bp_fall_2021_quizapp;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class QuizQuestionActivity extends AppCompatActivity {


//    public RadioButton getChoice1() {
//
//    }
    // UI components here
    private TextView tvQuestion, tv_progress;
    private RadioButton choice1, choice2, choice3, choice4;
    private RadioGroup radioGroup;
    private ProgressBar progressBar;

    // other variables here
    private ArrayList<QuestionModel> qList;
    private QuestionModel currentQuestion;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        // create arraylist of questions
        qList = new ArrayList<QuestionModel>();

        // get username intent from main activity screen
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("namePrompt");

        // initialize views using findViewByID
        tvQuestion = findViewById(R.id.tv_question);
        tv_progress = findViewById(R.id.progressText);
        radioGroup = findViewById(R.id.radioGroup);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);
        progressBar = findViewById(R.id.progressBar);
        // use helper method to add question content to arraylist

        // get total number of questions

        // set progress bar

        // use helper method to proceed to next question
    }

    /**
     * Method that adds questions to our questions arraylist, using the Question Model constructor
     */
    private void addQuestions(){
        // question 1
 //       (String question, String opt1, String opt2, String opt3, String opt4, int correctAnsNum
    //    qList.add("What is New Jersey’s state fruit?", "Grape", "blue")
        // question 2

        // question 3

        // question 4

        // question 5

    }

    /**
     * Check the answer when user clicks submit and move on to next question
     */
    public void submitQuestion(View view){
        // if no options have been selected, prompt user to select an answer

        // use helper methods to check the answer and show the next question

    }

    /**
     * Display next question. If finished, move onto results screen
     */
    private void showNextQuestion(){

        // clear previous button selections

        // if you haven't gone through all the questions yet
            // set the question & text to the next question
            // increase question number
            // set progress bar

        // if finished with quiz, start Results activity

    }

    /**
     * Checks the answer and increases score if correct
     */
    private void checkAnswer(){
        // see which answer they picked

        // increase score if correct

    }
}