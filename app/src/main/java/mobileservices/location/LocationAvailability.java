package mobileservices.location;

import android.content.Intent;
import android.os.Parcelable;

public interface LocationAvailability extends Parcelable {

    LocationAvailability extractLocationAvailability(Intent intent);

    boolean hasLocationAvailability(Intent intent);

    boolean isLocationAvailable();

    int getCellStatus();

    int getWifiStatus();

    long getElapsedRealtimeNs();

    int getLocationStatus();
}
