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

public class GoelTMTActivity extends AppCompatActivity {

    double basicRate = 0.0;
    double loading = 0.215;
    double insurance = 0.012;
    double cashDiscount = 0.3;
    double freight = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goel_t_m_t);
    }

    public void onButtonClick_GOEL(View v) {
        EditText edit = (EditText) findViewById(R.id.basicRate);
        EditText edit2 = (EditText) findViewById(R.id.freight);
        TextView text = (TextView) findViewById(R.id.textViewGoyal);

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
        result.append("    + Loading(" + loading + ")\n");
        result.append("    + Insurance(" + insurance + ")\n");
        result.append("    - Cash Discount(" + cashDiscount + ")\n");
        result.append("    + 18% GST\n");
        result.append("    + Freight\n");

        ArrayList<Pair<String,Double>> goyal1  = new ArrayList <Pair<String,Double>>();
        goyal1.add(Pair.of(" 8 MM  ", 1.0));
        goyal1.add(Pair.of("10 MM  ", 0.0));
        goyal1.add(Pair.of("12 MM  ", 0.0));
        goyal1.add(Pair.of("16 MM  ", 0.0));
        goyal1.add(Pair.of("20 MM  ", 0.0));
        goyal1.add(Pair.of("25 MM  ", 0.0));
        goyal1.add(Pair.of("28 MM  ", 1.0));
        goyal1.add(Pair.of("32 MM  ", 1.0));
        result.append(calculateForGoyal(goyal1));

        text.setTextSize(20);
        text.setTextColor(Color.DKGRAY);
        text.setTypeface(Typeface.MONOSPACE);
        text.setText(result);
    }

    public String calculateForGoyal(ArrayList<Pair<String,Double>> variety) {
        String str = "";
        str += "       " + "_________________\n\n";
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        for (int i = 0; i < variety.size(); i++) {
            String size = variety.get(i).first();
            Double rateDiff = Double.parseDouble(variety.get(i).second());

            double store = basicRate + rateDiff + loading + insurance - cashDiscount;
            double actualRate = store + 0.18 * store + freight;

            str += "        " + size + "  " + df.format(actualRate) + "\n";
        }
        str += "       " + "_________________";
        return str;
    }
}