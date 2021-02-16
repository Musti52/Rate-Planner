package com.example.rateplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class KamdhenuTMTActivity extends AppCompatActivity {

    double basicRate = 0.0;
    double freight = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamdhenu_t_m_t);
    }

    public void onButtonClick_KAMDHENU(View v) {
        EditText edit = (EditText) findViewById(R.id.basicRate);
        EditText edit2 = (EditText) findViewById(R.id.freight);
        TextView text = (TextView) findViewById(R.id.textViewKamdhenu);

        if (edit.getText().toString().equals(""))
            edit.setText("0.0");
        else
            basicRate = Double.parseDouble(edit.getText().toString());

        if (edit2.getText().toString().equals(""))
            edit2.setText("0.0");
        else
            freight = Double.parseDouble(edit2.getText().toString());

        StringBuilder result = new StringBuilder();

        result.append("    Basic Rate\n");
        result.append("    + SizeDiff\n");
        result.append("    - Cash Discount(0.4)\n");
        result.append("    + Freight\n");

        ArrayList<Pair<String,Double>> kamdhenu1  = new ArrayList <Pair<String,Double>>();
        kamdhenu1.add(Pair.of(" 8 MM  ", 2.4));
        kamdhenu1.add(Pair.of("10 MM  ", 1.4));
        kamdhenu1.add(Pair.of("12 MM  ", 1.4));
        kamdhenu1.add(Pair.of("16 MM  ", 1.4));
        kamdhenu1.add(Pair.of("20 MM  ", 1.4));
        kamdhenu1.add(Pair.of("25 MM  ", 1.4));
        kamdhenu1.add(Pair.of("28 MM  ", 0.0));
        kamdhenu1.add(Pair.of("32 MM  ", 2.4));
        result.append(calculateForKamdhenu(kamdhenu1));

        text.setTextSize(20);
        text.setTextColor(Color.DKGRAY);
        text.setTypeface(Typeface.MONOSPACE);
        text.setText(result);
    }

    public String calculateForKamdhenu(ArrayList<Pair<String,Double>> variety) {
        String str = "";
        str += "       " + "_________________\n\n";
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        for (int i = 0; i < variety.size(); i++) {
            String size = variety.get(i).first();
            Double rateDiff = Double.parseDouble(variety.get(i).second());

            double actualRate = basicRate + rateDiff - 0.4;

            str += "        " + size + "  " + df.format(actualRate) + "\n";
        }
        str += "       " + "_________________";
        return str;
    }
}