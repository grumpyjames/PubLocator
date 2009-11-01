package org.grumpysoft.pl;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class PubLocatorActivity extends Activity implements UpdatableLocation {
    
    private PubSource ps_;
    private TextView gps_view_;
    @SuppressWarnings("unused")
    private GpsListenerWrapper glw_;
    private LinearLayout lly_;
	
    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lly_ = new LinearLayout(this);
        lly_.setOrientation(1);
        LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        lly_.setLayoutParams(lp);
        gps_view_ = new TextView(this);
        LayoutParams gps_lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        gps_view_.setLayoutParams(gps_lp);
        gps_view_.setGravity(Gravity.CENTER);
        gps_view_.setText("Waiting for gps position...");
        lly_.addView(gps_view_);
        glw_ = new GpsListenerWrapper(this, this);
        ps_ = new HttpPubSource(new JSONResponseTranslator());
        lly_.setScrollBarStyle(3);
        ScrollView sv = new ScrollView(this);
        sv.addView(lly_);
        setContentView(sv);
    }
	
	@SuppressWarnings("unused")
	private void reset(LinearLayout pub_holder) {
		if (pub_holder.getChildCount()>1) {
			pub_holder.removeViews(1, pub_holder.getChildCount() - 1);
		}
	}

	public void update(Location l) {
		gps_view_.setText(l.getLatitude() + " , " + l.getLongitude());
		for (Pub p: ps_.findPubs(l.getLatitude(),l.getLongitude())) {
        	lly_.addView(new PubSummaryLayout(this,p));
        }
	}
    
}