package nyamwaya.com.a75f.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import nyamwaya.com.a75f.R;
import nyamwaya.com.a75f.viewmodel.AirQualityViewModel;

public class ProfileDetailsActivity extends AppCompatActivity {

    private AirQualityViewModel mAirQuality;
   // private String description;
    public static final String EXTRA_NAME = "description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detailstoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        final String description = intent.getStringExtra(EXTRA_NAME);
/*

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

*/

       // description = (String) bundle.get("description");

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.main_collapsing);
        collapsingToolbar.setTitle(description);



 //       mAirQuality = (AirQualityViewModel) bundle.getSerializable("value");


    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }*/

}
