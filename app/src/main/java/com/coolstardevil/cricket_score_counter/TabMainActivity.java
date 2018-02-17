package com.coolstardevil.cricket_score_counter;

import android.support.v7.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.coolstardevil.cricket_score_counter.MainActivity;
import com.coolstardevil.cricket_score_counter.R;
import com.coolstardevil.cricket_score_counter.TabPageAdapter;
import com.coolstardevil.cricket_score_counter.TeamA;
import com.coolstardevil.cricket_score_counter.TeamB;

public class TabMainActivity extends AppCompatActivity {
    public static int scoreA = 0;
    public static int scoreB = 0;
    static int ballA = 0;
    static int overa = 0;
    static int ball = 0;
    static int overb = 0;
    static String overB = "";
    static String overA = "";
    static int wicketA = 0;
    static int wicketB = 0;
    public static final String SaveA = "SaveRecordsA";
    public static final String SaveB = "SaveRecordsB";

    private TabPageAdapter mTabPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        redoA(scoreA);
        redoB(scoreB);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity_main);
        mTabPageAdapter = new TabPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        TabPageAdapter adapter = new TabPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new TeamA(), MainActivity.teamA);
        adapter.addFragment(new TeamB(), MainActivity.teamB);
        viewPager.setAdapter(adapter);
    }

    //TEAM A onClick And Methods
    public void SixPointsA(View view) {
        storeA(scoreA);
        scoreA = scoreA + 6;
        displayForTeamA(scoreA);
        overA();
    }

    public void fourPointsA(View view) {
        storeA(scoreA);
        scoreA = scoreA + 4;
        displayForTeamA(scoreA);
        overA();
    }

    public void twoPointA(View view) {
        storeB(scoreA);
        scoreA = scoreA + 2;
        displayForTeamA(scoreA);
        overA();
    }

    public void oneRunA(View view) {
        storeB(scoreA);
        scoreA = scoreA + 1;
        displayForTeamA(scoreA);
        overA();
    }

    public void dotA(View view) {
        storeA(scoreA);
        overA();
    }

    public void oneRunAA(View view) {
        storeA(scoreA);
        scoreA = scoreA + 1;
        displayForTeamA(scoreA);
    }

    public void wicketA(View view) {
        storeA(scoreA);
        if (wicketA >= 9) {
            wicketA = wicketA + 1;
            wicketDisplayA(wicketA);
            overA();
            buttonA(false);
            com.cuboid.cuboidcirclebutton.CuboidButton btn10A = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.decWicketA);
            btn10A.setEnabled(true);
            return;
        }
        wicketA = wicketA + 1;
        wicketDisplayA(wicketA);
        overA();
    }

    public void overA() {
        if (ballA < 5) {
            ballA = ballA + 1;
            overA = "Balls = " + overa + "." + ballA;
            overDisplayA(overA);

        } else {
            overa = overa + 1;
            ballA = 0;
            overA = "Balls = " + overa + "." + ballA;
            overDisplayA(overA);
        }
    }

    public void decOneRunA(View view) {
        storeA(scoreA);
        if (scoreA == 0) {
            return;
        }
        scoreA = scoreA - 1;
        displayForTeamA(scoreA);
    }

    public void decWicketA(View view) {
        storeA(scoreA);
        if (wicketA == 0) {
            return;
        }
        wicketA = wicketA - 1;
        wicketDisplayA(wicketA);
        //Enable button
        buttonA(true);
    }

    public void decBallA(View view) {
        storeA(scoreA);
        if (ballA == 0 && overa == 0) {
            return;
        }
        if (ballA > 0) {
            ballA = ballA - 1;
            overA = "Balls = " + overa + "." + ballA;
            overDisplayA(overA);
        } else if (ballA == 0) {
            overa = overa - 1;
            overA = "Balls = " + overa + "." + ballA;
            ballA = 6;
            overDisplayA(overA);
            if (ballA >= 0) {
                ballA = ballA - 1;
                overA = "Balls = " + overa + "." + ballA;
                overDisplayA(overA);
            }
        }
    }


    public  void buttonA(boolean dec) {
        Button btnB = (Button) findViewById(R.id.sixRunA);
        btnB.setEnabled(dec);
        Button btn1B = (Button) findViewById(R.id.fourRunA);
        btn1B.setEnabled(dec);
        Button btn2B = (Button) findViewById(R.id.twoRunA);
        btn2B.setEnabled(dec);
        Button btn3B = (Button) findViewById(R.id.oneRunA);
        btn3B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn4B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.wdA);
        btn4B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn5B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.nbA);
        btn5B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn6B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.dotA);
        btn6B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn7B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.wkA);
        btn7B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn8B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.decOneRunA);
        btn8B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn9B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.decBallA);
        btn9B.setEnabled(dec);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreA);
        scoreView.setText(String.valueOf(score));
    }

    public void overDisplayA(String overA) {
        TextView overView = (TextView) findViewById(R.id.overA);
        overView.setText(String.valueOf(overA));
    }

    public void wicketDisplayA(int wicketA) {
        TextView overView = (TextView) findViewById(R.id.wicketA);
        overView.setText(String.valueOf(wicketA));
    }
    public void restoreA(View view) {
        redoA(scoreA);
        SharedPreferences load = getSharedPreferences(SaveA, 0);
        scoreA = load.getInt("scoreTeamA", 0);
        ballA = load.getInt("ballTeamA", 0);
        overa = load.getInt("overTeamA", 0);
        wicketA = load.getInt("wicketTeamA", 0);

        if (wicketA == 10) {
            buttonB(false);
            com.cuboid.cuboidcirclebutton.CuboidButton btn10B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.decWicketA);
            btn10B.setEnabled(true);
        }

        displayForTeamA(scoreA);
        overA = "Balls = " + overa + "." + ballA;
        overDisplayA(overA);
        buttonA(true);
        wicketDisplayA(wicketA);

    }

    public void storeA(int scoreA) {
        SharedPreferences save = getSharedPreferences(SaveA, MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("scoreTeamA", scoreA).putInt("ballTeamA", ballA).putInt("overTeamA", overa).putInt("wicketTeamA", wicketA);
        editor.apply();
    }

    public void redoA(View view) {
        SharedPreferences load = getSharedPreferences("redoA", 0);
        scoreA = load.getInt("scoreTeamA", 0);
        ballA = load.getInt("ballTeamA", 0);
        overa = load.getInt("overTeamA", 0);
        wicketA = load.getInt("wicketTeamA", 0);

        if (wicketA == 10) {
            buttonB(false);
            com.cuboid.cuboidcirclebutton.CuboidButton btn10B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.decWicketA);
            btn10B.setEnabled(true);
        }

        displayForTeamA(scoreA);
        overA = "Balls = " + overa + "." + ballA;
        overDisplayA(overA);
        buttonA(true);
        wicketDisplayA(wicketA);

    }
    public void redoA(int scoreA) {
        SharedPreferences save = getSharedPreferences("redoA", MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("scoreTeamA", scoreA).putInt("ballTeamA", ballA).putInt("overTeamA", overa).putInt("wicketTeamA", wicketA);
        editor.apply();
    }
    //TEAM B onClick And Methods
    public void SixPointsB(View view) {
        storeB(scoreB);
        scoreB = scoreB + 6;
        displayForTeamB(scoreB);
        overB();

    }

    public void fourPointsB(View view) {
        storeB(scoreB);
        scoreB = scoreB + 4;
        displayForTeamB(scoreB);
        overB();
    }

    public void twoPointB(View view) {
        storeB(scoreB);
        scoreB = scoreB + 2;
        displayForTeamB(scoreB);
        overB();
    }

    public void oneRunB(View view) {
        storeB(scoreB);
        scoreB = scoreB + 1;
        displayForTeamB(scoreB);
        overB();
    }

    public void dotB(View view) {
        storeB(scoreB);
        overB();
    }

    public void oneRunBB(View view) {
        storeB(scoreB);
        scoreB = scoreB + 1;
        displayForTeamB(scoreB);
    }

    public void wicketB(View view) {
        storeB(scoreB);
        if (wicketB >= 9) {
            wicketB = wicketB + 1;
            wicketDisplayB(wicketB);
            overB();
            buttonB(false);
            com.cuboid.cuboidcirclebutton.CuboidButton btn10B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.decWicketB);
            btn10B.setEnabled(true);
            return;
        }
        wicketB = wicketB + 1;
        wicketDisplayB(wicketB);
        overB();
    }

    public void overB() {
        if (ball < 5) {
            ball = ball + 1;
            overB = "Balls = " + overb + "." + ball;
            overDisplayB(overB);

        } else {
            overb = overb + 1;
            ball = 0;
            overB = "Balls = " + overb + "." + ball;
            overDisplayB(overB);
        }
    }

    public void decOneRunB(View view) {
        storeB(scoreB);
        if (scoreB == 0) {
            return;
        }
        scoreB = scoreB - 1;
        displayForTeamB(scoreB);
    }

    public void decWicketB(View view) {
        storeB(scoreB);
        if (wicketB == 0) {
            return;
        }
        wicketB = wicketB - 1;
        wicketDisplayB(wicketB);
        //Enable button
        buttonB(true);
    }

    public void decBallB(View view) {
        storeB(scoreB);
        if (ball == 0 && overb == 0) {
            return;
        }
        if (ball > 0) {
            ball = ball - 1;
            overB = "Balls = " + overb + "." + ball;
            overDisplayB(overB);
        } else if (ball == 0) {
            overb = overb - 1;
            overB = "Balls = " + overb + "." + ball;
            ball = 6;
            overDisplayB(overB);
            if (ball >= 0) {
                ball = ball - 1;
                overB = "Balls = " + overb + "." + ball;
                overDisplayB(overB);
            }
        }
    }


    public void buttonB(boolean dec) {
        Button btnB = (Button) findViewById(R.id.sixRunB);
        btnB.setEnabled(dec);
        Button btn1B = (Button) findViewById(R.id.fourRunB);
        btn1B.setEnabled(dec);
        Button btn2B = (Button) findViewById(R.id.twoRunB);
        btn2B.setEnabled(dec);
        Button btn3B = (Button) findViewById(R.id.oneRunB);
        btn3B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn4B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.wdB);
        btn4B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn5B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.nbB);
        btn5B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn6B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.dotB);
        btn6B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn7B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.wkB);
        btn7B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn8B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.decOneRunB);
        btn8B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn9B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.decBallB);
        btn9B.setEnabled(dec);
        com.cuboid.cuboidcirclebutton.CuboidButton btn10B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.wkB);
        btn10B.setEnabled(dec);
    }

    public void restoreB(View view) {
        redoB(scoreB);
        SharedPreferences load = getSharedPreferences(SaveB, 0);
        scoreB = load.getInt("scoreTeamB", 0);
        ball = load.getInt("ballTeamB", 0);
        overb = load.getInt("overTeamB", 0);
        wicketB = load.getInt("wicketTeamB", 0);

        if (wicketB == 10) {
            buttonB(false);
            com.cuboid.cuboidcirclebutton.CuboidButton btn10B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.decWicketB);
            btn10B.setEnabled(true);
        }

        displayForTeamB(scoreB);
        overB = "Balls = " + overb + "." + ball;
        overDisplayB(overB);
        buttonB(true);
        wicketDisplayB(wicketB);

    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreb);
        scoreView.setText(String.valueOf(score));
    }


    public void overDisplayB(String overB) {
        TextView overView = (TextView) findViewById(R.id.overB);
        overView.setText(String.valueOf(overB));
    }

    public void wicketDisplayB(int wicketB) {
        TextView overView = (TextView) findViewById(R.id.wicketB);
        overView.setText(String.valueOf(wicketB));
    }

    public void storeB(int scoreB) {
        SharedPreferences save = getSharedPreferences(SaveB, MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("scoreTeamB", scoreB).putInt("ballTeamB", ball).putInt("overTeamB", overb).putInt("wicketTeamB", wicketB);
        editor.apply();
    }
    public void redoB(int scoreB) {
        SharedPreferences save = getSharedPreferences("redoB", MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("scoreTeamB", scoreB).putInt("ballTeamB", ball).putInt("overTeamB", overb).putInt("wicketTeamB", wicketB);
        editor.apply();
    }

    public void redoB(View view) {
        SharedPreferences load = getSharedPreferences("redoB", 0);
        scoreB = load.getInt("scoreTeamB", 0);
        ball = load.getInt("ballTeamB", 0);
        overb = load.getInt("overTeamB", 0);
        wicketB = load.getInt("wicketTeamB", 0);

        if (wicketB == 10) {
            buttonB(false);
            com.cuboid.cuboidcirclebutton.CuboidButton btn10B = (com.cuboid.cuboidcirclebutton.CuboidButton) findViewById(R.id.decWicketB);
            btn10B.setEnabled(true);
        }

        displayForTeamB(scoreB);
        overB = "Balls = " + overb + "." + ball;
        overDisplayB(overB);
        buttonB(true);
        wicketDisplayB(wicketB);
    }
}
