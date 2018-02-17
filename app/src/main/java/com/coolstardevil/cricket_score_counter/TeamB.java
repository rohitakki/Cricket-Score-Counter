package com.coolstardevil.cricket_score_counter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.coolstardevil.cricket_score_counter.TabMainActivity.ball;
import static com.coolstardevil.cricket_score_counter.TabMainActivity.overb;


public class TeamB extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teamb, container, false);

        TextView teamName = view.findViewById(R.id.teamBName);
        teamName.setText(String.valueOf(MainActivity.teamB));

        TextView scoreView = view.findViewById(R.id.team_a_scoreb);
        scoreView.setText(String.valueOf(TabMainActivity.scoreB));

        TextView wicketView = view.findViewById(R.id.wicketB);
        wicketView.setText(String.valueOf(TabMainActivity.wicketB));

        String overB = "Overs = " + overb + "." + ball;
        TextView ballView = view.findViewById(R.id.overB);
        ballView.setText(String.valueOf(overB));

        return view;
    }
}
