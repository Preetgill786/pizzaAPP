package com.example.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    Spinner sp;
    RadioGroup rgSize, rgDeliveryOption;
    RadioButton rbLarge, rbMedium, rbSmall, rbDelivery, rbPick;
    CheckBox cbChicken, cbBeef, cbPineapple, cbPapparoni, cbDrinks;
    EditText etBill;
    double[] finalPrice;
    double[] price = {6.65, 7.05, 5.55, 6.00, 9.55, 10.00};
    static int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etBill = findViewById(R.id.paise);
        cbChicken = findViewById(R.id.murga);
        cbBeef = findViewById(R.id.majj);
        cbPineapple = findViewById(R.id.pineApple);
        cbPapparoni = findViewById(R.id.pppp);
        cbDrinks = findViewById(R.id.darru);
        sp = findViewById(R.id.pizzaType);
        rgSize = findViewById(R.id.rgSize);
        rgDeliveryOption = findViewById(R.id.rgkiveKrna);
        rbLarge = findViewById(R.id.large);
        rbMedium = findViewById(R.id.medium);
        rbSmall = findViewById(R.id.small);
        rbDelivery = findViewById(R.id.ghre);
        rbPick = findViewById(R.id.lajoo);
        //list for pizza type

        List<String> pizza = new ArrayList<String>();
        pizza.add("Banquet Cheddar");
        pizza.add("Veggie");
        pizza.add("ExtravaganZZa");
        pizza.add("Brooklyn Pizza");
        pizza.add("BBQ Chicken Feast");
        pizza.add("Canadian Pizza");
      rbSmall.setOnClickListener(this);
        rbMedium.setOnClickListener(this);
        rbLarge.setOnClickListener(this);
       rgSize.setOnCheckedChangeListener(this);
       cbChicken.setOnCheckedChangeListener(this);
       cbBeef.setOnCheckedChangeListener(this);
       cbPapparoni.setOnCheckedChangeListener(this);
       cbPineapple.setOnCheckedChangeListener(this);
       cbDrinks.setOnCheckedChangeListener(this);
        //create an adapter and fill it from the list
        ArrayAdapter<String> pizzaAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, pizza);
        //make the drop down style
        pizzaAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //fill the spinner with the adapter items
        sp.setAdapter(pizzaAdapter);
        sp.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        i=position;
Double pr= new Double(price[i]);
       etBill.setText(pr.toString());


        }

        @Override
        public void onNothingSelected (AdapterView < ? > adapterView){

        }

    @Override
    public void onCheckedChanged(RadioGroup rg, int id) {
           double pp;
        if(rbSmall.isChecked()){
            pp = price[i];
            Double pr = new Double(pp);
            etBill.setText(pr.toString());
        }else if(rbMedium.isChecked()){
            pp = price[i]+3;
            Double pr = new Double(pp);
            etBill.setText(pr.toString());
        }else if(rbLarge.isChecked()){
            pp = price[i]+7;
            Double pr = new Double(pp);
            etBill.setText(pr.toString());
        }

    }


    @Override
    public void onClick(View view) {


    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        }
    }


