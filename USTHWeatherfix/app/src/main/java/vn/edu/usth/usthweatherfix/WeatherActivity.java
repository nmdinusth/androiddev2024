package vn.edu.usth.usthweatherfix;

import android.os.Bundle;
import android.util.Log;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import java.security.PublicKey;

public class WeatherActivity extends AppCompatActivity {
    private static final String WA = "WeatherActivity";

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(WA,"onCreate");

        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

        mediaPlayer = MediaPlayer.create(this, R.raw.audio1);

        mediaPlayer.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(WA, "Oncreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(WA, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(WA,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(WA,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
        Log.d(WA, "onDestroy");
    }

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private String[] titles = new String[]{"Hanoi","Da Nang","Tokyo"};
        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @NonNull
        @Override
        public Fragment getItem(int page){

            return new WeatherAndForecastFragment();
        }

        @Override
        public CharSequence getPageTitle(int page) {
            return titles[page];
        }
    }
}