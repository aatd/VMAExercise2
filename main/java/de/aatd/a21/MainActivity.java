package de.aatd.a21;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.SeekBar.*;

public class MainActivity extends Activity {


    private int zaehlerMorgens = 0;
    private int zaehlerAbends  = 0;

    private int summeAbends         =0;
    private int summeMorgens        =0;
    private int durchschnittAbends  =0;
    private int durchschnittMorgens =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar s = (SeekBar) findViewById(R.id.verspaetung);
        final RadioGroup verspaetungRadio = findViewById(R.id.morgensOderAbends);
        final int morgigeVerspaetung    = R.id.zaehlMorgens;
        final int abendlicheVerspaetung = R.id.zaehlAbends;
        int jetzigeVerspaetung    = verspaetungRadio.getCheckedRadioButtonId();
        s.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {

                                                                       @Override
                                                                       public void onStopTrackingTouch(SeekBar seekBar) {
                                                                           // TODO Auto-generated method stub
                                                                       }

                                                                       @Override
                                                                       public void onStartTrackingTouch(SeekBar seekBar) {
                                                                           // TODO Auto-generated method stub
                                                                       }

                                                                       @Override
                                                                       public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                                           // TODO Auto-generated method stub
                                                                           int jetzigeVerspaetung    = verspaetungRadio.getCheckedRadioButtonId();
                                                                           TextView morgens = (TextView) findViewById(R.id.verspaetungMorgens);
                                                                           TextView abends = (TextView) findViewById(R.id.verspaetungAbends);

                                                                           if (jetzigeVerspaetung == morgigeVerspaetung) {
                                                                               morgens.setText(progress + "");
                                                                               abends.setText("0");
                                                                           } else if (jetzigeVerspaetung == abendlicheVerspaetung) {
                                                                               abends.setText(progress + "");
                                                                               morgens.setText("0");
                                                                           }
                                                                       }
                                                                   });



    }

    public void trageVerspaetungEin(View view) {
        //Get Radiobuttongroup flags
        RadioGroup verspaetungRadio = (RadioGroup) findViewById(R.id.morgensOderAbends);

        int morgigeVerspaetung    = R.id.zaehlMorgens;
        int abendlicheVerspaetung = R.id.zaehlAbends;
        int jetzigeVerspaetung    = verspaetungRadio.getCheckedRadioButtonId();

        if(jetzigeVerspaetung == morgigeVerspaetung){
            //Get Seekbar value
            SeekBar minutenSeekbar = (SeekBar) findViewById(R.id.verspaetung);
            int verspaetung = minutenSeekbar.getProgress();

            //Do the math
            this.summeMorgens += verspaetung;//Summe
            zaehlerMorgens++;
            this.durchschnittMorgens = summeMorgens/zaehlerMorgens;

            //Set views
            TextView jetzt = (TextView) findViewById(R.id.verspaetungMorgens);
            TextView summe = (TextView) findViewById(R.id.gesamtMorgens);
            TextView durchschnitt = (TextView) findViewById(R.id.durchschnittMorgens);

            jetzt.setText(verspaetung+"");
            summe.setText(summeMorgens+"");
            durchschnitt.setText(durchschnittMorgens+"");
        }

        else if(jetzigeVerspaetung == abendlicheVerspaetung){
            //Get Seekbar value
            SeekBar minutenSeekbar = (SeekBar) findViewById(R.id.verspaetung);
            int verspaetung = minutenSeekbar.getProgress();

            //Do the math
            this.summeAbends += verspaetung;//Summe
            zaehlerAbends++;
            this.durchschnittAbends = summeAbends/zaehlerAbends;

            //Set views
            TextView jetzt = (TextView) findViewById(R.id.verspaetungAbends);
            TextView summe = (TextView) findViewById(R.id.gesamtAbends);
            TextView durchschnitt = (TextView) findViewById(R.id.durchschnittAbends);

            jetzt.setText(verspaetung+"");
            summe.setText(summeAbends+"");
            durchschnitt.setText(durchschnittAbends+"");
        }
    }
    public void setzeAllesZurueck(View view) {
        //Execute desicion Diaolog
        startActivity(new Intent(this, DecisionDialog.class));
        //Reset counters and sums to zero
    }
}

class Verspaetung extends Activity implements OnSeekBarChangeListener {

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            RadioGroup verspaetungRadio = findViewById(R.id.morgensOderAbends);
            int morgigeVerspaetung    = R.id.zaehlMorgens;
            int abendlicheVerspaetung = R.id.zaehlAbends;
            int jetzigeVerspaetung    = verspaetungRadio.getCheckedRadioButtonId();

            if(jetzigeVerspaetung == morgigeVerspaetung){
                TextView jetzt = (TextView) findViewById(R.id.verspaetungMorgens);
                jetzt.setText(progress+"");
            }
            else if (jetzigeVerspaetung== abendlicheVerspaetung){
                TextView jetzt = (TextView) findViewById(R.id.verspaetungAbends);
                jetzt.setText(progress+"");
            }

    }
}
