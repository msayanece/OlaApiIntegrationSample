package sayan.example.com.olaapiintegrationsample.olasdk.interfaces;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;
import sayan.example.com.olaapiintegrationsample.olasdk.models.ProductsEstimateResponse;
import sayan.example.com.olaapiintegrationsample.olasdk.models.ProductsResponse;

/**
 * Created by Admin on 20-10-2017.
 */

public interface Service {

    /**
     * Gets information about the products offered at a given location.
     *
     * @param headers mandatory header map with key X-APP-TOKEN and value got from the OLA developer dashboard
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
     * @param headers mandatory header map with key X-APP-TOKEN and value got from the OLA developer dashboard
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

}
