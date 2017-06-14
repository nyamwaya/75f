package nyamwaya.com.a75f.repository;

import android.arch.lifecycle.LiveData;

import nyamwaya.com.a75f.models.ApiResponse;

/**
 * Created by Aleckson on 6/13/2017.
 */

public interface AirQualityRepository {
    LiveData<ApiResponse> getAirQualityData(String latitude, String longitude, String apikey);
}
