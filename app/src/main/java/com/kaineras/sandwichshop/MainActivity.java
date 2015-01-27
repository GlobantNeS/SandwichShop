package com.kaineras.sandwichshop;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {

    Spinner spinner=null;
    RadioButton []rb=new RadioButton[3];
    Button button=null;

    CheckBox []cb=new CheckBox[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.list_sandwich, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        prepareRadios();
        preareCheckBox();
        prepareButton();

    }

    private void preareCheckBox() {
        cb[0]=(CheckBox)findViewById(R.id.cbChili);
        cb[1]=(CheckBox)findViewById(R.id.cbJam);
        cb[2]=(CheckBox)findViewById(R.id.cbKetchup);
        cb[3]=(CheckBox)findViewById(R.id.cbMayonnaise);
        cb[4]=(CheckBox)findViewById(R.id.cbMustard);
        cb[5]=(CheckBox)findViewById(R.id.cbTomatoe);


    }

    private void prepareRadios() {
        rb[0]=(RadioButton) findViewById(R.id.rWheat);
        rb[1]=(RadioButton) findViewById(R.id.rWhite);
        rb[2]=(RadioButton) findViewById(R.id.rRye);
    }

    private void prepareButton() {
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String confirm=createString();
                Intent nextActivity= new Intent(MainActivity.this,ConfirmationActivity.class);
                nextActivity.putExtra("Confirmation",confirm);
                startActivity(nextActivity);
            }
        });
    }

    private String createString() {
        String result="";
        result+="Sandiwch:\n\t\t\t";
        result+=spinner.getSelectedItem().toString();
        result+="\nBread:";
        for(int a=0;a<3;a++)
            if(rb[a].isChecked())
                result+="\n\t\t\t"+rb[a].getText().toString();
        result+="\nTopping(s):";
        for(int a=0;a<6;a++)
            if(cb[a].isChecked())
                result+="\n\t\t\t"+cb[a].getText().toString();
        return result;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}