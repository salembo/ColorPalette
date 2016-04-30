package com.studyjam.android.colorpalette;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TilesShadesActivity extends AppCompatActivity {
    static int RED=-1;
    static int GREEN=-1;
    static int BLUE=-1;
    View tileShade;
    Button labelcol;
    View uno;
    View dos;
    View tres;
    View cuatro;
    View cinco;
    View seis;
    View siete;
    View ocho;
    View nueve;
    View diez;
    View once;
    int sombras[][];
    TextView lu;
    TextView ld;
    TextView lt;
    TextView lc;
    TextView lci;
    TextView lse;
    TextView ls;
    TextView lo;
    TextView ln;
    TextView ldi;
    TextView lon;

    View tuno;
    View tdos;
    View ttres;
    View tcuatro;
    View tcinco;
    View tseis;
    View tsiete;
    View tocho;
    View tnueve;
    View tdiez;
    View tonce;
    int tintes[][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiles_shades);
        Bundle bundle=getIntent().getExtras();


        RED=bundle.getInt("RED");
        GREEN=bundle.getInt("GREEN");
        BLUE=bundle.getInt("BLUE");
        tileShade=findViewById(R.id.colorBlock);
        tileShade.setBackgroundColor(Color.rgb(RED,GREEN,BLUE));
        labelcol=(Button)findViewById(R.id.button);
        labelcol.setText("(" + RED + "," + GREEN + "," + BLUE + ")");
        ColorCalculator colores=new ColorCalculator();
        sombras=colores.sombras(RED, GREEN, BLUE);

        uno=findViewById(R.id.uno);
        uno.setBackgroundColor(Color.rgb(sombras[0][0], sombras[0][1], sombras[0][2]));
        dos=findViewById(R.id.dos);
        dos.setBackgroundColor(Color.rgb(sombras[1][0],sombras[1][1],sombras[1][2]));
        tres=findViewById(R.id.tres);
        tres.setBackgroundColor(Color.rgb(sombras[2][0],sombras[2][1],sombras[2][2]));
        cuatro=findViewById(R.id.cuatro);
        cuatro.setBackgroundColor(Color.rgb(sombras[3][0],sombras[3][1],sombras[3][2]));
        cinco=findViewById(R.id.cinco);
        cinco.setBackgroundColor(Color.rgb(sombras[4][0],sombras[4][1],sombras[4][2]));
        seis=findViewById(R.id.seis);
        seis.setBackgroundColor(Color.rgb(sombras[5][0],sombras[5][1],sombras[5][2]));
        siete=findViewById(R.id.siete);
        siete.setBackgroundColor(Color.rgb(sombras[6][0], sombras[6][1], sombras[6][2]));
        ocho=findViewById(R.id.ocho);
        ocho.setBackgroundColor(Color.rgb(sombras[7][0], sombras[7][1], sombras[7][2]));
        nueve=findViewById(R.id.nueve);
        nueve.setBackgroundColor(Color.rgb(sombras[8][0], sombras[8][1], sombras[8][2]));
        diez=findViewById(R.id.diez);
        diez.setBackgroundColor(Color.rgb(sombras[9][0], sombras[9][1], sombras[9][2]));
        once=findViewById(R.id.once);
        once.setBackgroundColor(Color.rgb(sombras[10][0], sombras[10][1], sombras[10][2]));

         lu=(TextView)findViewById(R.id.lu);
        lu.setText(sombras[0][0] + "," + sombras[0][1] + "," + sombras[0][2]);
        ld=(TextView) findViewById(R.id.ld);
        lu.setText(sombras[1][0]+","+ sombras[1][1]+","+ sombras[1][2]);
         lt=(TextView)findViewById(R.id.lt);
        lt.setText(sombras[2][0]+","+ sombras[2][1]+","+ sombras[2][2]);
         lc=(TextView)findViewById(R.id.lc);
        lc.setText(sombras[3][0]+","+ sombras[3][1]+","+ sombras[3][2]);
         lci=(TextView)findViewById(R.id.lci);
        lci.setText(sombras[4][0]+","+ sombras[4][1]+","+ sombras[4][2]);
         lse=(TextView)findViewById(R.id.lse);
        lse.setText(sombras[5][0]+","+ sombras[5][1]+","+ sombras[5][2]);
         ls=(TextView)findViewById(R.id.ls);
        ls.setText(sombras[6][0]+","+ sombras[6][1]+","+ sombras[6][2]);
         lo=(TextView)findViewById(R.id.lo);
        lo.setText(sombras[7][0]+","+ sombras[7][1]+","+ sombras[7][2]);
         ln=(TextView)findViewById(R.id.ln);
        ln.setText(sombras[8][0]+","+ sombras[8][1]+","+ sombras[8][2]);
         ldi=(TextView)findViewById(R.id.ldi);
        ldi.setText(sombras[9][0]+","+ sombras[9][1]+","+ sombras[9][2]);
         lon=(TextView)findViewById(R.id.lon);
        lon.setText(sombras[10][0]+","+ sombras[10][1]+","+ sombras[10][2]);


        tintes=colores.tintes(RED, GREEN, BLUE);

        tuno=findViewById(R.id.tuno);
        tuno.setBackgroundColor(Color.rgb(tintes[0][0], tintes[0][1], tintes[0][2]));
        tdos=findViewById(R.id.tdos);
        tdos.setBackgroundColor(Color.rgb(tintes[1][0],tintes[1][1],tintes[1][2]));
        ttres=findViewById(R.id.ttres);
        ttres.setBackgroundColor(Color.rgb(tintes[2][0],tintes[2][1],tintes[2][2]));
        tcuatro=findViewById(R.id.tcuatro);
        tcuatro.setBackgroundColor(Color.rgb(tintes[3][0],tintes[3][1],tintes[3][2]));
        tcinco=findViewById(R.id.tcinco);
        tcinco.setBackgroundColor(Color.rgb(tintes[4][0],tintes[4][1],tintes[4][2]));
        tseis=findViewById(R.id.tseis);
        tseis.setBackgroundColor(Color.rgb(tintes[5][0],tintes[5][1],tintes[5][2]));
        tsiete=findViewById(R.id.tsiete);
        tsiete.setBackgroundColor(Color.rgb(tintes[6][0], tintes[6][1], tintes[6][2]));
        tocho=findViewById(R.id.tocho);
        tocho.setBackgroundColor(Color.rgb(tintes[7][0], tintes[7][1], tintes[7][2]));
        tnueve=findViewById(R.id.tnueve);
        tnueve.setBackgroundColor(Color.rgb(tintes[8][0], tintes[8][1], tintes[8][2]));
        tdiez=findViewById(R.id.tdiez);
        tdiez.setBackgroundColor(Color.rgb(tintes[9][0], tintes[9][1], tintes[9][2]));
        tonce=findViewById(R.id.tonce);
        tonce.setBackgroundColor(Color.rgb(tintes[10][0], tintes[10][1], tintes[10][2]));
        System.out.println("Se coloca el ultimo tinte ");
    }
    public void llamaSombras(View view){
        Intent intent=new Intent(getBaseContext(),MainActivity.class);
        intent.putExtra("RED",RED);
        intent.putExtra("GREEN",GREEN);
        intent.putExtra("BLUE",BLUE);
        startActivity(intent);
    }
}
