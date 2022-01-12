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
    int length;
    int count;

    int score = 0;

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
        addQuestions();

        // get total number of questions
        length = qList.size();

        // set progress bar
        progressBar.setProgress(0);
        count = 0;
        tv_progress.setText(count + "/" + length);

        // use helper method to proceed to next question
        showNextQuestion();
    }

    /**
     * Method that adds questions to our questions arraylist, using the Question Model constructor
     */
    private void addQuestions(){

        // question 1
        QuestionModel one = new QuestionModel("What is New Jersey’s state fruit?", "Grape", "Blueberry", "Raspberry", "Cherry", 2);
        qList.add(one);
        // question 2
        QuestionModel two = new QuestionModel("Which female singer has won the most Grammys?", "Aretha Franklin", "Taylor Swift", "Beyoncé", "Katy Perry", 3);
        qList.add(two);
        // question 3
        QuestionModel three = new QuestionModel("Which of the following is not currently one of the 7 wonders of the world?", "Acropolis of Athens - Greece", "Chichen Itza - Mexico", "Machu Picchu - Peru", "Petra - Jordan", 1);
        qList.add(three);
        // question 4
        QuestionModel four = new QuestionModel("Where was the first Olympics held in 1896?", "Germany", "Greece", "France", "Spain", 2);
        qList.add(four);
        // question 5
        QuestionModel five = new QuestionModel("How many rings does Uranus have?", "0", "7", "11", "13", 4);
        qList.add(five);
    }

    /**
     * Check the answer when user clicks submit and move on to next question
     */
    public void submitQuestion(View view) {
        // if no options have been selected, prompt user to select an answer
        if (!(choice1.isChecked() || choice2.isChecked() || choice3.isChecked() || choice4.isChecked())) {
            Toast.makeText(getBaseContext(), "Please select an answer", Toast.LENGTH_SHORT).show();
        }

        // use helper methods to check the answer and show the next question
        else {
            checkAnswer();
            showNextQuestion();
        }
    }

    /**
     * Display next question. If finished, move onto results screen
     */
    private void showNextQuestion(){

        // clear previous button selections
        radioGroup.clearCheck();

        // if you haven't gone through all the questions yet
            // set the question & text to the next question
            // increase question number
            // set progress bar
        if(count < length) {
            currentQuestion = qList.get(count);
            tvQuestion.setText(currentQuestion.getQuestion());
            choice1.setText(currentQuestion.getOpt1());
            choice2.setText(currentQuestion.getOpt2());
            choice3.setText(currentQuestion.getOpt3());
            choice4.setText(currentQuestion.getOpt4());
            count++;

            progressBar.setProgress(count);
            tv_progress.setText(count + "/" + length);
        } else {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("totalQuestions", length);
            intent.putExtra("Score", score);
            intent.putExtra("Name", name);
            startActivity(intent);
        }
        // if finished with quiz, start Results activity
    }

    /**
     * Checks the answer and increases score if correct
     */
    private void checkAnswer(){
        // see which answer they picked
        RadioButton radioChoice = findViewById(radioGroup.getCheckedRadioButtonId());

        // increase score if correct
        int answerNum = radioGroup.indexOfChild(radioChoice);
        if(answerNum == currentQuestion.getCorrectAnsNum()) {
            score++;
        }
    }
}