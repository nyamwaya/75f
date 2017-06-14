package nyamwaya.com.a75f;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.widget.TextView;

import nyamwaya.com.a75f.models.AirQualityModel;
import nyamwaya.com.a75f.viewmodel.AirQualityViewModel;

public class MainActivity extends LifecycleActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String latitude = "44.948847";
    private String longitude = "-93.292686";
    private String apikey = "5c4583083bb947f4859b203059888b31";

    private AirQualityViewModel mViewModel;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(AirQualityViewModel.class);
        mViewModel.loadAirQuality(latitude, longitude, apikey);
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
        Log.v(TAG, "You have data coming in!");
        mTextView.setText("You have " + airQualityModel.getBreezometerDescription()
                + " today. Your main pollutant is, "
                + airQualityModel.getDominantPollutantDescription());

    }


    private void handleError(Throwable error) {
        Log.v(TAG, "Something went wrong while fetching data");
    }

    private void setupView() {
        mTextView = (TextView) findViewById(R.id.airquality);

    }
}
