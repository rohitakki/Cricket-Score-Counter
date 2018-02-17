package com.coolstardevil.cricket_score_counter;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import static com.coolstardevil.cricket_score_counter.R.id.result;
import static com.coolstardevil.cricket_score_counter.R.id.team;
import static com.coolstardevil.cricket_score_counter.TabMainActivity.ball;
import static com.coolstardevil.cricket_score_counter.TabMainActivity.ballA;
import static com.coolstardevil.cricket_score_counter.TabMainActivity.overa;
import static com.coolstardevil.cricket_score_counter.TabMainActivity.overb;
import static com.coolstardevil.cricket_score_counter.TabMainActivity.scoreA;
import static com.coolstardevil.cricket_score_counter.TabMainActivity.scoreB;
import static com.coolstardevil.cricket_score_counter.TabMainActivity.wicketA;
import static com.coolstardevil.cricket_score_counter.TabMainActivity.wicketB;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private TextView toss;
    private Button button;
    protected Button win;
    public static String teamA="TEAM A";
    public static String teamB="TEAM B";
    String winner = "";
    private Button reset;
    Database mDatabase;
    private Button addButton,viewTeamDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.btnAdd);
        viewTeamDataButton = (Button) findViewById(R.id.btnView);
        mDatabase = new Database(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teamData = "\n\n"+teamA+"- "+scoreA+"/"+wicketA+" Ov- "+overa+"."+ballA+"\n"+teamB+"- "+scoreB+"/"+wicketB+" Ov- "+overb+"."+ball+"\n\n";
                AddData(teamData);

            }
        });

        viewTeamDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });

        reset = (Button) findViewById(R.id.resetall);
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Long press to RESET!", Toast.LENGTH_SHORT).show();
            }
        });

        reset.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                scoreA = scoreB = ballA = overa = overb = ball = wicketA = wicketB = 0;
                Toast.makeText(getApplicationContext(), "RESET!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        win = (Button) findViewById(result);
        win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (scoreA > scoreB) {
                    winner = teamA+" Wins!";
                    text.setText(teamA);
                } else if (scoreA == scoreB) {
                    winner = "Match Draw!";
                    text.setText("DRAW!");
                } else {
                    winner = teamB+" Wins!";
                    text.setText(teamB);
                }
                toss.setText(winner);
                Toast.makeText(getApplicationContext(), winner, Toast.LENGTH_LONG).show();
            }
        });


        text = (TextView) findViewById(team);
        toss = (TextView) findViewById(R.id.tossWin);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tossCoin();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button list = (Button) findViewById(R.id.button);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainToTab();
            }
        });
    }
private void mainToTab(){
    EditText team = (EditText) findViewById(R.id.teamA);
    teamA = team.getText().toString();
    EditText team2 = (EditText) findViewById(R.id.teamB);
    teamB = team2.getText().toString();
    if (team.getText().toString().length() == 0 || team2.getText().toString().length() == 0) {
        Toast.makeText(this, "Enter name first!", Toast.LENGTH_SHORT).show();
        return;
    }

        Intent i = new Intent(MainActivity.this, TabMainActivity.class);
        startActivity(i);
    }
    private void tossCoin() {
        EditText team = (EditText) findViewById(R.id.teamA);
        teamA = team.getText().toString();
        EditText team2 = (EditText) findViewById(R.id.teamB);
        teamB = team2.getText().toString();

        if (team.getText().toString().length() == 0 || team2.getText().toString().length() == 0) {
            Toast.makeText(this, "Enter name first!", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] select = {teamA, teamB};
        Random r = new Random();
        int n = r.nextInt(2);
        text.setText(select[n]);
        ObjectAnimator animation = ObjectAnimator.ofFloat(text, "rotationY", 1000f, 360f);
        animation.setDuration(500);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();
        if (n == 1) {
            String tosswinB = teamB + " Wins Toss!";
            toss.setText(tosswinB);

        } else {
            String tosswinA = teamA + " Wins Toss!";
            toss.setText(tosswinA);
        }
    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabase.addData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Saved!");
        } else {
            toastMessage("Something went wrong");
        }
    }


    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}
