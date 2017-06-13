package nyamwaya.com.a75f;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nyamwaya.com.a75f.models.AirQualityModel;
import nyamwaya.com.a75f.viewmodel.AirQualityViewModel;

public class MainActivity extends LifecycleActivity {

    private String latitude = "44.948847" ;
    private String longitude = "-93.292686";
    private String apikey = "5c4583083bb947f4859b203059888b31";

    private AirQualityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(AirQualityViewModel.class);
        setupView();

        //Handle changes emitted by LiveData
        mViewModel.getApiResponse().observe(this, apiResponse -> {
            if (apiResponse.getError() != null) {
                handleError(apiResponse.getError());
            } else {
                handleResponse(apiResponse.getAirQualityModel());
            }
        });
    }

    private void handleResponse(AirQualityModel airQualityModel) {

    }

    private void handleError(Throwable error) {

    }

    private void setupView() {

    }
}
