package nyamwaya.com.a75f.network;

import nyamwaya.com.a75f.models.AirQualityModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Aleckson on 6/13/2017.
 */

public interface AirQualityApiService {
    @GET("baqi/")
    Observable<AirQualityModel> getAirQuality(
            @Query("lat") String latitude,
            @Query("lon") String longitude,
            @Query("key") String apikey );
}
