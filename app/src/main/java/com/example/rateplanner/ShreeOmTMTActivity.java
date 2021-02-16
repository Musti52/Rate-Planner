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

public class ShreeOmTMTActivity extends AppCompatActivity {

    double basicRate = 0.0;
    double freight = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shree_om_t_m_t);
    }

    public void onButtonClick_ShreeOM(View v) {
        EditText edit = (EditText) findViewById(R.id.basicRate);
        EditText edit2 = (EditText) findViewById(R.id.freight);
        TextView text = (TextView) findViewById(R.id.textViewShreeOM);

        if (edit.getText().toString().equals(""))
            edit.setText("0.0");
        else
            basicRate = Double.parseDouble(edit.getText().toString());

        if (edit2.getText().toString().equals(""))
            edit2.setText("0.0");
        else
            freight = Double.parseDouble(edit2.getText().toString());

        StringBuilder result = new StringBuilder();
        result.append("   Basic Rate     Basic Rate\n");
        result.append("   - 1.5          + SizeDiff\n");
        result.append("   + SizeDiff     + 18% GST\n");
        result.append("   + 18% GST      - 1.5%\n");
        result.append("   - 1.5%         + Freight \n");
        result.append("   + 0.6     \n");
        result.append("   + Freight\n");

        ArrayList<Pair<String,Double>> shreeOm1  = new ArrayList <Pair<String,Double>>();
        shreeOm1.add(Pair.of(" 8 MM  ", 3.6));
        shreeOm1.add(Pair.of("10 MM  ", 2.6));
        shreeOm1.add(Pair.of("12 MM  ", 2.6));
        shreeOm1.add(Pair.of("16 MM  ", 2.6));
        shreeOm1.add(Pair.of("20 MM  ", 2.6));
        shreeOm1.add(Pair.of("25 MM  ", 2.6));
        shreeOm1.add(Pair.of("28 MM  ", 0.0));
        shreeOm1.add(Pair.of("32 MM  ", 3.6));
        result.append(calculateForShreeOM(shreeOm1));

        text.setTextSize(20);
        text.setTextColor(Color.DKGRAY);
        text.setTypeface(Typeface.MONOSPACE);
        text.setText(result);
    }

    public String calculateForShreeOM(ArrayList<Pair<String,Double>> variety) {
        String str = "";
        str += "   " + "_______________________\n\n";
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        for (int i = 0; i < variety.size(); i++) {
            String size = variety.get(i).first();
            Double rateDiff = Double.parseDouble(variety.get(i).second());

            Double actualRateWithoutBill = basicRate - 1.5 + rateDiff
                    + 0.18*(basicRate - 1.5 + rateDiff)
                    - 0.015*(basicRate - 1.5 + rateDiff + 0.18*(basicRate - 1.5 + rateDiff))
                    + 0.6
                    + freight;

            Double actualRateWithBill = basicRate + rateDiff
                    + 0.18*(basicRate + rateDiff)
                    - 0.015*(basicRate + rateDiff + 0.18*(basicRate + rateDiff))
                    + freight;

            String extraWithoutBill = "";
            String extraWithBill = "";

            if(df.format(actualRateWithoutBill).length() < 3) {
                extraWithoutBill += ".00";
            } else if(df.format(actualRateWithoutBill).length() < 5) {
                extraWithoutBill += "0";
            }

            if(df.format(actualRateWithBill).length() < 3) {
                extraWithBill += ".00";
            } else if(df.format(actualRateWithBill).length() < 4) {
                extraWithBill += "0";
            }

            str += "    " + size + "  " + df.format(actualRateWithoutBill) + extraWithoutBill + "  " + df.format(actualRateWithBill) +extraWithBill+ "\n";
        }
        str += "   " + "_______________________";
        return str;
    }
}