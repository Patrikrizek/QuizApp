package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the get results button is clicked.
     */
    public void displayScore(View view) {

        /**
         * This is input of the first question.
         */
        EditText nameInput = (EditText) findViewById(R.id.name_input);
        String capital = nameInput.getText().toString();

        /**
         * This is input of the second question.
         */
        CheckBox glass = (CheckBox) findViewById(R.id.glass_checkbox);
        boolean isGlass = glass.isChecked();

        CheckBox steel = (CheckBox) findViewById(R.id.steel_checkbox);
        boolean isSteel = steel.isChecked();

        CheckBox porcelain = (CheckBox) findViewById(R.id.porcelain_checkbox);
        boolean isPorcelain = porcelain.isChecked();

        CheckBox carpets = (CheckBox) findViewById(R.id.carpets_checkbox);
        boolean isCarpets = carpets.isChecked();

        /**
         * This is input of the third question.
         */
        RadioButton jagr = (RadioButton) findViewById(R.id.jagr_radio_button);
        boolean isJagr = jagr.isChecked();

        /**
         * This is input of the fourth question.
         */
        RadioButton beer = (RadioButton) findViewById(R.id.beer_radio_button);
        boolean isBeer = beer.isChecked();

        /**
         * This is input of the fifth question.
         */
        CheckBox lifeIs = (CheckBox) findViewById(R.id.lifeIs_checkbox);
        boolean isLifeIs = lifeIs.isChecked();

        CheckBox theUnbearable = (CheckBox) findViewById(R.id.theUnbearable_checkbox);
        boolean isTheUnbearable = theUnbearable.isChecked();

        CheckBox theUltimate = (CheckBox) findViewById(R.id.theUltimate_checkbox);
        boolean isTheUltimate = theUltimate.isChecked();

        int score = calculateScore(capital, isGlass, isSteel, isPorcelain, isCarpets, isJagr, isBeer, isLifeIs, isTheUnbearable, isTheUltimate);

        showAnswers (score);

    }

    /**
     * This method calculates score of the QuizApp and is called in displayScore method when the Get results button is clicked.
     */
    public int calculateScore(String capital, boolean isGlass, boolean isSteel, boolean isPorcelain, boolean isCarpets, boolean isJagr, boolean isBeer, boolean IsLifeIs, boolean isTheUnbearable, boolean isTheUltimate) {

        {
            int total = 0;

            /**
             * This controls answer of the first question.
             */
            if (capital.contentEquals("Prague")) {
                total += 1;
            }

            /**
             * This controls answer of the second question.
             */
            if (isGlass && !isSteel && isPorcelain && !isCarpets) {
                total += 1;
            }

            /**
             * This controls answer of the third question.
             */
            if (isJagr) {
                total += 1;
            }


            /**
             * This controls answer of the fourth question.
             */
            if (isBeer) {
                total += 1;
            }

            /**
             * This controls answer of the fifth question.
             */
            if (IsLifeIs && isTheUnbearable && !isTheUltimate) {
                total += 1;
            }

            return total;
        }

    }

    /**
     * This method displays the score and text in the toast.
     */
    private void showAnswers(int score) {
        if (score == 5) {
            Toast.makeText(this, R.string.excellent, Toast.LENGTH_LONG).show();
        } else if (score == 4) {
            Toast.makeText(this, R.string.great, Toast.LENGTH_LONG).show();
        } else if (score == 3) {
            Toast.makeText(this, R.string.good, Toast.LENGTH_LONG).show();
        } else if (score == 2) {
            Toast.makeText(this, R.string.sufficient, Toast.LENGTH_LONG).show();
        } else if (score == 1) {
            Toast.makeText(this, R.string.insufficient, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, R.string.oh_no, Toast.LENGTH_LONG).show();
        }
        return;
    }

}