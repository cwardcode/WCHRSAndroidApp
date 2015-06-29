package edu.wcu.wchrs.android.GroundwaterCollection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Chris on 6/29/2015.
 */
public class GroundWaterSplash extends Activity {
    private static int SPLASH_DELAY = 3000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        TextView title = (TextView) findViewById(R.id.splash_title);
        title.setTextSize(getResources().getDimension(R.dimen.textsize));
        title.setText(R.string.splash_title);

        Log.d("Splash", "Inside Splash!");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextActivity = new Intent(GroundWaterSplash.this, GroundWaterMain.class);
                startActivity(nextActivity);
                finish();
            }
        }, SPLASH_DELAY);
    }
}