package vn.edu.usth.usthweatherfix;

import android.os.Bundle;
import android.util.Log;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d(WA,"onCreate");
//        ForecastFragment firstFragment = new ForecastFragment();
//        getSupportFragmentManager().beginTransaction().add(
//                R.id.main, firstFragment).commit();
        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

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
        Log.d(WA, "onDestroy");
    }

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private final String[] titles = new String[]{"Hanoi","Paris","Toulouse"};

        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
            return (titles.length);
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