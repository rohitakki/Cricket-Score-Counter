package com.coolstardevil.cricket_score_counter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.coolstardevil.cricket_score_counter.ListDataActivity.adapter;


public class EditDataActivity extends AppCompatActivity {

    private Button deleteButton;

    Database mDatabase;

    private String selectedTeamName;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_layout);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.4),(int)(height*.2));
        deleteButton = (Button) findViewById(R.id.deleteButton);
        mDatabase = new Database(this);

        //get the intent extra from the ListDataActivity
        Intent receivedIntent = getIntent();

        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id",-1); //NOTE: -1 is just the default value

        //now get the team we passed as an extra
        selectedTeamName = receivedIntent.getStringExtra("team");

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.deleteName(selectedID, selectedTeamName);
                adapter.remove(selectedTeamName);
                toastMessage("Removed!");
            }
        });

    }

    /**
     * customizable toast
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}