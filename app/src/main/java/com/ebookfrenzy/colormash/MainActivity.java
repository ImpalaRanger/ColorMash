package com.ebookfrenzy.colormash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;


public class MainActivity extends AppCompatActivity {

    // tracks user's current rgb values
    public int[] rgbs = {-1, -1, -1};
    // available colors to mash
    public indivColor red = new indivColor("red", 255, 0, 0);
    public indivColor blue = new indivColor("blue", 0, 0, 255);
    public indivColor yellow = new indivColor("yellow", 255, 255, 0);
    public indivColor green = new indivColor("green", 0, 255, 0);
    public indivColor pink = new indivColor("pink", 255, 0, 255);
    public indivColor teal = new indivColor("teal", 0, 255, 255);
    public indivColor white = new indivColor("white", 255, 255, 255);
    public indivColor black = new indivColor("black", 0, 0, 0);
    public indivColor[] colorOptions = {red, blue, yellow, green, pink, teal, white, black};

    int turnsTaken = 0;

    private double score = 0;

    // used to calculate final score
    private int newRed = 0;
    private int newGreen = 0;
    private int newBlue = 0;

    // rgb values of the goal color
    private int[] goalColorArr = {0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRed = (Button) findViewById(R.id.btnRed);
        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ConstraintLayout mixedPalette = (ConstraintLayout) findViewById(R.id.mixedPalette);
                //mixedPalette.setBackgroundColor(Color.rgb(255, 0, 0));

                if (red.isSelected() == 1) {
                    System.out.println("DEBUG: Red deselected");
                    btnRed.setText("");
                    red.setSelected(0);
                }
                else {
                    System.out.println("DEBUG: Red selected");
                    btnRed.setText("+");
                    red.setSelected(1);
                }
            }
        });

        Button btnBlue = (Button) findViewById(R.id.btnBlue);
        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ConstraintLayout mixedPalette = (ConstraintLayout) findViewById(R.id.mixedPalette);
                //mixedPalette.setBackgroundColor(Color.rgb(0, 0, 255));
                if (blue.isSelected() == 1) {
                    System.out.println("DEBUG: blue deselected");
                    btnBlue.setText("");
                    blue.setSelected(0);
                }
                else {
                    System.out.println("DEBUG: blue selected");
                    btnBlue.setText("+");
                    blue.setSelected(1);
                }
            }
        });

        Button btnYellow = (Button) findViewById(R.id.btnYellow);
        btnYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ConstraintLayout mixedPalette = (ConstraintLayout) findViewById(R.id.mixedPalette);
                //mixedPalette.setBackgroundColor(Color.rgb(255, 255, 0));

                if (yellow.isSelected() == 1) {
                    System.out.println("DEBUG: yellow deselected");
                    btnYellow.setText("");
                    yellow.setSelected(0);
                }
                else {
                    System.out.println("DEBUG: yellow selected");
                    btnYellow.setText("+");
                    yellow.setSelected(1);
                }
            }
        });

        Button btnGreen = (Button) findViewById(R.id.btnGreen);
        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ConstraintLayout mixedPalette = (ConstraintLayout) findViewById(R.id.mixedPalette);
                //mixedPalette.setBackgroundColor(Color.rgb(0, 255, 0));

                if (green.isSelected() == 1) {
                    System.out.println("DEBUG: green deselected");
                    btnGreen.setText("");
                    green.setSelected(0);
                }
                else {
                    System.out.println("DEBUG: green selected");
                    btnGreen.setText("+");
                    green.setSelected(1);
                }
            }
        });

        Button btnPink = (Button) findViewById(R.id.btnPink);
        btnPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ConstraintLayout mixedPalette = (ConstraintLayout) findViewById(R.id.mixedPalette);
                //mixedPalette.setBackgroundColor(Color.rgb(0, 255, 0));

                if (pink.isSelected() == 1) {
                    System.out.println("DEBUG: pink deselected");
                    btnPink.setText("");
                    pink.setSelected(0);
                }
                else {
                    System.out.println("DEBUG: pink selected");
                    btnPink.setText("+");
                    pink.setSelected(1);
                }
            }
        });

        Button btnTeal = (Button) findViewById(R.id.btnTeal);
        btnTeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ConstraintLayout mixedPalette = (ConstraintLayout) findViewById(R.id.mixedPalette);
                //mixedPalette.setBackgroundColor(Color.rgb(0, 255, 0));

                if (teal.isSelected() == 1) {
                    System.out.println("DEBUG: teal deselected");
                    btnTeal.setText("");
                    teal.setSelected(0);
                }
                else {
                    System.out.println("DEBUG: teal selected");
                    btnTeal.setText("+");
                    teal.setSelected(1);
                }
            }
        });

        Button btnWhite = (Button) findViewById(R.id.btnWhite);
        btnWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ConstraintLayout mixedPalette = (ConstraintLayout) findViewById(R.id.mixedPalette);
                //mixedPalette.setBackgroundColor(Color.rgb(0, 255, 0));

                if (white.isSelected() == 1) {
                    System.out.println("DEBUG: white deselected");
                    btnWhite.setText("");
                    white.setSelected(0);
                }
                else {
                    System.out.println("DEBUG: white selected");
                    btnWhite.setText("+");
                    white.setSelected(1);
                }
            }
        });

        Button btnBlack = (Button) findViewById(R.id.btnBlack);
        btnBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ConstraintLayout mixedPalette = (ConstraintLayout) findViewById(R.id.mixedPalette);
                //mixedPalette.setBackgroundColor(Color.rgb(0, 255, 0));

                if (black.isSelected() == 1) {
                    System.out.println("DEBUG: black deselected");
                    btnBlack.setText("");
                    black.setSelected(0);
                }
                else {
                    System.out.println("DEBUG: black selected");
                    btnBlack.setText("+");
                    black.setSelected(1);
                }
            }
        });

        // sets goal color on initial launch
        resetGoalColor();

        Button btnMix = (Button) findViewById(R.id.btnMix);
        btnMix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int numSelected = 0;
                int redTotal = 0;
                int greenTotal = 0;
                int blueTotal = 0;

                for (indivColor col : colorOptions) {
                    System.out.println(col.getName() + ": " + col.isSelected());

                    if (col.isSelected() == 1) {
                        redTotal += col.getRed();
                        greenTotal += col.getGreen();
                        blueTotal += col.getBlue();
                        numSelected++;
                        System.out.println(col.getName() + " has been added.");
                    }
                }
                // user must select at least 1 color
                if (numSelected != 0) {
                    TextView output = (TextView) findViewById(R.id.textView);
                    output.setText("");
                    ConstraintLayout mixedPalette = (ConstraintLayout) findViewById(R.id.mixedPalette);

                    int currentRed = redTotal / numSelected;
                    int currentGreen = greenTotal / numSelected;
                    int currentBlue = blueTotal / numSelected;

                    if (turnsTaken != 0) {
                        newRed = (currentRed + rgbs[0]) / 2;
                        newGreen = (currentGreen + rgbs[1]) / 2;
                        newBlue = (currentBlue + rgbs[2]) / 2;
                    }
                    else {
                        newRed = currentRed;
                        newGreen = currentGreen;
                        newBlue = currentBlue;
                    }

                    // saves current turn mix to arr
                    rgbs[0] = newRed;
                    rgbs[1] = newGreen;
                    rgbs[2] = newBlue;
                    mixedPalette.setBackgroundColor(Color.rgb(newRed, newGreen, newBlue));
                    turnsTaken++;
                }
                else {
                    System.out.println("No colors selected");
                    TextView output = (TextView) findViewById(R.id.textView);
                    output.setText("You must select at least one color");
                }
            }
        });

        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // user cannot submit without taking at least one turn
                if (turnsTaken != 0) {
                    // score calculated as percentage of average in differences between user's rgb values and goal rgb values
                    int redScore = Math.abs(goalColorArr[0] - newRed);
                    int greenScore = Math.abs(goalColorArr[1] - newGreen);
                    int blueScore = Math.abs(goalColorArr[2] - newBlue);

                    double numScore = 255 - ((redScore + greenScore + blueScore) / 3);
                    score = (numScore / 255) * 100;

                    //displays final score dialog box
                    showScore(score);
                    // resets turn counter
                    turnsTaken = 0;
                    // resets score
                    score = 0;
                    // resets color palettes
                    resetGoalColor();
                    rgbs[0] = -1;
                    rgbs[1] = -1;
                    rgbs[2] = -1;

                    // resets user's display palette back to black
                    ConstraintLayout mixedPalette = (ConstraintLayout) findViewById(R.id.mixedPalette);
                    mixedPalette.setBackgroundColor(Color.rgb(0, 0, 0));
                }
                else {
                    System.out.println("No turns taken");
                    TextView output = (TextView) findViewById(R.id.textView);
                    output.setText("You must mash at least one color");
                }
            }
        });
    }

    // shows dialog box containing final score
    public void showScore(double score) {
        scoreDialog dialog = new scoreDialog();
        Bundle bundle = new Bundle();
        bundle.putString("SCORE", "You mashed the color with " + new DecimalFormat("#.##").format(score) + "% accuracy!");
        dialog.setArguments(bundle);
        dialog.show(getSupportFragmentManager(), "score dialog");
    }

    // resets every value pertaining to the goal color
    public void resetGoalColor() {
        // sets random values for red, green, blue within range [1,255)
        int randNum = ThreadLocalRandom.current().nextInt(1, 256);
        goalColorArr[0] = randNum;
        randNum = ThreadLocalRandom.current().nextInt(1, 256);
        goalColorArr[1] = randNum;
        randNum = ThreadLocalRandom.current().nextInt(1, 256);
        goalColorArr[2] = randNum;
        ConstraintLayout goalDisplay = (ConstraintLayout) findViewById(R.id.goalColor);
        goalDisplay.setBackgroundColor(Color.rgb(goalColorArr[0], goalColorArr[1], goalColorArr[2]));
    }
}