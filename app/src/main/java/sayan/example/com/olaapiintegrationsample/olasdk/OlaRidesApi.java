package sayan.example.com.olaapiintegrationsample.olasdk;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sayan.example.com.olaapiintegrationsample.olasdk.interfaces.Service;

/**
 * Created by Admin on 20-10-2017.
 */

public class OlaRidesApi {
    private final Retrofit retrofit;

    private OlaRidesApi(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    /**
     * Builder for {@link OlaRidesApi}
     */
    public static class Builder {
        SessionConfig session;
        Builder(SessionConfig session) {
            this.session = session;
        }
        /**
         * Create the {@link OlaRidesApi} to be used.
         *
         * @return {@link OlaRidesApi}
         */
        public OlaRidesApi build() {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(session.getEnvironment())
                    .build();

            return new OlaRidesApi(retrofit);
        }
    }

    /**
     * Starts a {@link Builder} with a {@link SessionConfig} to create Ola Services.
     *
     * @param session required {@link SessionConfig}
     */
    public static Builder with(SessionConfig session) {
        return new Builder(session);
    }

    /**
     * Get the {@link Service} to use with the Ola API.
     * Consumers should cache and reuse this object.
     *
     * @return {@link Service}
     */
    public Service createService() {
        return retrofit.create(Service.class);
    }
}
