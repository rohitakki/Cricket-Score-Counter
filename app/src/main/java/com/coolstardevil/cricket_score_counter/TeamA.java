package com.coolstardevil.cricket_score_counter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.coolstardevil.cricket_score_counter.TabMainActivity.ballA;
import static com.coolstardevil.cricket_score_counter.TabMainActivity.overa;


public class TeamA extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teama, container, false);
        TextView teamName = view.findViewById(R.id.teamAName);
        teamName.setText(String.valueOf(MainActivity.teamA));

        TextView scoreView = view.findViewById(R.id.team_a_scoreA);
        scoreView.setText(String.valueOf(TabMainActivity.scoreA));

        TextView wicketView = view.findViewById(R.id.wicketA);
        wicketView.setText(String.valueOf(TabMainActivity.wicketA));

        String overA = "Overs = " + overa + "." + ballA;
        TextView ballView = view.findViewById(R.id.overA);
        ballView.setText(String.valueOf(overA));

        return view;
    }
}
