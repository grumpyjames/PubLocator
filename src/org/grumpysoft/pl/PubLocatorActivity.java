package org.grumpysoft.pl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PubLocatorActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout llv = new LinearLayout(this);
        llv.setOrientation(1);
        TextView one = new TextView(this);
        one.setText("I am number one");
        TextView two = new TextView(this);
        two.setText("I am number two");
        llv.addView(one);
        llv.addView(two);
        setContentView(llv);
    }
}