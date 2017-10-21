package sayan.example.com.olaapiintegrationsample.olasdk.interfaces;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import sayan.example.com.olaapiintegrationsample.olasdk.postparameters.RideRequestParameters;
import sayan.example.com.olaapiintegrationsample.olasdk.response.ProductsEstimateResponse;
import sayan.example.com.olaapiintegrationsample.olasdk.response.ProductsResponse;
import sayan.example.com.olaapiintegrationsample.olasdk.response.RideResponse;

/**
 * Created by Admin on 20-10-2017.
 */

public interface Service {

    /**
     * Gets information about the products offered at a given location.
     *
     * @param headers mandatory header map with key...
     *                1) X-APP-TOKEN and value got from the OLA developer dashboard
     * @param latitude Latitude component of pickup location.
     * @param longitude Longitude component of pickup location.
     *
     * @return the request {@link Call}
     */
    @GET("/v1/products")
    Call<ProductsResponse> getProducts(@HeaderMap Map<String, String> headers,
                                       @Query("pickup_lat") float latitude,
                                       @Query("pickup_lng") float longitude);

    /**
     * Gets estimated values about the products offered at a given pickup location with a drop location.
     *
     * @param headers mandatory header map with key...
     *                1) X-APP-TOKEN and value got from the OLA developer dashboard
     * @param pickupLatitude Latitude component of pickup location.
     * @param pickupLongitude Longitude component of pickup location.
     * @param dropLatitude Latitude component of drop location.
     * @param dropLongitude Longitude component of drop location.
     *
     * @return the request {@link Call}
     */
    @GET("/v1/products")
    Call<ProductsEstimateResponse> getRideEstimate(@HeaderMap Map<String, String> headers,
                                                   @Query("pickup_lat") float pickupLatitude,
                                                   @Query("pickup_lng") float pickupLongitude,
                                                   @Query("drop_lat") float dropLatitude,
                                                   @Query("drop_lng") float dropLongitude);

    /**
     * Requests a ride on behalf of a user given the RideRequestParameters.
     *
     * @param rideRequestParameters The ride request parameters.
     *                              Create an object of RideRequestParameters using builder class
     *
     * @param headers mandatory header map with key...
     *                1) X-APP-TOKEN and value got from the OLA developer dashboard
     *                2) Authorization and value access token got from the OLA after user logged in like...
     *                      "Bearer baac2cfc6be4489***f"
     *                3) Content-Type and value as "application/json" must
     * @return the request {@link Call}
     */
    @POST("/v1/bookings/create")
    Call<RideResponse> requestRide(@HeaderMap Map<String, String> headers, @Body RideRequestParameters rideRequestParameters);

}
