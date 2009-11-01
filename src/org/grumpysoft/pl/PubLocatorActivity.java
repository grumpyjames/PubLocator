package org.grumpysoft.pl;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PubLocatorActivity extends Activity implements UpdatableLocation {
    
    private PubSource ps_;
    private TextView gps_view_;
    @SuppressWarnings("unused")
    private GpsListenerWrapper glw_;
	
    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout lly = new LinearLayout(this);
        lly.setOrientation(1);
        LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        lly.setLayoutParams(lp);
        gps_view_ = new TextView(this);
        LayoutParams gps_lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        gps_view_.setLayoutParams(gps_lp);
        gps_view_.setGravity(Gravity.CENTER);
        gps_view_.setText("Waiting for gps position...");
        lly.addView(gps_view_);
        glw_ = new GpsListenerWrapper(this, this);
        ps_ = new DummyPubSource();
        for (Pub p: ps_.findPubs(23.2,23.2)) {
        	lly.addView(new PubSummaryLayout(this,p));
        }
        setContentView(lly);
    }

	public void update(Location l) {
		gps_view_.setText(l.getLatitude() + " , " + l.getLongitude());
	}
    
}