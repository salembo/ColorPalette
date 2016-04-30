package com.studyjam.android.colorpalette;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    static int RED=0;
    static int GREEN=0;
    static int BLUE=0;
    SeekBar redBar;
    SeekBar greenBar;
    SeekBar blueBar;
    View colorTile;
    Button goColor;
    TextView redlabel;
    TextView greenlabel;
    TextView bluelabel;
    TextView rgbvalue;
    TextView hslValue;
    ColorCalculator colorcal;
    TextView hsvValue;
    TextView cmykValue;
    TextView xyzValue;
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
        colorTile=findViewById(R.id.colorTile);
        goColor=(Button)findViewById(R.id.gocolor);
        redlabel=(TextView) findViewById(R.id.redlabel);
        greenlabel=(TextView)findViewById(R.id.greenlabel);
        bluelabel=(TextView)findViewById(R.id.bluelabel);
        rgbvalue=(TextView)findViewById(R.id.rgbvalue);
        hslValue=(TextView) findViewById(R.id.hsl2);
        colorcal=new ColorCalculator();
        hsvValue=(TextView) findViewById(R.id.hsv2);
        cmykValue=(TextView) findViewById(R.id.cmyk2);
        xyzValue=(TextView)findViewById(R.id.xyz2);

        Bundle bundle=getIntent().getExtras();
        if(null!=bundle){
            RED=bundle.getInt("RED");
            GREEN=bundle.getInt("GREEN");
            BLUE=bundle.getInt("BLUE");

        }else{

            RED=redBar.getProgress();
            GREEN=greenBar.getProgress();
            BLUE=greenBar.getProgress();
        }


        redlabel.setText("Rojo: "+RED);
        greenlabel.setText("Verde: "+GREEN);
        bluelabel.setText("Azul: "+BLUE);
        rgbvalue.setText("(" + RED + "," + GREEN + "," + BLUE + ")");

        colorTile.setBackgroundColor(Color.rgb(RED, GREEN, BLUE));

        goColor.setText("(" + RED + "," + GREEN + "," + BLUE + ")");
        hslValue.setText(colorcal.rgbToHsl(RED, GREEN, BLUE));
        hsvValue.setText(colorcal.rgbToHsv(RED, GREEN, BLUE));
        cmykValue.setText(colorcal.rgbToCmyk(RED, GREEN, BLUE));
        xyzValue.setText(colorcal.rgbToXyz(RED,GREEN,BLUE));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (seekBar.getId()){
                    case R.id.Red: RED=progress;

                        redlabel.setText("Rojo: "+RED);
                        break;
                    case R.id.Green: GREEN=progress;
                        greenlabel.setText("Verde: "+GREEN);
                        break;
                    case R.id.Blue: BLUE=progress;
                        bluelabel.setText("Azul: "+BLUE);
                        break;
                }
        rgbvalue.setText("("+RED+","+GREEN+","+BLUE+")");
        hslValue.setText(colorcal.rgbToHsl(RED,GREEN,BLUE));
        hsvValue.setText(colorcal.rgbToHsv(RED, GREEN, BLUE));
        cmykValue.setText(colorcal.rgbToCmyk(RED, GREEN, BLUE));
        xyzValue.setText(colorcal.rgbToXyz(RED, GREEN, BLUE));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        RED=redBar.getProgress();
        GREEN=greenBar.getProgress();
        BLUE=greenBar.getProgress();
        redlabel.setText("Rojo: "+RED);
        greenlabel.setText("Verde: "+GREEN);
        bluelabel.setText("Azul: "+BLUE);
        rgbvalue.setText("("+RED+","+GREEN+"," + BLUE + ")");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        RED=redBar.getProgress();
        GREEN=greenBar.getProgress();
        BLUE=blueBar.getProgress();

        colorTile.setBackgroundColor(Color.rgb(RED,GREEN,BLUE));
        goColor.setText("(" + RED + "," + GREEN + "," + BLUE + ")");
        redlabel.setText("Rojo: "+RED);
        greenlabel.setText("Verde: " + GREEN);
        bluelabel.setText("Azul: "+BLUE);
        rgbvalue.setText("("+RED+","+GREEN+","+BLUE+")");
        hslValue.setText(colorcal.rgbToHsl(RED,GREEN,BLUE));
        hsvValue.setText(colorcal.rgbToHsv(RED, GREEN, BLUE));
        cmykValue.setText(colorcal.rgbToCmyk(RED, GREEN, BLUE));
        xyzValue.setText(colorcal.rgbToXyz(RED,GREEN,BLUE));
    }




    public void llamaSombras(View view){
        Intent intent=new Intent(getBaseContext(),TilesShadesActivity.class);
        intent.putExtra("RED",RED);
        intent.putExtra("GREEN",GREEN);
        intent.putExtra("BLUE",BLUE);
        startActivity(intent);
    }
}
