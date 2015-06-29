package edu.wcu.wchrs.android.GroundwaterCollection;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Chris on 6/29/2015.
 */
public class GroundWaterGenData extends Activity {
    TextView title;
    TextView names;
    TextView date;
    TextView time;
    TextView weather;
    TextView temp;
    Button contButton;
    TextView error;
    String emptyFields;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gendata);
        emptyFields = "Please enter the following fields: \n";
        title = (TextView) findViewById(R.id.gendata_title);
        title.setTextSize(getResources().getDimension(R.dimen.textsize));
        error = (TextView) findViewById(R.id.gen_error);

        names = (TextView) findViewById(R.id.gen_name_edit);
        date = (TextView) findViewById(R.id.gen_date_edit);
        date.setText(getCurrentDate());
        date.setEnabled(false);
        time = (TextView) findViewById(R.id.gen_time_edit);
        time.setText(getCurrentTime());
        time.setEnabled(false);
        weather = (TextView) findViewById(R.id.gen_weather_edit);
        temp = (TextView) findViewById(R.id.gen_temp_edit);
        contButton = (Button) findViewById(R.id.gen_button);
        contButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check to see if fields are filled in
                if (emptyFieldsExist()) {
                    error.setText(emptyFields);
                    error.setTextColor(Color.RED);
                } else {
                    error.setText("Names: " + names.getText() + "\n" + "Date: " + date.getText() + "\n" + "Time: "
                            + time.getText() + "\n" + "Weather: " + weather.getText() + "\n" + "Temp: " + temp.getText() + "\n");
                    error.setTextColor(Color.GREEN);
                }
            }
        });
    }

    public boolean emptyFieldsExist() {
        boolean empty = false;
        if (names.getText().toString().trim().equals("")) {
            empty = true;
            emptyFields = emptyFields + "Names\n";
        }
        if (weather.getText().toString().trim().equals("")) {
            empty = true;
            emptyFields = emptyFields + "Weather\n";
        }
        if (temp.getText().toString().trim().equals("")) {
            empty = true;
            emptyFields = emptyFields + "Temp\n";
        }
        return empty;
    }

    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}