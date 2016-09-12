package mx.grupogarcia.courser_app4.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import mx.grupogarcia.courser_app4.R;

public class AboutActivity extends AppCompatActivity {

    private Toolbar mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mainToolbar = (Toolbar) findViewById(R.id.mainToolbar);

        if (mainToolbar != null)
        {
            setSupportActionBar(mainToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
