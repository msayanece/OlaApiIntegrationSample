package sayan.example.com.olaapiintegrationsample.olasdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sayan on 20-Oct-17.
 */

public class FareBreakup {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMinimumDistance() {
        return minimumDistance;
    }

    public void setMinimumDistance(String minimumDistance) {
        this.minimumDistance = minimumDistance;
    }

    public String getMinimumTime() {
        return minimumTime;
    }

    public void setMinimumTime(String minimumTime) {
        this.minimumTime = minimumTime;
    }

    public String getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(String baseFare) {
        this.baseFare = baseFare;
    }

    public String getMinimumFare() {
        return minimumFare;
    }

    public void setMinimumFare(String minimumFare) {
        this.minimumFare = minimumFare;
    }

    public String getCostPerDistance() {
        return costPerDistance;
    }

    public void setCostPerDistance(String costPerDistance) {
        this.costPerDistance = costPerDistance;
    }

    public String getWaitingCostPerMinute() {
        return waitingCostPerMinute;
    }

    public void setWaitingCostPerMinute(String waitingCostPerMinute) {
        this.waitingCostPerMinute = waitingCostPerMinute;
    }

    public String getRideCostPerMinute() {
        return rideCostPerMinute;
    }

    public void setRideCostPerMinute(String rideCostPerMinute) {
        this.rideCostPerMinute = rideCostPerMinute;
    }

    public Boolean getRatesHigherThanUsual() {
        return ratesHigherThanUsual;
    }

    public void setRatesHigherThanUsual(Boolean ratesHigherThanUsual) {
        this.ratesHigherThanUsual = ratesHigherThanUsual;
    }

    public List<Object> getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(List<Object> surcharge) {
        this.surcharge = surcharge;
    }

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("minimum_distance")
    @Expose
    public String minimumDistance;
    @SerializedName("minimum_time")
    @Expose
    public String minimumTime;
    @SerializedName("base_fare")
    @Expose
    public String baseFare;
    @SerializedName("minimum_fare")
    @Expose
    public String minimumFare;
    @SerializedName("cost_per_distance")
    @Expose
    public String costPerDistance;
    @SerializedName("waiting_cost_per_minute")
    @Expose
    public String waitingCostPerMinute;
    @SerializedName("ride_cost_per_minute")
    @Expose
    public String rideCostPerMinute;
    @SerializedName("rates_higher_than_usual")
    @Expose
    public Boolean ratesHigherThanUsual;
    @SerializedName("surcharge")
    @Expose
    public List<Object> surcharge = null;
}
