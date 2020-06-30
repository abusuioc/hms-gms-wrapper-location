package mobileservices.location;

import java.util.ArrayList;
import java.util.Collection;

public class LocationSettingsRequest {

    final com.google.android.gms.location.LocationSettingsRequest gmsLocationSettingsRequest;
    final com.huawei.hms.location.LocationSettingsRequest hmsLocationSettingsRequest;

    LocationSettingsRequest(
            com.google.android.gms.location.LocationSettingsRequest gmsLocationSettingsRequest,
            com.huawei.hms.location.LocationSettingsRequest hmsLocationSettingsRequest
    ) {
        this.gmsLocationSettingsRequest = gmsLocationSettingsRequest;
        this.hmsLocationSettingsRequest = hmsLocationSettingsRequest;
    }


    public static class Builder {
        final private com.google.android.gms.location.LocationSettingsRequest.Builder gmsLocationSettingsRequestBuilder;
        final private com.huawei.hms.location.LocationSettingsRequest.Builder hmsLocationSettingsRequestBuilder;

        public Builder() {
            gmsLocationSettingsRequestBuilder = new com.google.android.gms.location.LocationSettingsRequest.Builder();
            hmsLocationSettingsRequestBuilder = new com.huawei.hms.location.LocationSettingsRequest.Builder();
        }

        public LocationSettingsRequest.Builder addAllLocationRequests(Collection<LocationRequest> requests) {
            if (requests == null || requests.isEmpty()) {
                return this;
            }
            final Collection<com.google.android.gms.location.LocationRequest> gmsCollection = new ArrayList<>(requests.size());
            final Collection<com.huawei.hms.location.LocationRequest> hmsCollection = new ArrayList<>(requests.size());
            for (LocationRequest locationRequest : requests) {
                gmsCollection.add(locationRequest.gmsLocationRequest);
                hmsCollection.add(locationRequest.hmsLocationRequest);
            }
            gmsLocationSettingsRequestBuilder.addAllLocationRequests(gmsCollection);
            hmsLocationSettingsRequestBuilder.addAllLocationRequests(hmsCollection);
            return this;
        }

        public LocationSettingsRequest.Builder addLocationRequest(LocationRequest request) {
            gmsLocationSettingsRequestBuilder.addLocationRequest(request.gmsLocationRequest);
            hmsLocationSettingsRequestBuilder.addLocationRequest(request.hmsLocationRequest);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(
                    gmsLocationSettingsRequestBuilder.build(),
                    hmsLocationSettingsRequestBuilder.build()
            );
        }

        public LocationSettingsRequest.Builder setAlwaysShow(boolean alwaysShow) {
            gmsLocationSettingsRequestBuilder.setAlwaysShow(alwaysShow);
            hmsLocationSettingsRequestBuilder.setAlwaysShow(alwaysShow);
            return this;
        }

        public LocationSettingsRequest.Builder setNeedBle(boolean needBle) {
            gmsLocationSettingsRequestBuilder.setNeedBle(needBle);
            hmsLocationSettingsRequestBuilder.setNeedBle(needBle);
            return this;
        }
    }
}
