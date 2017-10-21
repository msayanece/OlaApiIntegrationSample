package sayan.example.com.olaapiintegrationsample.olasdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sayan on 21-Oct-17.
 */

public class ProductsEstimateResponse {

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("ride_estimate")
    @Expose
    private List<RideEstimate> rideEstimate = null;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<RideEstimate> getRideEstimate() {
        return rideEstimate;
    }

    public void setRideEstimate(List<RideEstimate> rideEstimate) {
        this.rideEstimate = rideEstimate;
    }
}
