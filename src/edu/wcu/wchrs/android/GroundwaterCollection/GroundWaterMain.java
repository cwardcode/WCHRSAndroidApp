package edu.wcu.wchrs.android.GroundwaterCollection;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class GroundWaterMain extends Activity
{
    CheckBox bucket;
    CheckBox ruler;
    CheckBox levelTape;
    CheckBox wellKey;
    CheckBox pen;
    String missedFields;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView text = (TextView) findViewById(R.id.section_title);
        text.setTextSize(getResources().getDimension(R.dimen.textsize));
        Button contButton = (Button) findViewById(R.id.equip_cont);

        bucket = (CheckBox) findViewById(R.id.Bucket);
        ruler = (CheckBox) findViewById(R.id.Ruler);
        levelTape = (CheckBox) findViewById(R.id.LevelTape);
        wellKey = (CheckBox) findViewById(R.id.WellKey);
        pen = (CheckBox) findViewById(R.id.pen);
        missedFields = "Please enter the following fields:\n";
        contButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check if all checkboxes have been
                if (!areAllChecked()) {
                    TextView errorText = (TextView) findViewById(R.id.section_error);
                    errorText.setTextSize(14);
                    errorText.setTextColor(Color.RED);
                    errorText.setText(missedFields);
                    missedFields = "Please check the following fields:\n";
                } else {
                    goToNextScreen();
                }
            }
        });
    }


    private boolean areAllChecked() {
        boolean allChecked = true;
        if (!bucket.isChecked()) {
            allChecked = false;
            missedFields = missedFields + "Bucket\n";
        }
        if (!ruler.isChecked()) {
            allChecked = false;
            missedFields = missedFields + "Folding Ruler\n";
        }
        if (!levelTape.isChecked()) {
            allChecked = false;
            missedFields = missedFields + "Water Level Tape\n";
        }
        if (!wellKey.isChecked()) {
            allChecked = false;
            missedFields = missedFields + "Well key\n";
        }
        if (!pen.isChecked()) {
            allChecked = false;
            missedFields = missedFields + "Pen\n";
        }
        return allChecked;
    }

    private void goToNextScreen() {
        Intent nextActivity = new Intent(getApplicationContext(), GroundWaterGenData.class);
        startActivity(nextActivity);
        finish();
    }
}
