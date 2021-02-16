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

public class RaigarhItemActivity extends AppCompatActivity {

    double expenses = 0.175;
    double basicRate = 0.0;
    double freight = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raigarh_item);
    }

    public void onButtonClick_RaigarhItem(View v) {
        EditText edit = (EditText) findViewById(R.id.basicRate);
        EditText edit2 = (EditText) findViewById(R.id.freight);
        TextView text = (TextView) findViewById(R.id.textViewRaigarhItem);

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
        result.append("    + Expenses(" + expenses + ")\n");
        result.append("    + 18% GST\n");
        result.append("    + Freight\n");

        result.append("\n             ANGLE            \n\n");

        ArrayList<Pair<String,Double>> angle1  = new ArrayList <Pair<String,Double>>();
        angle1.add(Pair.of("50X5    ", 0.3));
        angle1.add(Pair.of("65X5    ", 0.3));
        angle1.add(Pair.of("75X5    ", 0.3));
        result.append(calculateForAngle(angle1));

        ArrayList<Pair<String,Double>> angle2  = new ArrayList <Pair<String,Double>>();
        angle2.add(Pair.of("50X6    ", 0.0));
        angle2.add(Pair.of("65X6    ", 0.0));
        angle2.add(Pair.of("75X6    ", 0.0));
        angle2.add(Pair.of("90X6    ", 0.5));
        angle2.add(Pair.of("100X6   ", 0.5));
        result.append(calculateForAngle(angle2));

        ArrayList<Pair<String,Double>> angle3  = new ArrayList <Pair<String,Double>>();
        angle3.add(Pair.of("75X8    ", 0.0));
        angle3.add(Pair.of("90X8    ", 0.5));
        angle3.add(Pair.of("100X8   ", 0.5));
        result.append(calculateForAngle(angle3));

        ArrayList<Pair<String,Double>> angle4  = new ArrayList <Pair<String,Double>>();
        angle4.add(Pair.of("75X10   ", 0.0));
        angle4.add(Pair.of("100X10  ", 0.5));
        angle4.add(Pair.of("130X10  ", 1.5));
        angle4.add(Pair.of("150X10  ", 2.0));
        result.append(calculateForAngle(angle4));

        ArrayList<Pair<String,Double>> angle5  = new ArrayList <Pair<String,Double>>();
        angle5.add(Pair.of("100X12  ", 0.5));
        angle5.add(Pair.of("130X12  ", 1.5));
        angle5.add(Pair.of("150X12  ", 2.0));
        result.append(calculateForAngle(angle5));

        result.append("\n******************************\n" +
                "******************************\n\n");
        result.append("\n            CHANNEL            \n\n");

        ArrayList<Pair<String,Double>> channelBeam1  = new ArrayList <Pair<String,Double>>();
        channelBeam1.add(Pair.of("CH 75X40     ", 0.0));
        channelBeam1.add(Pair.of("CH 100X50    ", 0.0));
        channelBeam1.add(Pair.of("CH 125X65    ", 0.3));
        channelBeam1.add(Pair.of("CH 150X75    ", 0.3));
        channelBeam1.add(Pair.of("CH 200X75    ", 1.1));
        channelBeam1.add(Pair.of("CH 250X      ", 1.4));
        channelBeam1.add(Pair.of("CH 300X      ", 2.0));
        result.append(calculateForChannelBeam(channelBeam1));

        result.append("\n******************************\n" +
                "******************************\n\n");
        result.append("\n             BEAM            \n\n");

        ArrayList<Pair<String,Double>> channelBeam2  = new ArrayList <Pair<String,Double>>();
        channelBeam2.add(Pair.of("Beam 100X50  ", 0.5));
        channelBeam2.add(Pair.of("Beam 125X70  ", 0.3));
        channelBeam2.add(Pair.of("Beam 150X75  ", 0.0));
        channelBeam2.add(Pair.of("Beam 200X100 ", 0.3));
        channelBeam2.add(Pair.of("Beam 250X125 ", 1.1));
        channelBeam2.add(Pair.of("Beam 300X150 ", 1.5));
        result.append(calculateForChannelBeam(channelBeam2));

        result.append("\n******************************\n" +
                "******************************\n\n");

        text.setTextSize(20);
        text.setTextColor(Color.DKGRAY);
        text.setTypeface(Typeface.MONOSPACE);
        text.setText(result);
    }

    public String calculateForAngle(ArrayList<Pair<String,Double>> variety) {
        String str = "";

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        for (int i = 0; i < variety.size(); i++) {
            String size = variety.get(i).first();
            Double rateDiff = Double.parseDouble(variety.get(i).second());

            double store = basicRate + rateDiff + expenses;
            double actualRate = store + 0.18 * (store) + freight;

            str += "  " + "ANGLE " + size + "(" + rateDiff.toString() + ") " + df.format(actualRate) + "\n";
        }
        str += "  " + "_________________________\n\n";
        return str;
    }

    public String calculateForChannelBeam(ArrayList<Pair<String,Double>> variety) {
        String str = "";

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        for (int i = 0; i < variety.size(); i++) {
            String size = variety.get(i).first();
            Double rateDiff = Double.parseDouble(variety.get(i).second());

            double store = basicRate + rateDiff + expenses;
            double actualRate = store + 0.18 * (store) + freight;

            str += "   " + size + "(" + rateDiff.toString() + ") " + df.format(actualRate) + "\n";
        }
        str += "   " + "________________________\n\n";
        return str;
    }
}