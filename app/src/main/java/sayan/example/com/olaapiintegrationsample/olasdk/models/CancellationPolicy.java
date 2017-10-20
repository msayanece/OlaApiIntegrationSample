package sayan.example.com.olaapiintegrationsample.olasdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sayan on 20-Oct-17.
 */

public class CancellationPolicy {

    @SerializedName("cancellation_charge")
    @Expose
    public Integer cancellationCharge;

    public Integer getCancellationCharge() {
        return cancellationCharge;
    }

    public void setCancellationCharge(Integer cancellationCharge) {
        this.cancellationCharge = cancellationCharge;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getCancellationChargeAppliesAfterTime() {
        return cancellationChargeAppliesAfterTime;
    }

    public void setCancellationChargeAppliesAfterTime(Integer cancellationChargeAppliesAfterTime) {
        this.cancellationChargeAppliesAfterTime = cancellationChargeAppliesAfterTime;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    @SerializedName("currency")

    @Expose
    public String currency;
    @SerializedName("cancellation_charge_applies_after_time")
    @Expose
    public Integer cancellationChargeAppliesAfterTime;
    @SerializedName("time_unit")
    @Expose
    public String timeUnit;
}
