package vn.edu.usth.usthweatherfix;

import android.os.Bundle;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
}