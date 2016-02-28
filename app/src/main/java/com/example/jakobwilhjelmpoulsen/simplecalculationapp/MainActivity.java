package com.example.jakobwilhjelmpoulsen.simplecalculationapp;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox1, checkBox2;
    private Button subm;
    private RatingBar ratingBar;
    private TextView ratingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnButton();
        addListenerToCheckBox();
        addListenerToCheckBox2();
        listenerForRatingBar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onButtonClick(View V) {
        EditText e1 = (EditText) findViewById(R.id.editText);
        EditText e2 = (EditText) findViewById(R.id.editText2);
        TextView t1 = (TextView) findViewById(R.id.textView);
        int num1 = Integer.parseInt(e1.getText().toString());
        int num2 = Integer.parseInt(e2.getText().toString());
        int sum = num1 + num2;
        t1.setText(Integer.toString(sum));

    }

    public void addListenerOnButton() {
        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        subm = (Button) findViewById(R.id.sumbitButton);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);

        subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("Satisfied :").append(checkBox1.isChecked());
                result.append("\nDissatisfied :").append(checkBox2.isChecked());

                Toast.makeText(MainActivity.this, result.toString(),
                        Toast.LENGTH_SHORT).show();
            }

        });
    }


    public void addListenerToCheckBox() {
        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(MainActivity.this, "Satisfied is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void addListenerToCheckBox2() {
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(MainActivity.this, "Dissatisfied is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void listenerForRatingBar(){
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        ratingText = (TextView)findViewById(R.id.RatingText);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingText.setText(String.valueOf(rating));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
