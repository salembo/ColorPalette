package com.studyjam.android.colorpalette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    static int RED=0;
    static int GREEN=0;
    static int BLUE=0;
    SeekBar redBar;
    SeekBar greenBar;
    SeekBar blueBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redBar=(SeekBar)findViewById(R.id.Red);
        greenBar=(SeekBar)findViewById(R.id.Green);
        blueBar=(SeekBar)findViewById(R.id.Blue);
        redBar.setOnSeekBarChangeListener(this);
        greenBar.setOnSeekBarChangeListener(this);
        blueBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (seekBar.getId()){
                    case R.id.Red: RED=progress;
                        Toast.makeText(getApplicationContext(),"Rojo: "+progress,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Green: GREEN=progress;
                        Toast.makeText(getApplicationContext(),"Verde: "+progress,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Blue: BLUE=progress;
                        Toast.makeText(getApplicationContext(),"Azul: "+progress,Toast.LENGTH_SHORT).show();
                        break;
                }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
