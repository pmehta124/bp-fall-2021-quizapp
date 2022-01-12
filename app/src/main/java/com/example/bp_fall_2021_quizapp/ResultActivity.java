package com.example.bp_fall_2021_quizapp;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    // UI component variables
    //create results page: score, name, length

    private TextView result;
    private TextView finalComment;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // initialize UI components
        name = findViewById(R.id.name);
        result = findViewById(R.id.result);
        finalComment = findViewById(R.id.answers);

        // set username and score
        Bundle bundle = getIntent().getExtras();
        String usernameOfPerson = bundle.getString("username");
        int score = bundle.getInt("Score");
        int length = bundle.getInt("totalQuestions");

        name.setText("Congrats " + usernameOfPerson + "!");
        result.setText("Your result is" + score + "/" +length);
        finalComment.setText("The answers to the quiz were blueberry, Beyonce, Acropolis of Athens - Greece, Greece, 13");
    }

    /**
     * Restarts the quiz so you can play another round
     * @param view
     */
    public void restart(View view) {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
    }
}