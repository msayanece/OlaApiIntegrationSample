package sayan.example.com.olaapiintegrationsample.olasdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sayan on 20-Oct-17.
 */

public class Category {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("display_name")
    @Expose
    public String displayName;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("distance_unit")
    @Expose
    public String distanceUnit;
    @SerializedName("time_unit")
    @Expose
    public String timeUnit;
    @SerializedName("eta")
    @Expose
    public Integer eta;
    @SerializedName("distance")
    @Expose
    public String distance;
    @SerializedName("ride_later_enabled")
    @Expose
    public String rideLaterEnabled;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("fare_breakup")
    @Expose
    public List<FareBreakup> fareBreakup = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRideLaterEnabled() {
        return rideLaterEnabled;
    }

    public void setRideLaterEnabled(String rideLaterEnabled) {
        this.rideLaterEnabled = rideLaterEnabled;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<FareBreakup> getFareBreakup() {
        return fareBreakup;
    }

    public void setFareBreakup(List<FareBreakup> fareBreakup) {
        this.fareBreakup = fareBreakup;
    }

    public CancellationPolicy getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(CancellationPolicy cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    @SerializedName("cancellation_policy")
    @Expose
    public CancellationPolicy cancellationPolicy;
}
