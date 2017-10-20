package sayan.example.com.olaapiintegrationsample.olasdk;

/**
 * Created by Admin on 20-10-2017.
 */

/**
 * A product representing a type of ride on the Uber platform. See
 * <a href="https://developer.uber.com/v1/endpoints/#product-types">Products</a>
 * for more information.
 */
public class Product {

    private String id;
    private String display_name;
    private String image;

    public String getId() {
        return id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getImage() {
        return image;
    }
}
