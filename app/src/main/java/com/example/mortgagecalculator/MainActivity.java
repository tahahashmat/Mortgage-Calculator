package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText principal, interest, years;
    private TextView monthlyEMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        principal = (EditText)findViewById(R.id.principal_amount);
        interest = (EditText)findViewById(R.id.interest_rate);
        years = (EditText)findViewById(R.id.total_years);
        monthlyEMI = (TextView)findViewById(R.id.calculated_emi);

    }

    public void calculatePayments(View clickedButton){

        double principalAmount = Double.parseDouble(principal.getText().toString());
        double interestRate = Double.parseDouble(interest.getText().toString());
        double totalYears = Double.parseDouble(years.getText().toString());

        double p = principalAmount;
        double r = (interestRate/12)/100;
        double n = totalYears * 12;

        double r1 = Math.pow((1+r), n);
        double emi = p * ((r*r1)/(r1-1));

        monthlyEMI.setText(new DecimalFormat(".00").format(emi));





    }
}