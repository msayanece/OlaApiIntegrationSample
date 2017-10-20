package sayan.example.com.olaapiintegrationsample.olasdk;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Admin on 20-10-2017.
 */

public interface Service {

    /**
     * Gets information about the products offered at a given location.
     *
     * @param latitude Latitude component of location.
     * @param longitude Longitude component of location.
     *
     * @return the request {@link Call}
     */
    @Headers("X-APP-TOKEN: f93d19f727524bb6b625df7403fb2879")
    @GET("/v1/products")
    Call<ProductsResponse> getProducts(@Query("latitude") float latitude,
                                       @Query("longitude") float longitude);

}
