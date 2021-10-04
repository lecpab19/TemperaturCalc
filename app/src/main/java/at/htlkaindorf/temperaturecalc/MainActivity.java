package at.htlkaindorf.temperaturecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button calc;
    private Editable CInput;
    private Editable FOutput;
    private Editable KOutput;
    private double resultK;
    private double resultF;
    private final double CelsiusToKalvinCourse = 273.15;
    private final double CelsiusToFahrenheitCourse = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void CToK(double input){
        resultK = input + CelsiusToKalvinCourse;
    }

    private void CToF(double input){
        resultF = input * (9/5) + CelsiusToFahrenheitCourse;
    }

    private void update(){
        FOutput.setText(resultF);
        KOutput.setText(resultK);
    }
}