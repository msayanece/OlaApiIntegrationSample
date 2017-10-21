package sayan.example.com.olaapiintegrationsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sayan.example.com.olaapiintegrationsample.olasdk.AccessTokenManager;
import sayan.example.com.olaapiintegrationsample.olasdk.Authenticate;
import sayan.example.com.olaapiintegrationsample.olasdk.OlaRidesApi;
import sayan.example.com.olaapiintegrationsample.olasdk.SessionConfig;
import sayan.example.com.olaapiintegrationsample.olasdk.interfaces.AuthenticateCallback;
import sayan.example.com.olaapiintegrationsample.olasdk.interfaces.Service;
import sayan.example.com.olaapiintegrationsample.olasdk.models.ProductsEstimateResponse;

public class MainActivity extends AppCompatActivity {

    private final float PICK_UP_LATITUDE = 13.007046f;
    private final float PICK_UP_LONGITUDE = 77.688839f;

    private final String LOG_TAG = "sayanOla";

    SessionConfig mSessionConfig;
    private AccessTokenManager mAccessTokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSessionConfig = new SessionConfig.Builder()
                .setEnvironment(SessionConfig.Environment.SANDBOX)
                .setoAuthUrl(getResources().getString(R.string.o_auth_url))
                .setxAppToken(getResources().getString(R.string.x_app_token))
                .setUserName("msayan64@gmail.com")
                .setPassword("Titirece@50")
                .build();
        mAccessTokenManager = new AccessTokenManager();
        Authenticate.authenticateUser(this, mSessionConfig,mAccessTokenManager, new AuthenticateCallback() {

            @Override
            public void onAccessTokenSaved(String accessToken) {
                Log.d(LOG_TAG, "Access token: " + accessToken);
                Service service = OlaRidesApi.with(mSessionConfig).build().createService();
                Map<String, String> map = new HashMap<>();
                map.put("X-APP-TOKEN", mSessionConfig.getxAppToken());
                service.getRideEstimate(map,
                        PICK_UP_LATITUDE,
                        PICK_UP_LONGITUDE,
                        PICK_UP_LATITUDE + 0.12f,
                        PICK_UP_LONGITUDE + 0.04f).enqueue(new Callback<ProductsEstimateResponse>() {
                    @Override
                    public void onResponse(Call<ProductsEstimateResponse> call, Response<ProductsEstimateResponse> response) {
                        String productName = response.body().getRideEstimate().get(0).getAvailableCabs().get(0).getDisplayName();
                        Toast.makeText(MainActivity.this, "Name:"+productName, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ProductsEstimateResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error::"+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
