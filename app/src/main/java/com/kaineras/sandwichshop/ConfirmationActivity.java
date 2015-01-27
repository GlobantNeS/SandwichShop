package com.kaineras.sandwichshop;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by kaineras on 26/01/15.
 */
public class ConfirmationActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        String text=getIntent().getStringExtra("Confirmation");
        TextView order=(TextView)findViewById(R.id.textView5);
        order.setText(text);
    }
}
