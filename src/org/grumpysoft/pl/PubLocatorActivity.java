package org.grumpysoft.pl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
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
        LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, 50);
        TextView one = new TextView(this);
        one.setLayoutParams(lp);
        one.setText("I am number one");
        one.setGravity(Gravity.CENTER);
        TextView two = new TextView(this);
        two.setLayoutParams(lp);
        two.setText("I am number two");
        two.setGravity(Gravity.CENTER);
        llv.addView(one);
        llv.addView(two);
        setContentView(llv);
    }
}