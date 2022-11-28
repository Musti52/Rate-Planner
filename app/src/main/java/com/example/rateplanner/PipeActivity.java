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

public class PipeActivity extends AppCompatActivity {

    double expenses = 0.3;
    double basicRate = 0.0;
    double freight = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pipe);
    }

    public void onButtonClick_PipeItem(View v) {
        EditText edit = (EditText) findViewById(R.id.basicRate);
        EditText edit2 = (EditText) findViewById(R.id.freight);
        TextView text = (TextView) findViewById(R.id.textViewPipeItem);

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

        result.append("\n             SQUARE             \n\n");

        ArrayList<Pair<String,Double>> pipe1  = new ArrayList <Pair<String,Double>>();
        pipe1.add(Pair.of("19X19 3Kg-4Kg", 6.3));
        pipe1.add(Pair.of("19X19 4Kg-5Kg", 4.8));
        pipe1.add(Pair.of("19X19 5Kg-6Kg", 3.6));
        pipe1.add(Pair.of("19X19 6Kg-7Kg", 3.0));
        pipe1.add(Pair.of("19X19 7Kg-8Kg", 3.0));
        result.append("            ||| X |||        \n\n");
        result.append(calculateForPipe(pipe1));

        ArrayList<Pair<String,Double>> pipe2  = new ArrayList <Pair<String,Double>>();
        pipe2.add(Pair.of("25X25 4Kg-5Kg", 5.3));
        pipe2.add(Pair.of("25X25 5Kg-6Kg", 3.8));
        pipe2.add(Pair.of("25X25 6Kg-7Kg", 2.6));
        pipe2.add(Pair.of("25X25 7Kg-8Kg", 2.4));
        pipe2.add(Pair.of("25X25 8Kg-9Kg", 2.0));
        pipe2.add(Pair.of("25X25 9Kg-10Kg", 2.0));
        pipe2.add(Pair.of("25X25 10Kg-11Kg", 2.0));
        result.append("              1 X 1        \n\n");
        result.append(calculateForPipe(pipe2));

        ArrayList<Pair<String,Double>> pipe3  = new ArrayList <Pair<String,Double>>();
        pipe3.add(Pair.of("31X31 6Kg-7Kg", 4.8));
        pipe3.add(Pair.of("31X31 7Kg-8Kg", 3.3));
        pipe3.add(Pair.of("31X31 8Kg-9.5Kg", 2.1));
        pipe3.add(Pair.of("31X31 9.5Kg-10.5Kg", 1.9));
        pipe3.add(Pair.of("31X31 10.5Kg-12Kg", 1.5));
        pipe3.add(Pair.of("31X31 12Kg-13Kg", 1.1));
        pipe3.add(Pair.of("31X31 13Kg-15Kg", 1.1));
        pipe3.add(Pair.of("31X31 15Kg-17Kg", 1.1));
        result.append("           1.25 X 1.25        \n\n");
        result.append(calculateForPipe(pipe3));

        ArrayList<Pair<String,Double>> pipe4  = new ArrayList <Pair<String,Double>>();
        pipe4.add(Pair.of("38X38 6Kg-7Kg", 4.3));
        pipe4.add(Pair.of("38X38 8Kg-9Kg", 2.8));
        pipe4.add(Pair.of("38X38 10Kg-11.5Kg", 1.6));
        pipe4.add(Pair.of("38X38 11.5Kg-12.5Kg", 1.4));
        pipe4.add(Pair.of("38X38 12.5Kg-13Kg", 1.0));
        pipe4.add(Pair.of("38X38 13Kg-14.5Kg", 1.0));
        pipe4.add(Pair.of("38X38 14.5Kg-16Kg", 0.6));
        pipe4.add(Pair.of("38X38 16Kg-17.5Kg", 0.6));
        pipe4.add(Pair.of("38X38 18.5Kg-20Kg", 0.8));
        pipe4.add(Pair.of("38X38 20Kg-22Kg", 1.0));
        result.append("            1.5 X 1.5         \n\n");
        result.append(calculateForPipe(pipe4));

        ArrayList<Pair<String,Double>> pipe5  = new ArrayList <Pair<String,Double>>();
        pipe5.add(Pair.of("47X47 10Kg-11Kg", 3.0));
        pipe5.add(Pair.of("47X47 11Kg-13Kg", 2.4));
        pipe5.add(Pair.of("47X47 13Kg-15Kg", 1.8));
        pipe5.add(Pair.of("47X47 15Kg-19Kg", 1.2));
        pipe5.add(Pair.of("47X47 19Kg-22Kg", 0.8));
        pipe5.add(Pair.of("47X47 >22Kg", 1.0));
        result.append("           1.75 X 1.75        \n\n");
        result.append(calculateForPipe(pipe5));

        ArrayList<Pair<String,Double>> pipe6  = new ArrayList <Pair<String,Double>>();
        pipe6.add(Pair.of("50X50 11Kg-13Kg", 2.4));
        pipe6.add(Pair.of("50X50 13Kg-15.5Kg", 1.8));
        pipe6.add(Pair.of("50X50 15.5Kg-19Kg", 1.2));
        pipe6.add(Pair.of("50X50 19Kg-23.5Kg", 0.8));
        pipe6.add(Pair.of("50X50 >23.5Kg", 0.9));
        result.append("              2 X 2        \n\n");
        result.append(calculateForPipe(pipe6));

        ArrayList<Pair<String,Double>> pipe7  = new ArrayList <Pair<String,Double>>();
        pipe7.add(Pair.of("60X60 17Kg-18.5Kg", 2.6));
        pipe7.add(Pair.of("60X60 21Kg-22.5Kg", 2.0));
        pipe7.add(Pair.of("60X60 >23Kg", 1.6));
        result.append("            2.5 X 2.5        \n\n");
        result.append(calculateForPipe(pipe7));

        ArrayList<Pair<String,Double>> pipe8  = new ArrayList <Pair<String,Double>>();
        pipe8.add(Pair.of("72X72 25Kg-27Kg", 3.4));
        pipe8.add(Pair.of("72X72 32Kg-33Kg", 3.0));
        pipe8.add(Pair.of("72X72 >38Kg", 3.0));
        result.append("              3 X 3        \n\n");
        result.append(calculateForPipe(pipe8));

        result.append("\n ******************************\n" +
                " ******************************\n\n");

        result.append("\n           RECTANGLE             \n\n");
        ArrayList<Pair<String,Double>> pipe9  = new ArrayList <Pair<String,Double>>();
        pipe9.add(Pair.of("41X21 6Kg-7Kg", 5.2));
        pipe9.add(Pair.of("41X21 7Kg-8Kg", 3.7));
        pipe9.add(Pair.of("41X21 8Kg-9.5Kg", 2.5));
        pipe9.add(Pair.of("41X21 9.5Kg-10.5Kg", 2.3));
        pipe9.add(Pair.of("41X21 10.5Kg-12Kg", 1.9));
        pipe9.add(Pair.of("41X21 12Kg-13Kg", 1.5));
        pipe9.add(Pair.of("41X21 13Kg-15Kg", 1.5));
        pipe9.add(Pair.of("41X21 15Kg-17Kg", 1.5));
        result.append("           1.5 X |||        \n\n");
        result.append(calculateForPipe(pipe9));

        ArrayList<Pair<String,Double>> pipe10  = new ArrayList <Pair<String,Double>>();
        pipe10.add(Pair.of("50X25 6Kg-7Kg", 4.3));
        pipe10.add(Pair.of("50X25 8Kg-9Kg", 2.8));
        pipe10.add(Pair.of("50X25 10Kg-11.5Kg", 1.6));
        pipe10.add(Pair.of("50X25 11.5Kg-12.5Kg", 1.4));
        pipe10.add(Pair.of("50X25 12.5Kg-13Kg", 1.0));
        pipe10.add(Pair.of("50X25 13Kg-14.5Kg", 1.0));
        pipe10.add(Pair.of("50X25 14.5Kg-16Kg", 0.6));
        pipe10.add(Pair.of("50X25 16Kg-17.5Kg", 0.6));
        pipe10.add(Pair.of("50X25 18.5Kg-20Kg", 0.8));
        pipe10.add(Pair.of("50X25 20Kg-22Kg", 1.0));
        result.append("             2 X 1        \n\n");
        result.append(calculateForPipe(pipe10));

        ArrayList<Pair<String,Double>> pipe11  = new ArrayList <Pair<String,Double>>();
        pipe11.add(Pair.of("56X38 10Kg-11Kg", 3.0));
        pipe11.add(Pair.of("56X38 11Kg-13Kg", 2.4));
        pipe11.add(Pair.of("56X38 13Kg-15Kg", 1.8));
        pipe11.add(Pair.of("56X38 15Kg-19Kg", 1.2));
        pipe11.add(Pair.of("56X38 19Kg-22Kg", 0.8));
        pipe11.add(Pair.of("56X38 >22Kg", 1.0));
        result.append("          2.25 X 1.50        \n\n");
        result.append(calculateForPipe(pipe11));

        ArrayList<Pair<String,Double>> pipe12  = new ArrayList <Pair<String,Double>>();
        pipe12.add(Pair.of("60X40 11Kg-13Kg", 2.7));
        pipe12.add(Pair.of("60X40 13Kg-15.5Kg", 2.1));
        pipe12.add(Pair.of("60X40 15.5Kg-19Kg", 1.5));
        pipe12.add(Pair.of("60X40 19Kg-23.5Kg", 1.1));
        pipe12.add(Pair.of("60X40 >23.5Kg", 1.3));
        result.append("           2.5 X 1.5       \n\n");
        result.append(calculateForPipe(pipe12));

        ArrayList<Pair<String,Double>> pipe13  = new ArrayList <Pair<String,Double>>();
        pipe13.add(Pair.of("68X25 11Kg-13g", 2.8));
        pipe13.add(Pair.of("68X25 13Kg-15.5Kg", 2.2));
        pipe13.add(Pair.of("68X25 >15.5Kg", 1.6));
        result.append("          2.75 X 1       \n\n");
        result.append(calculateForPipe(pipe13));

        ArrayList<Pair<String,Double>> pipe14  = new ArrayList <Pair<String,Double>>();
        pipe14.add(Pair.of("75X25 11Kg-13Kg", 3.1));
        pipe14.add(Pair.of("75X25 13Kg-15.5Kg", 2.5));
        pipe14.add(Pair.of("75X25 >15.5Kg", 1.9));
        result.append("             3 X 1        \n\n");
        result.append(calculateForPipe(pipe14));

        ArrayList<Pair<String,Double>> pipe15  = new ArrayList <Pair<String,Double>>();
        pipe15.add(Pair.of("80X40 17Kg-18.5Kg", 2.6));
        pipe15.add(Pair.of("80X40 21Kg-22.5Kg", 2.0));
        pipe15.add(Pair.of("80X40 >23Kg", 1.6));
        result.append("             3 X 1.5        \n\n");
        result.append(calculateForPipe(pipe15));

        ArrayList<Pair<String,Double>> pipe16  = new ArrayList <Pair<String,Double>>();
        pipe16.add(Pair.of("96X48 25Kg-27Kg", 3.4));
        pipe16.add(Pair.of("96X48 32Kg-33Kg", 3.0));
        pipe16.add(Pair.of("96X48 >38Kg", 3.0));
        result.append("             4 X 2        \n\n");
        result.append(calculateForPipe(pipe16));

        result.append("\n ******************************\n" +
                " ******************************\n\n");

        result.append("\n             ROUND             \n\n");

        ArrayList<Pair<String,Double>> pipe17  = new ArrayList <Pair<String,Double>>();
        pipe17.add(Pair.of("25 OD 3Kg-4Kg", 6.0));
        pipe17.add(Pair.of("25 OD 4Kg-5Kg", 4.5));
        pipe17.add(Pair.of("25 OD 5Kg-6Kg", 3.3));
        pipe17.add(Pair.of("25 OD 6Kg-7Kg", 2.7));
        pipe17.add(Pair.of("25 OD 7Kg-8Kg", 2.7));
        result.append("              1\"        \n\n");
        result.append(calculateForPipe(pipe17));

        ArrayList<Pair<String,Double>> pipe18  = new ArrayList <Pair<String,Double>>();
        pipe18.add(Pair.of("32 OD 4Kg-5Kg", 5.0));
        pipe18.add(Pair.of("32 OD 5Kg-6Kg", 3.5));
        pipe18.add(Pair.of("32 OD 6Kg-7Kg", 2.3));
        pipe18.add(Pair.of("32 OD 7Kg-8Kg", 2.1));
        pipe18.add(Pair.of("32 OD 8Kg-9Kg", 1.7));
        pipe18.add(Pair.of("32 OD 9Kg-10Kg", 1.7));
        pipe18.add(Pair.of("32 OD 10Kg-11Kg", 1.7));
        result.append("             1.25\"       \n\n");
        result.append(calculateForPipe(pipe18));

        ArrayList<Pair<String,Double>> pipe19  = new ArrayList <Pair<String,Double>>();
        pipe19.add(Pair.of("42 OD 6Kg-7Kg", 4.5));
        pipe19.add(Pair.of("42 OD 7Kg-8Kg", 3.0));
        pipe19.add(Pair.of("42 OD 8Kg-9.5Kg", 1.8));
        pipe19.add(Pair.of("42 OD 9.5Kg-10.5Kg", 1.6));
        pipe19.add(Pair.of("42 OD 10.5Kg-12Kg", 1.2));
        pipe19.add(Pair.of("42 OD 12Kg-13Kg", 0.8));
        pipe19.add(Pair.of("42 OD 13Kg-15Kg", 0.8));
        pipe19.add(Pair.of("42 OD 15Kg-17Kg", 0.8));
        result.append("             1.5\"        \n\n");
        result.append(calculateForPipe(pipe19));

        ArrayList<Pair<String,Double>> pipe20  = new ArrayList <Pair<String,Double>>();
        pipe20.add(Pair.of("48 OD 6Kg-7Kg", 4.0));
        pipe20.add(Pair.of("48 OD 8Kg-9Kg", 2.5));
        pipe20.add(Pair.of("48 OD 10Kg-11.5Kg", 1.3));
        pipe20.add(Pair.of("48 OD 11.5Kg-12.5Kg", 1.1));
        pipe20.add(Pair.of("48 OD 12.5Kg-13Kg", 0.7));
        pipe20.add(Pair.of("48 OD 13Kg-14.5Kg", 0.7));
        pipe20.add(Pair.of("48 OD 14.5Kg-16Kg", 0.3));
        pipe20.add(Pair.of("48 OD 16Kg-17.5Kg", 0.3));
        pipe20.add(Pair.of("48 OD 18.5Kg-20Kg", 0.3));
        pipe20.add(Pair.of("48 OD 20Kg-22Kg", 0.3));
        result.append("              2\"        \n\n");
        result.append(calculateForPipe(pipe20));

        ArrayList<Pair<String,Double>> pipe21  = new ArrayList <Pair<String,Double>>();
        pipe21.add(Pair.of("60 OD 10Kg-11Kg", 2.7));
        pipe21.add(Pair.of("60 OD 11Kg-12Kg", 2.1));
        pipe21.add(Pair.of("60 OD 13.5Kg-15Kg", 1.5));
        pipe21.add(Pair.of("60 OD 15Kg-18.5Kg", 0.9));
        pipe21.add(Pair.of("60 OD >18.5Kg", 0.5));
        result.append("             2.5\"        \n\n");
        result.append(calculateForPipe(pipe21));

        ArrayList<Pair<String,Double>> pipe22  = new ArrayList <Pair<String,Double>>();
        pipe22.add(Pair.of("76 OD 17Kg-18.5Kg", 2.3));
        pipe22.add(Pair.of("76 OD 21Kg-22.5Kg", 1.7));
        pipe22.add(Pair.of("76 OD >23Kg", 1.3));
        result.append("              3\"        \n\n");
        result.append(calculateForPipe(pipe22));

        ArrayList<Pair<String,Double>> pipe23  = new ArrayList <Pair<String,Double>>();
        pipe23.add(Pair.of("88 OD 25Kg-27Kg", 2.7));
        pipe23.add(Pair.of("88 OD 32Kg-33Kg", 2.3));
        pipe23.add(Pair.of("88 OD >38Kg", 2.3));
        result.append("              4\"        \n\n");
        result.append(calculateForPipe(pipe23));

        result.append("\n ******************************\n" +
                " ******************************\n\n");

        text.setTextSize(20);
        text.setTextColor(Color.DKGRAY);
        text.setTypeface(Typeface.MONOSPACE);
        text.setText(result);
    }

    public String calculateForPipe(ArrayList<Pair<String,Double>> variety) {
        String str = "";

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        for (int i = 0; i < variety.size(); i++) {
            String size = variety.get(i).first();
            Double rateDiff = Double.parseDouble(variety.get(i).second());

            double store = basicRate + rateDiff + expenses;
            double actualRate = store + 0.18 * (store) + freight;

            String temp = " " + size;
            while(temp.length() < 20)
                temp += " ";

            str += temp + "(" + rateDiff.toString() + ") " + df.format(actualRate) + "\n";
        }
        str += " _____________________________  \n\n";
        return str;
    }
}