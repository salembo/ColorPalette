package com.studyjam.android.colorpalette;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Ana on 23/04/2016.
 */
public class ColorCalculator {

    String rgbToHsl( int R,int G,int B){
        double l;
        double s;
        double h;
        double maxi;
        int comp;
            double r=R/255.0f;
            double g=G/255.0f;
            double b=B/255.0f;
        double min;
        double max;
        min=Math.min(r, Math.min(g, b));
        max=Math.max(r, Math.max(g, b));
        l=(max+min)/2;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        if (max==min){
            s=0;
            h=0;
        }else{
            if(l>0.5){
                s=(max-min)/(2.0-max+min);
            }
            else{
                s=(max-min)/(max+min);
            }

            maxi=255*max;
            comp=(int)maxi;

            if (comp==R){
                h=((g-b)/(max-min))/6;
            }else{
                if(comp==G){

                    h=((b-r)/(max-min)+2.0)/6;

                }else{
                    h=((r-g)/(max-min)+4.0)/6;

                }
            }
        }


        return df.format(h)+" "+df.format(s)+" "+df.format(l);
    }

    String rgbToHsv(int R, int G,int B){
        double v;
        double s;
        double h;
        double maxi;
        int comp;
        double r=R/255.0f;
        double g=G/255.0f;
        double b=B/255.0f;
        double min;
        double max;
        min=Math.min(r, Math.min(g, b));
        max=Math.max(r, Math.max(g, b));

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        if (max==min){
            s=0;
            h=0;
            v=min;
        }else{
            s=(max-min)/max;
            v=max;
            maxi=255*max;
            comp=(int)maxi;

            if (comp==R){
                h=((g-b)/(max-min))/6;
            }else{
                if(comp==G){

                    h=((b-r)/(max-min)+2.0)/6;

                }else{
                    h=((r-g)/(max-min)+4.0)/6;

                }
            }
        }

        return df.format(h)+" "+df.format(s)+" "+df.format(v);
    }

    String rgbToCmyk(int R,int G,int B){

        double c;
        double m;
        double y;
        double maxi;
        double k;
        double r=R/255.0f;
        double g=G/255.0f;
        double b=B/255.0f;
        double max;
        max=Math.max(r, Math.max(g, b));
        k=1-max;
        c=(1-r-k)/(1-k);
        m=(1-g-k)/(1-k);
        y=(1-b-k)/(1-k);

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        return df.format(c)+" "+df.format(m)+" "+df.format(y)+" "+df.format(k);
    }

    String rgbToXyz(int R,int G,int B){

        double x;
        double y;
        double z;

        double r=R/255.0f;
        double g=G/255.0f;
        double b=B/255.0f;

        if(r>0.04045){
            r=Math.pow(((r+0.055)/1.055),2.4);
        }else{
            r=r/12.92;
        }

        if(g>0.04045){
            g=Math.pow(((g+0.055)/1.055),2.4);
        }
        else{
            g=g/12.92;
        }

        if(b>0.04045){
            b=Math.pow(((b+0.055)/1.055),2.4);
        }
        else{
            b=b/12.92;
        }
        r=r*100;
        g=g*100;
        b=b*100;

        x=r*0.4124+g*0.3576+b*0.1805;
        y=r*0.2126+g*0.7152+b*0.0722;
        z=r*0.0193+g*0.1192+b*0.9505;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(x)+" "+df.format(y)+" "+df.format(z);
    }

    public int [][] sombras(int R,int G,int B){
        int sombra[][]=new int[11][3];
        sombra[0][0]=R;
        sombra[0][1]=G;
        sombra[0][2]=B;
        double fraccion;
        for (int i=1;i<11;i++){
            fraccion=i/44.0f;
            sombra[i][0]=(int)(sombra[i-1][0]*(1-fraccion));
            sombra[i][1]=(int)(sombra[i-1][1]*(1-fraccion));
            System.out.println("Fraccion "+fraccion);
            sombra[i][2]=(int)(sombra[i-1][2]*(1-fraccion));
        }
    System.out.println("Termina la generacion de sombras ");
        return sombra;

    }

    public int [][] tintes(int R,int G,int B){
        int tinte[][]=new int[11][3];
        tinte[0][0]=R;
        tinte[0][1]=G;
        tinte[0][2]=B;
        double fraccion;
        for (int i=1;i<11;i++){
            fraccion=i/44.0f;
            tinte[i][0]=(int)(tinte[i-1][0]+(255-tinte[i-1][0])*fraccion);
            tinte[i][1]=(int)(tinte[i-1][1]+(255-tinte[i-1][1])*fraccion);
            System.out.println("Fraccion "+fraccion);
            tinte[i][2]=(int)(tinte[i-1][2]+(255-tinte[i-1][2])*fraccion);
        }
        System.out.println("Termina la generacion de tintes ");
        return tinte;

    }
}
