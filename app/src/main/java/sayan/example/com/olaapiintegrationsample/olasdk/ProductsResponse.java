package sayan.example.com.olaapiintegrationsample.olasdk;

/**
 * Created by Admin on 20-10-2017.
 */

import java.util.List;

/**
 * Response object containing available products.
 */
public class ProductsResponse {

    private List<Product> categories;

    /**
     * The products.
     */
    public List<Product> getProducts() {
        return categories;
    }
}