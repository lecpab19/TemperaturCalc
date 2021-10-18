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
    private EditText FOutput;
    private EditText KOutput;
    private double resultK;
    private double resultF;
    private double resultC;
    private final double CelsiusToKalvinCourse = 273.15;
    private final double CelsiusToFahrenheitCourse = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CInput = (EditText) findViewById(R.id.tvOutValTempC);
        calc = (Button) findViewById(R.id.btCalc);
        FOutput = (EditText) findViewById(R.id.tvOutValTempF);
        KOutput = (EditText) findViewById(R.id.tvOutValTempK);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int index = readScreen();
                    /*double input = getInput();
                    CToF(input);
                    CToK(input);
                    update();*/
                } catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    private void manage(int index){
        double value;
        switch (index){
            case 1:
                value = getInput(CInput);
                CToF(value);
                CToF(value);
                break;
            case 2:
                value = getInput(KOutput);
                KToC(value);
                KToF(value);
                break;
            case 3:
                value = getInput(FOutput);
                FToC(value);
                FToK(value);
                break;
        }
    }

    private int readScreen(){
        int index = 0;
        if(!CInput.getText().toString().equals("")){
            index = 1;
        } else if(!FOutput.getText().toString().equals("")){
            index = 2;
        } else if(!KOutput.getText().toString().equals("")){
            index = 3;
        }

        return index;
    }

    private void CToK(double input){
        resultK = input + CelsiusToKalvinCourse;
        KOutput.setText(String.format("%.2f", resultK));
    }

    private void CToF(double input){
        resultF = input * 1.8 + CelsiusToFahrenheitCourse;
        FOutput.setText(String.format("%.2f", resultF));
    }

    private void FToC(double input){
        resultC = (input - CelsiusToFahrenheitCourse) / 1.8;
    }

    private void FToK(double input){

    }

    private void KToC(double input){
        resultC = input - CelsiusToKalvinCourse;
    }

    private void KToF(double input){

    }

    private double getInput(EditText text) throws NumberFormatException{
        double res = 0.0;
        String help = text.getText().toString();
        res = Double.parseDouble(help);

        return res;
    }
}