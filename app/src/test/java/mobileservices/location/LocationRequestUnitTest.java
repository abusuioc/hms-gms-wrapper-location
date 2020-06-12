package mobileservices.location;

import org.junit.Test;

import static org.junit.Assert.*;

public class LocationRequestUnitTest {
    final String COUNTRY_CODE = "COUNTRY_CODE";
    final String EXTRAS_KEY = "EXTRAS_KEY";
    final String EXTRAS_VALUE = "EXTRAS_VALUE";
    final String LANGUAGE = "LANGUAGE_@";
    final long EXPIRATION_DURATION = 1020102;
    final long EXPIRATION_TIME = EXPIRATION_DURATION + 1;
    final long FASTEST_INTERVAL = EXPIRATION_DURATION + 2;
    final long INTERVAL = EXPIRATION_DURATION + 3;
    final long MAX_TIME = EXPIRATION_DURATION + 4;
    final int NUM_UPDATES = 34344;
    final float SMALLEST_DISPLACEMENT = 0.777f;

    final boolean NEED_ADDRESS = true;

    @Test
    public void setters_propagate_the_data_to_the_underlying_GMS_LocationRequest() {
        //GIVEN:
        LocationRequest locationRequest = LocationRequest.create();

        //WHEN:
        locationRequest
                .setCountryCode(COUNTRY_CODE)
                .putExtras(EXTRAS_KEY, EXTRAS_VALUE)
                .setExpirationTime(EXPIRATION_TIME)
                .setFastestInterval(FASTEST_INTERVAL)
                .setInterval(INTERVAL)
                .setLanguage(LANGUAGE)
                .setMaxWaitTime(MAX_TIME)
                .setNeedAddress(NEED_ADDRESS)
                .setNumUpdates(NUM_UPDATES)
                .setSmallestDisplacement(SMALLEST_DISPLACEMENT);

        com.google.android.gms.location.LocationRequest gmsLocationRequest = locationRequest.gmsLocationRequest;

        //THEN:
        assertEquals(gmsLocationRequest.getExpirationTime(), EXPIRATION_TIME);
        assertEquals(gmsLocationRequest.getFastestInterval(), FASTEST_INTERVAL);
        assertEquals(gmsLocationRequest.getInterval(), INTERVAL);
        assertEquals(gmsLocationRequest.getMaxWaitTime(), MAX_TIME);
        assertEquals(gmsLocationRequest.getNumUpdates(), NUM_UPDATES);
        assertEquals(gmsLocationRequest.getSmallestDisplacement(), SMALLEST_DISPLACEMENT, 0d);
    }

    @Test
    public void setters_propagate_the_data_to_the_underlying_HMS_LocationRequest() {
        //GIVEN:
        LocationRequest locationRequest = LocationRequest.create();

        //WHEN:
        locationRequest
                .setCountryCode(COUNTRY_CODE)
                .putExtras(EXTRAS_KEY, EXTRAS_VALUE)
                .setExpirationTime(EXPIRATION_TIME)
                .setFastestInterval(FASTEST_INTERVAL)
                .setInterval(INTERVAL)
                .setLanguage(LANGUAGE)
                .setMaxWaitTime(MAX_TIME)
                .setNeedAddress(NEED_ADDRESS)
                .setNumUpdates(NUM_UPDATES)
                .setSmallestDisplacement(SMALLEST_DISPLACEMENT);

        com.huawei.hms.location.LocationRequest hmsLocationRequest = locationRequest.hmsLocationRequest;

        //THEN:
        assertEquals(hmsLocationRequest.getExpirationTime(), EXPIRATION_TIME);
        assertEquals(hmsLocationRequest.getFastestInterval(), FASTEST_INTERVAL);
        assertEquals(hmsLocationRequest.getInterval(), INTERVAL);
        assertEquals(hmsLocationRequest.getMaxWaitTime(), MAX_TIME);
        assertEquals(hmsLocationRequest.getNumUpdates(), NUM_UPDATES);
        assertEquals(hmsLocationRequest.getSmallestDisplacement(), SMALLEST_DISPLACEMENT, 0d);
        assertEquals(hmsLocationRequest.getCountryCode(), COUNTRY_CODE);
        assertEquals(hmsLocationRequest.getNeedAddress(), NEED_ADDRESS);
        assertEquals(hmsLocationRequest.getLanguage(), LANGUAGE);
        assertNotNull(hmsLocationRequest.getExtras());
    }

    @Test
    public void setting_the_priority_to_the_underlying_GMS_LocationRequest() {
        //GIVEN:
        LocationRequest locationRequest1 = LocationRequest.create();
        LocationRequest locationRequest2 = LocationRequest.create();
        LocationRequest locationRequest3 = LocationRequest.create();
        LocationRequest locationRequest4 = LocationRequest.create();
        //WHEN:
        locationRequest1.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest2.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        locationRequest3.setPriority(LocationRequest.PRIORITY_LOW_POWER);
        locationRequest4.setPriority(LocationRequest.PRIORITY_NO_POWER);

        //THEN:
        assertEquals(locationRequest1.gmsLocationRequest.getPriority(), com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY);
        assertEquals(locationRequest2.gmsLocationRequest.getPriority(), com.google.android.gms.location.LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        assertEquals(locationRequest3.gmsLocationRequest.getPriority(), com.google.android.gms.location.LocationRequest.PRIORITY_LOW_POWER);
        assertEquals(locationRequest4.gmsLocationRequest.getPriority(), com.google.android.gms.location.LocationRequest.PRIORITY_NO_POWER);
    }

    @Test
    public void setting_the_priority_to_the_underlying_HMS_LocationRequest() {
        //GIVEN:
        LocationRequest locationRequest1 = LocationRequest.create();
        LocationRequest locationRequest2 = LocationRequest.create();
        LocationRequest locationRequest3 = LocationRequest.create();
        LocationRequest locationRequest4 = LocationRequest.create();
        LocationRequest locationRequest5 = LocationRequest.create();
        //WHEN:
        locationRequest1.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest2.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        locationRequest3.setPriority(LocationRequest.PRIORITY_LOW_POWER);
        locationRequest4.setPriority(LocationRequest.PRIORITY_NO_POWER);
        locationRequest5.setPriority(LocationRequest.PRIORITY_HD_ACCURACY);

        //THEN:
        assertEquals(locationRequest1.hmsLocationRequest.getPriority(), com.huawei.hms.location.LocationRequest.PRIORITY_HIGH_ACCURACY);
        assertEquals(locationRequest2.hmsLocationRequest.getPriority(), com.huawei.hms.location.LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        assertEquals(locationRequest3.hmsLocationRequest.getPriority(), com.huawei.hms.location.LocationRequest.PRIORITY_LOW_POWER);
        assertEquals(locationRequest4.hmsLocationRequest.getPriority(), com.huawei.hms.location.LocationRequest.PRIORITY_NO_POWER);
        assertEquals(locationRequest5.hmsLocationRequest.getPriority(), com.huawei.hms.location.LocationRequest.PRIORITY_HD_ACCURACY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setting_not_accepted_priority_throws_exception() throws IllegalArgumentException {
        //GIVEN:
        LocationRequest locationRequest = LocationRequest.create();

        //WHEN:
        locationRequest.setPriority(Integer.MAX_VALUE - 105);

        //THEN:
        assertEquals(locationRequest.hmsLocationRequest.getPriority(), com.huawei.hms.location.LocationRequest.PRIORITY_HD_ACCURACY);
    }

    @Test
    public void test() {
        //GIVEN:

        //WHEN:

        //THEN:
    }
}