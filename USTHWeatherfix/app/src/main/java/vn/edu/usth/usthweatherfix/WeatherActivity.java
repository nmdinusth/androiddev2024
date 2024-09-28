package vn.edu.usth.usthweatherfix;

import android.os.Bundle;
import android.util.Log;
import android.media.MediaPlayer;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

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

        Toolbar Toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(Toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int itemId = item.getItemId();
        if (itemId == R.id.search) {
            return true;
}
        return super.onOptionsItemSelected(item);}
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