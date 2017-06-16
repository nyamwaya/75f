package nyamwaya.com.a75f.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import nyamwaya.com.a75f.R;
import nyamwaya.com.a75f.viewmodel.AirQualityViewModel;

public class ProfileDetailsActivity extends AppCompatActivity {

    private AirQualityViewModel mAirQuality;
   // private String description;
    public static final String DESCRIPTION = "description";
    public static final String CHILDREN = "children";
    public static final String SPORTS = "sports";
    public static final String HEALTH = "health";
    public static final String OUTSIDE = "outside";
    public static final String INSIDE = "inside";

    private CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detailstoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupview();
        getIntentsFromMainActivity();

    }

    private void setupview() {
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.main_collapsing);
    }

    private void getIntentsFromMainActivity() {
        Intent intent = getIntent();
        final String description = intent.getStringExtra(DESCRIPTION);
        final String children = intent.getStringExtra(CHILDREN);
        final String sports = intent.getStringExtra(SPORTS);
        final String health = intent.getStringExtra(HEALTH);
        final String inside = intent.getStringExtra(INSIDE);
        final String outside = intent.getStringExtra(OUTSIDE);

        setData(description,children,sports,health,inside,outside);
    }

    private void setData(String description, String children, String sports, String health, String inside, String outside) {
        collapsingToolbar.setTitle(description);
    }


}
