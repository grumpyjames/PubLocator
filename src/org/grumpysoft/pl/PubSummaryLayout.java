package org.grumpysoft.pl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class PubSummaryLayout extends LinearLayout {

	private static final LayoutParams lp_ = new LayoutParams(LayoutParams.FILL_PARENT, 50);
	
	private final Pub pub_;	
	
	// Common initialization for both constructors
	private final void init (Context context) {
		super.setLayoutParams(lp_);
		TextView pub_name = new TextView(context);
		pub_name.setGravity(Gravity.CENTER);
		pub_name.setText(pub_.name());
		super.addView(pub_name);
	}
	
	public PubSummaryLayout(Context context, Pub pub) {
		super(context);
		pub_ = pub;
		init(context);
	}

	public PubSummaryLayout(Context context, AttributeSet attrs, Pub pub) {
		super(context, attrs);
		pub_ = pub;
		init(context);
	}

}
