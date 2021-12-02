package com.example.bp_fall_2021_quizapp;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class QuizQuestionActivity extends AppCompatActivity {

    // UI components here

    // other variables here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        // create arraylist of questions
        ArrayList<QuestionModel> qList = new ArrayList<QuestionModel>();
        // get username intent from main activity screen
        savedInstanceState.get(namePrompt);
        // initialize views using findViewByID

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