package nyamwaya.com.a75f.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import nyamwaya.com.a75f.models.AirQualityModel;
import nyamwaya.com.a75f.network.AirQualityApiService;
import nyamwaya.com.a75f.util.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aleckson on 6/13/2017.
 *
 * The reason for this class is to abstract the communication
 * between the data source (local database or API callas)
 * This class will use the api service to fetch air quality data from our API
 *
 * It will return the data as a LiveData.
 */

public class AirQualityRepositoryImpl implements AirQualityRepository{

    private static final String BASEURL = "https://api.breezometer.com/";
    private AirQualityApiService mApiService;

    public AirQualityRepositoryImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASEURL)
                .build();
        mApiService = retrofit.create(AirQualityApiService.class);
    }

    public LiveData<ApiResponse> getAirQualityData (String latitude, String longitude, String apikey) {
        final MutableLiveData<ApiResponse> liveData = new MutableLiveData<>();
        Call<AirQualityModel> call = mApiService.getAirQuality(latitude, longitude, apikey);

        call.enqueue(new Callback<AirQualityModel>() {
            @Override
            public void onResponse(Call<AirQualityModel> call, Response<AirQualityModel> response) {
                liveData.setValue(new ApiResponse(response.body()));
            }

            @Override
            public void onFailure(Call<AirQualityModel> call, Throwable t) {

                liveData.setValue(new ApiResponse(t));
            }
        });
        return liveData;
    }



}
