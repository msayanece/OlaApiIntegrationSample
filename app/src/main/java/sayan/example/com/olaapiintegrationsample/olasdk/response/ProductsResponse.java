package sayan.example.com.olaapiintegrationsample.olasdk.response;

/**
 * Created by Admin on 20-10-2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import sayan.example.com.olaapiintegrationsample.olasdk.models.Category;
import sayan.example.com.olaapiintegrationsample.olasdk.models.RideEstimate;

/**
 * Response object containing available products.
 */
public class ProductsResponse {

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("ride_estimate")
    @Expose
    private RideEstimate rideEstimate;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public RideEstimate getRideEstimate() {
        return rideEstimate;
    }

    public void setRideEstimate(RideEstimate rideEstimate) {
        this.rideEstimate = rideEstimate;
    }
}