package com.kaineras.sandwichshop;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kaineras on 26/01/15.
 */
public class ConfirmationActivity extends ActionBarActivity {

    ArrayList<OrderSandwich> ordenSandwich;
    TextView order=null;
    String totalOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        String text=getIntent().getStringExtra("Confirmation");
        order=(TextView)findViewById(R.id.textView5);
        showOrder();
    }

    private void showOrder() {
        ordenSandwich=getIntent().getParcelableArrayListExtra("ORDERS");
        totalOrder="";
        for(int i=0;i<ordenSandwich.size();i++)
        {
            totalOrder+="Order "+(i+1)+"\n";
            totalOrder+=ordenSandwich.get(i).getOrden()+"\n";
        }
        order.setText(totalOrder);
    }
}
