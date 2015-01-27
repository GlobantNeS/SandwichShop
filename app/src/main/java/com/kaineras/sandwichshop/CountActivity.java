package com.kaineras.sandwichshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by kaineras on 27/01/15.
 */
public class CountActivity extends ActionBarActivity {
    Button bNext=null;
    Spinner spinner=null;
    ArrayList<OrderSandwich> ordenSandwich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        spinner=(Spinner) findViewById(R.id.sCountSandiwch);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.count_sandwich, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        prepareButton();
    }

    private void prepareButton() {
        bNext=(Button)findViewById(R.id.button2);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent order=new Intent(CountActivity.this,MainActivity.class);
                order.putParcelableArrayListExtra("ORDERS",ordenSandwich);
                order.putExtra("TOTALORDERS",spinner.getSelectedItem().toString());
                order.putExtra("NUM",0);
                startActivity(order);
            }
        });
    }
}
