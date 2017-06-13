package nyamwaya.com.a75f.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleckson on 6/13/2017.
 */

public class DominantPollutantText {

    @SerializedName("main")
    @Expose
    private String main;
    @SerializedName("effects")
    @Expose
    private String effects;
    @SerializedName("causes")
    @Expose
    private String causes;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects;
    }

    public String getCauses() {
        return causes;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }

}
