package nyamwaya.com.a75f.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import nyamwaya.com.a75f.R;
import nyamwaya.com.a75f.models.AirQualityModel;
import nyamwaya.com.a75f.ui.details.ProfileDetailsActivity;
import nyamwaya.com.a75f.viewmodel.AirQualityViewModel;

public class MainActivity extends LifecycleActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String latitude = "44.948847";
    private String longitude = "-93.292686";
    private String apikey = "5c4583083bb947f4859b203059888b31";

    private AirQualityViewModel mViewModel;

    private TextView mTextView;
    private TextView mLearnMoreTextView;

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
        mLearnMoreTextView = (TextView) findViewById(R.id.learnmore);
        lauchDetailsActivity();

    }

    private void lauchDetailsActivity(){
        mLearnMoreTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProfileDetailsActivity.class);
                startActivity(intent);
            }
        });


t 

    }
}
