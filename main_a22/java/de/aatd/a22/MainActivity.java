package de.aatd.a22;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.ContextMenu.*;
import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        TextView name    = (TextView) findViewById(R.id.name);
        TextView surname = (TextView) findViewById(R.id.surname);

        String outputtext = "";

        if (item.getItemId()==R.id.politeGreetings){

            outputtext = "Sehr geehrte/er Frau/Herr " + surname.getText();

            makeText(getApplicationContext(),outputtext, LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.slangGreetings){

            outputtext = "Hallo " + name.getText();

            makeText(getApplicationContext(),outputtext, LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mi = new MenuInflater(getApplication());
        mi.inflate(R.menu.kontextmenue, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = new MenuInflater(getBaseContext());
        mi.inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        TextView name    = (TextView) findViewById(R.id.name);
        TextView surname = (TextView) findViewById(R.id.surname);

        String outputtext = "Werte Person! Ohne Name keine Begrüßung!";

        if (item.getItemId()==R.id.morning){
            if(!(name.equals("") || name == null))
                outputtext = "Guten Morgen " + name.getText() + " " + surname.getText() + "!";

            makeText(getApplicationContext(),outputtext, LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.day){

            if(!(name.equals("") || name == null))
                outputtext = "Guten Mittag " + name.getText() + " " + surname.getText() + "!";

            makeText(getApplicationContext(),outputtext, LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.evening){

            if(!(name.equals("") || name == null))
                outputtext = "Guten Abend " + name.getText() + " " + surname.getText() + "!";

            makeText(getApplicationContext(),outputtext, LENGTH_SHORT).show();
        }
        return true;
    }

    public void makeBegruessung(View view) {
        registerForContextMenu(view);
    }
}
