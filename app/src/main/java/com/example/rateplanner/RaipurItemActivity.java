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

// Pair class
class Pair<U, V>
{
    public final U first;   	// first field of a Pair
    public final V second;  	// second field of a Pair

    // Constructs a new Pair with specified values
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    public String first() {
        return "" + first;
    }

    public String second() {
        return "" + second;
    }


    // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
}

public class RaipurItemActivity extends AppCompatActivity {

    double loading = 0.215;
    double commission = 0.1;
    double basicRate = 0.0;
    double freight = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raipur_item);
    }

    public void onButtonClick_RaipurItem(View v) {
        EditText edit = (EditText)findViewById(R.id.basicRate);
        EditText edit2 = (EditText)findViewById(R.id.freight);
        TextView text = (TextView)findViewById(R.id.textViewRaipurItem);

        if(edit.getText().toString().equals(""))
            edit.setText("0.0");
        else
            basicRate = Double.parseDouble(edit.getText().toString());

        if(edit2.getText().toString().equals(""))
            edit2.setText("0.0");
        else
            freight = Double.parseDouble(edit2.getText().toString());

        StringBuilder result = new StringBuilder();
        result.append("    Basic Rate\n");
        result.append("    + SizeDiff\n");
        result.append("    + Loading(" + loading + ")\n");
        result.append("    + Commission(" + commission + ")\n");
        result.append("    + 18% GST\n");
        result.append("    + Freight\n");

        result.append("\n             ANGLE            \n\n");

        ArrayList<Pair<String,Double>> angle1  = new ArrayList <Pair<String,Double>>();
        angle1.add(Pair.of("25X2.5  ", 7.0));
        angle1.add(Pair.of("32X2.5  ", 7.0));
        result.append(calculateForAngle(angle1));

        ArrayList<Pair<String,Double>> angle2  = new ArrayList <Pair<String,Double>>();
        angle2.add(Pair.of("25X3    ", 5.8));
        angle2.add(Pair.of("32X3    ", 5.5));
        angle2.add(Pair.of("35X3    ", 5.8));
        angle2.add(Pair.of("37X3    ", 5.8));
        angle2.add(Pair.of("40X3    ", 5.8));
        result.append(calculateForAngle(angle2));

        ArrayList<Pair<String,Double>> angle3  = new ArrayList <Pair<String,Double>>();
        angle3.add(Pair.of("25X4    ", 5.8));
        angle3.add(Pair.of("32X4    ", 5.8));
        angle3.add(Pair.of("35X4    ", 5.5));
        angle3.add(Pair.of("40X4    ", 5.5));
        angle3.add(Pair.of("45X4    ", 5.8));
        angle3.add(Pair.of("50X4    ", 5.5));
        result.append(calculateForAngle(angle3));

        ArrayList<Pair<String,Double>> angle4  = new ArrayList <Pair<String,Double>>();
        angle4.add(Pair.of("25X5    ", 5.5));
        angle4.add(Pair.of("35X5    ", 5.2));
        angle4.add(Pair.of("40X5    ", 5.0));
        angle4.add(Pair.of("50X5    ", 4.4));
        angle4.add(Pair.of("65X5    ", 4.4));
        angle4.add(Pair.of("75X5    ", 4.4));
        result.append(calculateForAngle(angle4));

        ArrayList<Pair<String,Double>> angle5  = new ArrayList <Pair<String,Double>>();
        angle5.add(Pair.of("40X6    ", 5.0));
        angle5.add(Pair.of("50X6    ", 4.1));
        angle5.add(Pair.of("65X6    ", 4.1));
        angle5.add(Pair.of("75X6    ", 4.1));
        angle5.add(Pair.of("90X6    ", 5.0));
        angle5.add(Pair.of("100X6   ", 5.0));
        result.append(calculateForAngle(angle5));

        ArrayList<Pair<String,Double>> angle6  = new ArrayList <Pair<String,Double>>();
        angle6.add(Pair.of("75X8    ", 4.4));
        angle6.add(Pair.of("90X8    ", 5.0));
        angle6.add(Pair.of("100X8   ", 5.0));
        result.append(calculateForAngle(angle6));

        ArrayList<Pair<String,Double>> angle7  = new ArrayList <Pair<String,Double>>();
        angle7.add(Pair.of("75X10   ", 4.4));
        angle7.add(Pair.of("90X10   ", 5.0));
        angle7.add(Pair.of("100X10  ", 5.0));
        result.append(calculateForAngle(angle7));

        ArrayList<Pair<String,Double>> angle8  = new ArrayList <Pair<String,Double>>();
        angle8.add(Pair.of("45X30X4 ", 7.6));
        angle8.add(Pair.of("45X30X5 ", 7.6));
        angle8.add(Pair.of("45X30X6 ", 7.6));
        angle8.add(Pair.of("75X50X5 ", 7.6));
        angle8.add(Pair.of("75X50X6 ", 7.6));
        angle8.add(Pair.of("75X50X8 ", 7.6));
        result.append(calculateForAngle(angle8));

        result.append("\n******************************\n" +
                      "******************************\n\n");
        result.append("\n            CHANNEL            \n\n");
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////


        ArrayList<Pair<String,Double>> channelBeam1  = new ArrayList <Pair<String,Double>>();
        channelBeam1.add(Pair.of("CH 75X40     SL", 5.2));
        channelBeam1.add(Pair.of("CH 75X40     M ", 4.4));
        channelBeam1.add(Pair.of("CH 75X40     H ", 5.0));
        result.append(calculateForChannelBeam(channelBeam1));

        ArrayList<Pair<String,Double>> channelBeam2  = new ArrayList <Pair<String,Double>>();
        channelBeam2.add(Pair.of("CH 100X50    SL", 5.2));
        channelBeam2.add(Pair.of("CH 100X50    M ", 4.1));
        channelBeam2.add(Pair.of("CH 100X50    H ", 4.8));
        result.append(calculateForChannelBeam(channelBeam2));

        ArrayList<Pair<String,Double>> channelBeam3  = new ArrayList <Pair<String,Double>>();
        channelBeam3.add(Pair.of("CH 125X65    SL", 6.2));
        channelBeam3.add(Pair.of("CH 125X65    H ", 4.2));
        result.append(calculateForChannelBeam(channelBeam3));

        ArrayList<Pair<String,Double>> channelBeam4  = new ArrayList <Pair<String,Double>>();
        channelBeam4.add(Pair.of("CH 150X75    SL", 6.7));
        channelBeam4.add(Pair.of("CH 150X75    H ", 4.2));
        result.append(calculateForChannelBeam(channelBeam4));

        ArrayList<Pair<String,Double>> channelBeam5  = new ArrayList <Pair<String,Double>>();
        channelBeam5.add(Pair.of("CH 200X75    SL", 6.7));
        channelBeam5.add(Pair.of("CH 200X75    H ", 5.5));
        result.append(calculateForChannelBeam(channelBeam5));

        result.append("\n******************************\n" +
                "******************************\n\n");
        result.append("\n             BEAM            \n\n");

        ArrayList<Pair<String,Double>> channelBeam6  = new ArrayList <Pair<String,Double>>();
        channelBeam6.add(Pair.of("Beam 100X50    ", 4.7));
        result.append(calculateForChannelBeam(channelBeam6));

        ArrayList<Pair<String,Double>> channelBeam7  = new ArrayList <Pair<String,Double>>();
        channelBeam7.add(Pair.of("Beam 125X70  SL", 5.8));
        channelBeam7.add(Pair.of("Beam 125X70  M ", 4.7));
        channelBeam7.add(Pair.of("Beam 125X70  H ", 4.2));
        result.append(calculateForChannelBeam(channelBeam7));

        ArrayList<Pair<String,Double>> channelBeam8  = new ArrayList <Pair<String,Double>>();
        channelBeam8.add(Pair.of("Beam 150X75  SL", 5.8));
        channelBeam8.add(Pair.of("Beam 150X75  M ", 4.7));
        channelBeam8.add(Pair.of("Beam 150X75  H ", 4.2));
        result.append(calculateForChannelBeam(channelBeam8));

        ArrayList<Pair<String,Double>> channelBeam9  = new ArrayList <Pair<String,Double>>();
        channelBeam9.add(Pair.of("Beam 175X85  H ", 5.0));
        result.append(calculateForChannelBeam(channelBeam9));

        ArrayList<Pair<String,Double>> channelBeam10  = new ArrayList <Pair<String,Double>>();
        channelBeam10.add(Pair.of("Beam 200X100 H ", 5.0));
        result.append(calculateForChannelBeam(channelBeam10));

        ArrayList<Pair<String,Double>> channelBeam11  = new ArrayList <Pair<String,Double>>();
        channelBeam11.add(Pair.of("Beam 250X125 H ", 5.8));
        result.append(calculateForChannelBeam(channelBeam11));

        ArrayList<Pair<String,Double>> channelBeam12  = new ArrayList <Pair<String,Double>>();
        channelBeam12.add(Pair.of("Beam 300X150 H ", 6.2));
        result.append(calculateForChannelBeam(channelBeam12));

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

            double store = basicRate + rateDiff + loading + commission;
            double actualRate = store + 0.18 * (store) + freight;

            str += "  ANGLE " + size + " (" + rateDiff.toString() + ") " + df.format(actualRate) + "\n";
        }
        str += "  __________________________\n\n";
        return str;
    }

    public String calculateForChannelBeam(ArrayList<Pair<String,Double>> variety) {
        String str = "";

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        for (int i = 0; i < variety.size(); i++) {
            String size = variety.get(i).first();
            Double rateDiff = Double.parseDouble(variety.get(i).second());

            double store = basicRate + rateDiff + loading + commission;
            double actualRate = store + 0.18 * (store) + freight;

            str += "  " + size + " (" + rateDiff.toString() + ") " + df.format(actualRate) + "\n";
        }
        str += "  " + "___________________________\n\n";
        return str;
    }
}