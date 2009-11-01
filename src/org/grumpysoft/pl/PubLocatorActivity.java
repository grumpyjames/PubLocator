package org.grumpysoft.pl;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class PubLocatorActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout llv = new LinearLayout(this);
        llv.setOrientation(1);
        LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        llv.setLayoutParams(lp);
        PubSource ps = new DummyPubSource();
        for (Pub p: ps.findPubs(23.2,23.2)) {
        	llv.addView(new PubSummaryLayout(this,p));
        }
        setContentView(llv);
    }
}