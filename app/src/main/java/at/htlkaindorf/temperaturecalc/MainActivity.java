package at.htlkaindorf.temperaturecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button calc;
    private EditText CInput;
    private TextView FOutput;
    private TextView KOutput;
    private double resultK;
    private double resultF;
    private final double CelsiusToKalvinCourse = 273.15;
    private final double CelsiusToFahrenheitCourse = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CInput = (EditText) findViewById(R.id.edInput);
        calc = (Button) findViewById(R.id.btCalc);
        FOutput = (TextView) findViewById(R.id.tvOutValTempF);
        KOutput = (TextView) findViewById(R.id.tvOutValTempK);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double input = getInput();
                CToF(input);
                CToK(input);
                update();
            }
        });
    }

    private void CToK(double input){
        resultK = input + CelsiusToKalvinCourse;
    }

    private void CToF(double input){
        resultF = input * (9/5) + CelsiusToFahrenheitCourse;
    }

    private double getInput(){
        double res = 0.0;
        try {
            String help = CInput.getText().toString();
            res = Double.parseDouble(help);
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        return res;
    }

    private void update(){
        FOutput.setText(String.format("%.2f", resultF));
        KOutput.setText(String.format("%.2f", resultK));
    }
}