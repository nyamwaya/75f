package nyamwaya.com.a75f.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleckson on 6/13/2017.
 */

public class RandomRecommendations {

        @SerializedName("children")
        @Expose
        private String children;
        @SerializedName("sport")
        @Expose
        private String sport;
        @SerializedName("health")
        @Expose
        private String health;
        @SerializedName("inside")
        @Expose
        private String inside;
        @SerializedName("outside")
        @Expose
        private String outside;

        public String getChildren() {
            return children;
        }

        public void setChildren(String children) {
            this.children = children;
        }

        public String getSport() {
            return sport;
        }

        public void setSport(String sport) {
            this.sport = sport;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = health;
        }

        public String getInside() {
            return inside;
        }

        public void setInside(String inside) {
            this.inside = inside;
        }

        public String getOutside() {
            return outside;
        }

        public void setOutside(String outside) {
            this.outside = outside;
        }

}
