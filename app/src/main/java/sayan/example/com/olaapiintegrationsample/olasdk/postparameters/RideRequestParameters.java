package sayan.example.com.olaapiintegrationsample.olasdk.postparameters;


import android.support.annotation.NonNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Sayan on 21-Oct-17.
 */

public class RideRequestParameters {

    @Nonnull
    private Float pickup_lat;
    @Nonnull
    private Float pickup_lng;
    @Nonnull
    private Float drop_lat;
    @Nonnull
    private Float drop_lng;
    @Nonnull
    private String pickup_mode;
    @Nonnull
    private String category;

    private RideRequestParameters(Float pickup_lat, Float pickup_lng, Float drop_lat, Float drop_lng, String pickup_mode, String category) {
        this.pickup_lat = pickup_lat;
        this.pickup_lng = pickup_lng;
        this.drop_lat = drop_lat;
        this.drop_lng = drop_lng;
        this.pickup_mode = pickup_mode;
        this.category = category;
    }

    /**
     * Builder for ride request parameters.
     */
    public static class Builder {

        private Float pickupLat;
        private Float pickupLng;
        private Float dropLat;
        private Float dropLng;
        private String pickupMode;
        private String category;

        public Builder() {
        }

        public Builder(
                @NonNull Float pickupLat, @Nonnull Float pickupLng, @Nonnull Float dropLat,
                @Nonnull Float dropLng, @Nonnull String pickupMode, @Nonnull String category) {
            this.pickupLat = pickupLat;
            this.pickupLng = pickupLng;
            this.dropLat = dropLat;
            this.dropLng = dropLng;
            this.pickupMode = pickupMode;
            this.category = category;
        }

        /**
         * Sets the pickup location's latitude.
         *
         * @param pickupLat the pickup location's latitude.
         */
        public Builder setPickupLat(@Nonnull Float pickupLat) {
            this.pickupLat = pickupLat;
            return this;
        }

        /**
         * Sets the pickup location's longitude.
         *
         * @param pickupLng the pickup location's longitude.
         */
        public Builder setPickupLng(@Nonnull Float pickupLng) {
            this.pickupLng = pickupLng;
            return this;
        }

        /**
         * Sets the drop location's latitude.
         *
         * @param dropLat the drop location's latitude.
         */
        public Builder setDropLat(@Nonnull Float dropLat) {
            this.dropLat = dropLat;
            return this;
        }

        /**
         * Sets the drop location's longitude.
         *
         * @param dropLng the drop location's longitude.
         */
        public Builder setDropLng(@Nonnull Float dropLng) {
            this.dropLng = dropLng;
            return this;
        }

        /**
         * Sets the pickup time modes.
         *
         * @param pickupMode the pickup time modes. Valid modes : "NOW", "LATER"
         */
        public Builder setPickupMode(@Nonnull String pickupMode) {
            this.pickupMode = pickupMode;
            return this;
        }

        /**
         * Sets the category.
         *
         * @param category Car category type, ex: mini. Valid categories:  micro, mini, sedan, prime, etc .
         *                 For sandbox use only "mini"
         */
        public Builder setCategory(@Nonnull String category) {
            this.category = category;
            return this;
        }

        /**
         * Builds a {@link RideRequestParameters}.
         */
        public RideRequestParameters build() {
            return new RideRequestParameters(pickupLat, pickupLng, dropLat, dropLng, pickupMode, category);
        }
    }

    @Nonnull
    public Builder newBuilder() {
        return new Builder(pickup_lat, pickup_lng, drop_lat, drop_lng, pickup_mode, category);
    }

    @Nullable
    public Float getPickupLat() {
        return pickup_lat;
    }

    public void setPickupLat(@Nullable Float pickup_lat) {
        this.pickup_lat = pickup_lat;
    }

    @Nullable
    public Float getPickupLng() {
        return pickup_lng;
    }

    public void setPickupLng(@Nullable Float pickup_lng) {
        this.pickup_lng = pickup_lng;
    }

    @Nullable
    public Float getDropLat() {
        return drop_lat;
    }

    public void setDropLat(@Nullable Float drop_lat) {
        this.drop_lat = drop_lat;
    }

    @Nullable
    public Float getDropLng() {
        return drop_lng;
    }

    public void setDropLng(@Nullable Float drop_lng) {
        this.drop_lng = drop_lng;
    }

    @Nullable
    public String getPickupMode() {
        return pickup_mode;
    }

    public void setPickupMode(@Nullable String pickup_mode) {
        this.pickup_mode = pickup_mode;
    }

    @Nullable
    public String getCategory() {
        return category;
    }

    public void setCategory(@Nullable String category) {
        this.category = category;
    }
}
