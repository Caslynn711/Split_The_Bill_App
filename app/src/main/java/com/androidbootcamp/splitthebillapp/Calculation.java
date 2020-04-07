package com.androidbootcamp.splitthebillapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculation extends AppCompatActivity {
    String groupChoice;
    double billTotal;
    int totalPeople;
    double costPerPerson;
    double tipAmount = 1.18;
    double tip;
    double totalBillWithTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        final EditText partyTotal = (EditText)findViewById(R.id.txtPartyTotal);
        final EditText billAmount = (EditText)findViewById(R.id.txtBill);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        Button calculate = (Button)findViewById(R.id.btnCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.Result));
            @Override
            public void onClick(View v) {
                totalPeople = Integer.parseInt(partyTotal.getText().toString());
                billTotal = Double.parseDouble(billAmount.getText().toString());
                tip = billTotal * 0.18;
                totalBillWithTip = billTotal * tipAmount;
                costPerPerson = totalBillWithTip / totalPeople;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Tip percent for " + groupChoice + " service is 18%. " +
                        "Tip amount: " + currency.format(tip) +
                        " Total Bill with Tip: "+ currency.format(totalBillWithTip) +
                        " Total cost per person: " + currency.format(costPerPerson));




            }
        });


    }
}
