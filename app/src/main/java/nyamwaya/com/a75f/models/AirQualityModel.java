package nyamwaya.com.a75f.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleckson on 6/13/2017.
 */

public class AirQualityModel {

        @SerializedName("datetime")
        @Expose
        private String datetime;
        @SerializedName("country_name")
        @Expose
        private String countryName;
        @SerializedName("breezometer_aqi")
        @Expose
        private int breezometerAqi;
        @SerializedName("breezometer_color")
        @Expose
        private String breezometerColor;
        @SerializedName("breezometer_description")
        @Expose
        private String breezometerDescription;
        @SerializedName("country_aqi")
        @Expose
        private int countryAqi;
        @SerializedName("country_aqi_prefix")
        @Expose
        private String countryAqiPrefix;
        @SerializedName("country_color")
        @Expose
        private String countryColor;
        @SerializedName("country_description")
        @Expose
        private String countryDescription;
        @SerializedName("data_valid")
        @Expose
        private boolean dataValid;
        @SerializedName("key_valid")
        @Expose
        private boolean keyValid;
        @SerializedName("random_recommendations")
        @Expose
        private RandomRecommendations randomRecommendations;
        @SerializedName("dominant_pollutant_canonical_name")
        @Expose
        private String dominantPollutantCanonicalName;
        @SerializedName("dominant_pollutant_description")
        @Expose
        private String dominantPollutantDescription;
        @SerializedName("dominant_pollutant_text")
        @Expose
        private DominantPollutantText dominantPollutantText;

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public int getBreezometerAqi() {
            return breezometerAqi;
        }

        public void setBreezometerAqi(int breezometerAqi) {
            this.breezometerAqi = breezometerAqi;
        }

        public String getBreezometerColor() {
            return breezometerColor;
        }

        public void setBreezometerColor(String breezometerColor) {
            this.breezometerColor = breezometerColor;
        }

        public String getBreezometerDescription() {
            return breezometerDescription;
        }

        public void setBreezometerDescription(String breezometerDescription) {
            this.breezometerDescription = breezometerDescription;
        }

        public int getCountryAqi() {
            return countryAqi;
        }

        public void setCountryAqi(int countryAqi) {
            this.countryAqi = countryAqi;
        }

        public String getCountryAqiPrefix() {
            return countryAqiPrefix;
        }

        public void setCountryAqiPrefix(String countryAqiPrefix) {
            this.countryAqiPrefix = countryAqiPrefix;
        }

        public String getCountryColor() {
            return countryColor;
        }

        public void setCountryColor(String countryColor) {
            this.countryColor = countryColor;
        }

        public String getCountryDescription() {
            return countryDescription;
        }

        public void setCountryDescription(String countryDescription) {
            this.countryDescription = countryDescription;
        }

        public boolean isDataValid() {
            return dataValid;
        }

        public void setDataValid(boolean dataValid) {
            this.dataValid = dataValid;
        }

        public boolean isKeyValid() {
            return keyValid;
        }

        public void setKeyValid(boolean keyValid) {
            this.keyValid = keyValid;
        }

        public RandomRecommendations getRandomRecommendations() {
            return randomRecommendations;
        }

        public void setRandomRecommendations(RandomRecommendations randomRecommendations) {
            this.randomRecommendations = randomRecommendations;
        }

        public String getDominantPollutantCanonicalName() {
            return dominantPollutantCanonicalName;
        }

        public void setDominantPollutantCanonicalName(String dominantPollutantCanonicalName) {
            this.dominantPollutantCanonicalName = dominantPollutantCanonicalName;
        }

        public String getDominantPollutantDescription() {
            return dominantPollutantDescription;
        }

        public void setDominantPollutantDescription(String dominantPollutantDescription) {
            this.dominantPollutantDescription = dominantPollutantDescription;
        }

        public DominantPollutantText getDominantPollutantText() {
            return dominantPollutantText;
        }

        public void setDominantPollutantText(DominantPollutantText dominantPollutantText) {
            this.dominantPollutantText = dominantPollutantText;
        }

}
