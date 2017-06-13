package nyamwaya.com.a75f.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import nyamwaya.com.a75f.repository.AirQualityRepository;
import nyamwaya.com.a75f.repository.AirQualityRepositoryImpl;
import nyamwaya.com.a75f.util.ApiResponse;

/**
 * Created by Aleckson on 6/13/2017.
 *
 * This viewmodel will fetch data requested by the UI from the AirQuality Repository.
 *
 */

public class AirQualityViewModel extends ViewModel{

    private MediatorLiveData<ApiResponse> mApiResponse;
    private AirQualityRepository mAirQualityRepository;

    public AirQualityViewModel() {
        mApiResponse = new MediatorLiveData<>();
        mAirQualityRepository = new AirQualityRepositoryImpl();
    }

    @NonNull
    public LiveData<ApiResponse> getApiResponse(){
        return mApiResponse;
    }

    public LiveData<ApiResponse> loadAirQuality(@NonNull String latitude, String longitude, String apikey){
        mApiResponse.addSource(
                mAirQualityRepository.getAirQualityData(latitude,longitude,apikey),
                apiResponse -> mApiResponse.setValue(apiResponse)
        );
        return mApiResponse;
    }
}
