package com.example.macprosam.ytsmovies;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    ProgressBar mprogressBar;
    TextView ratevalue,overview,summary,movieyear,moviename,movietag;
Double ratingval = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView mPlace = findViewById(R.id.imageView);
overview = findViewById(R.id.overview);
summary = findViewById(R.id.sum);
moviename = findViewById(R.id.moviename);
movieyear = findViewById(R.id.movieyear);
movietag = findViewById(R.id.tag);
        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
         //   mPlace.setImageResource(mBundle.getInt("Image"));
            Picasso.with(getApplicationContext()).load(mBundle.getString("Image")).into(mPlace);
            ratingval = mBundle.getDouble("rate");
        }
        overview.setText(mBundle.getString("overview"));
        summary.setText(mBundle.getString("desc"));
        moviename.setText(mBundle.getString("Title"));
        movieyear.setText(mBundle.getInt("year")+"");
        movietag.setText(mBundle.getString("tags"));
        ratevalue=findViewById(R.id.ratevalue);
        ratevalue.setText(ratingval+"");
        mprogressBar = (ProgressBar) findViewById(R.id.circular_progress_bar);
        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, (int)Math.round(ratingval*10) );
        anim.setDuration(1500);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();
    }
}
