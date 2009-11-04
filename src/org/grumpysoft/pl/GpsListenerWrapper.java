package org.grumpysoft.pl;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

//clients merely want to be told an accurate location, and nothing else.
public class GpsListenerWrapper implements LocationListener {

	private final LocationManager lm_;
	private final UpdatableLocation ul_;
	
	public GpsListenerWrapper(UpdatableLocation ul, Context instantiator) {
		ul_ = ul;
		lm_ = (LocationManager) instantiator.getSystemService(Context.LOCATION_SERVICE);
		lm_.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
				30000, 250, this);
	}

	public void onLocationChanged(Location location) {
		ul_.update(location);
		
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
}
