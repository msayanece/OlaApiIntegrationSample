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
import sayan.example.com.olaapiintegrationsample.olasdk.postparameters.RideRequestParameters;
import sayan.example.com.olaapiintegrationsample.olasdk.response.RideResponse;

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
                Map<String, String> headerMap = new HashMap<>();
                headerMap.put("Authorization", "Bearer "+accessToken);
                headerMap.put("X-APP-TOKEN", mSessionConfig.getxAppToken());
                headerMap.put("Content-Type", "application/json");
                RideRequestParameters rideRequestParameters =
                        new RideRequestParameters.Builder()
                                .setCategory("mini")
                                .setPickupMode("NOW")
                                .setPickupLat(PICK_UP_LATITUDE)
                                .setPickupLng(PICK_UP_LONGITUDE)
                                .setDropLat(PICK_UP_LATITUDE+0.1f)
                                .setDropLng(PICK_UP_LONGITUDE+0.1f)
                                .build();
                service.requestRide(headerMap, rideRequestParameters).enqueue(new Callback<RideResponse>() {
                    @Override
                    public void onResponse(Call<RideResponse> call, Response<RideResponse> response) {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<RideResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
