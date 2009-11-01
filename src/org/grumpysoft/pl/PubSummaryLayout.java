package org.grumpysoft.pl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class PubSummaryLayout extends LinearLayout {

	
	private static final LayoutParams lp_ = new LayoutParams(LayoutParams.FILL_PARENT, 50);
	private static final LayoutParams button_lp = new LayoutParams(
			LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	static {
		button_lp.weight = 0;
	}
	
	private final Context instantiator_;
	private final Pub pub_;
	
	private Intent map_opening_intent_;
	
	private final void init () {
		super.setLayoutParams(lp_);
		TextView pub_name = new TextView(instantiator_);
		pub_name.setText(pub_.name() + " (" + pub_.rating() + " pint(s))");
		LayoutParams pt_lp = new LayoutParams(lp_);
		pt_lp.weight = 1;
		pub_name.setLayoutParams(pt_lp);
		super.addView(pub_name);
		Button show_review = new Button(instantiator_);
		show_review.setLayoutParams(button_lp);
		show_review.setText("R");
		super.addView(show_review);
		Button show_on_map = new Button(instantiator_);
		show_on_map.setLayoutParams(button_lp);
		show_on_map.setText("M");
		show_on_map.setOnClickListener(new ShowMapListener());
		super.addView(show_on_map);
		map_opening_intent_ = new Intent();
        map_opening_intent_.setAction(Intent.ACTION_VIEW);
        StringBuilder sb = new StringBuilder();
        sb.append("geo:").append(pub_.latitude()).append(",").append(pub_.longitude()).append("?z=18");
        map_opening_intent_.setData(Uri.parse(sb.toString()));
	}
	
	public PubSummaryLayout(Context context, Pub pub) {
		super(context);
		instantiator_ = context;
		pub_ = pub;
		init();
	}
	
	private class ShowMapListener implements View.OnClickListener {

		public void onClick(View v) {
			instantiator_.startActivity(map_opening_intent_);
		}
	
	}

}
