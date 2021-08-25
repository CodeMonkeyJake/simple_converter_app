package com.example.inches2meters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private EditText inchesEditText;
    private Button calculateButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
setUpButtonClickListener();





    }

    private double    convertToMeters() {

        String inchesString = inchesEditText.getText().toString();
        int inches = Integer.parseInt(inchesString);
              double  result = inches * 0.0254;

        return result;






    }

    private void findViews() {

        resultText = findViewById(R.id.text_view_result);
        inchesEditText = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.button_calculate);

    }

    private void displayResult(double meters) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");

        String metersFormatted = myDecimalFormatter.format(meters);

            resultText.setText(metersFormatted + " Meters");


    }



    private void setUpButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           double converted =  convertToMeters();
            displayResult(converted);


            }
        });
    }


}