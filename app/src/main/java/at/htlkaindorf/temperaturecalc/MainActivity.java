package at.htlkaindorf.temperaturecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button calc;
    private final double CelsiusToKalvinCourse = 273.15;
    private final double CelsiusToFahrenheitCourse = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void CToK(double input){
        double result = input + CelsiusToKalvinCourse;
    }

    private void CToF(double input){
        double result = input * (9/5) + CelsiusToFahrenheitCourse;
    }
}