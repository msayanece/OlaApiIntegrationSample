package sayan.example.com.olaapiintegrationsample.olasdk.models.rideestimate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sayan on 21-Oct-17.
 */

public class FareEstimate {

    @SerializedName("fare")
    @Expose
    private String fare;
    @SerializedName("trip_id")
    @Expose
    private String tripId;

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }
}
