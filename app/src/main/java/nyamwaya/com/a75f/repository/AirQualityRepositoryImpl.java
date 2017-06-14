package nyamwaya.com.a75f.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import nyamwaya.com.a75f.models.AirQualityModel;
import nyamwaya.com.a75f.network.AirQualityApiService;
import nyamwaya.com.a75f.models.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
    private static final String TAG = AirQualityRepositoryImpl.class.getSimpleName();
    private AirQualityApiService mApiService;

    public AirQualityRepositoryImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASEURL)
                .build();
        mApiService = retrofit.create(AirQualityApiService.class);
    }

    public LiveData<ApiResponse> getAirQualityData (String latitude, String longitude, String apikey) {
        final MutableLiveData<ApiResponse> liveData = new MutableLiveData<>();
        setUpCall(liveData, latitude,longitude,apikey);
        return liveData;
    }

    private void setUpCall(MutableLiveData<ApiResponse> liveData, String latitude, String longitude, String apikey) {
        Observable<AirQualityModel> airQualityModelObservable =
                mApiService.getAirQuality(latitude, longitude, apikey);
        airQualityModelObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AirQualityModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        liveData.setValue(new ApiResponse(e));

                    }

                    @Override
                    public void onNext(AirQualityModel airQualityModel) {
                      Log.v(TAG, "wHATS HAPPENING: " + airQualityModel.getBreezometerDescription());
                        liveData.setValue(new ApiResponse(airQualityModel));
                    }  });
    }


}
