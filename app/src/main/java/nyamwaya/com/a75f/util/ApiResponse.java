package nyamwaya.com.a75f.util;

import nyamwaya.com.a75f.models.AirQualityModel;

/**
 * Created by Aleckson on 6/13/2017.
 *
 * Used to communicate data from repository to ViewModel
 * and ultimately to view model
 */

public class ApiResponse {
    private AirQualityModel airQualityModel;
    private Throwable error;

    public ApiResponse(AirQualityModel airQualityModel) {
        this.airQualityModel = airQualityModel;
        this.error = null;
    }

    public ApiResponse(Throwable error) {
        this.error = error;
        this.airQualityModel = null;
    }

    public AirQualityModel getAirQualityModel() {
        return airQualityModel;
    }

    public void setAirQualityModel(AirQualityModel airQualityModel) {
        this.airQualityModel = airQualityModel;
    }
}
