package com.example.jakobwilhjelmpoulsen.simplecalculationapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button subm;
    String applName;
    double wattCalc;
    double timeCalc;
    double kwhCalc;
    double rateCalc;
    double priceCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"BodoniFLF-Bold.ttf");
        TextView header = (TextView) findViewById(R.id.headline);
        header.setTypeface(custom_font);


    }

    public void onButtonClick(View V) {
        EditText e1 = (EditText) findViewById(R.id.editText);
        EditText e2 = (EditText) findViewById(R.id.editText2);
        EditText e3 = (EditText) findViewById(R.id.editText3);
        EditText e4 = (EditText) findViewById(R.id.editText4);
        TextView t1 = (TextView) findViewById(R.id.applName);
        TextView t2 = (TextView) findViewById(R.id.watt);
        TextView t3 = (TextView) findViewById(R.id.timeUsed);
        TextView t4 = (TextView) findViewById(R.id.ratePrice);
        TextView t5 = (TextView) findViewById(R.id.totalPrice);

        applName = e1.getText().toString();
        wattCalc = Double.parseDouble(e2.getText().toString());
        timeCalc = Double.parseDouble(e3.getText().toString());
        rateCalc = Double.parseDouble(e4.getText().toString());
        kwhCalc = (wattCalc)/(1000)*(timeCalc);
        priceCalc = (rateCalc)*(kwhCalc)/(100);

        t1.setText("Appliance: " + applName);
        t2.setText("Appliance Watt: " + Double.toString(wattCalc));
        t3.setText(applName + "Uses: " + Double.toString((kwhCalc)/(timeCalc)) + " kilowatts per hour");
        t4.setText("Your watt rate is: " + Double.toString(rateCalc) + " øre per kWh");
        t5.setText("Price pr. day: " + Double.toString(priceCalc) + " kr" +
                "\nPrice pr. month: " + Double.toString((priceCalc)*30) + " kr"+
                "\nPrice pr. year: " + Double.toString((priceCalc)*365) + " kr");
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
