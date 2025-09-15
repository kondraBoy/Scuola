package com.example.lampadinafx;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lampadina {
    private String nome;
    private boolean status;
    private float lum;
    private ArrayList<Integer> rgb;

    public Lampadina(String nome){
        setNome(nome);
        setStatus(false);
        setLum(1);
        rgb = new ArrayList<>(3);
        rgb.add(255);
        rgb.add(255);
        rgb.add(255);
    }

    public void setNome(String nome) {
        if(nome.trim().isEmpty() || nome==null) {
            throw new IllegalArgumentException("La lampadina deve avere un nome");
        } else {
            this.nome = nome;
        }
    }

    public void setLum(float lum) {
        if(lum >= 1 && lum <= 5) {
            this.lum = lum;
        } else {
            throw new IllegalArgumentException("La luminosità deve essere tra 1 e 5");
        }
    }

    public void setRgb(int r, int g, int b) {
        if(r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {
            rgb.set(0, r);
            rgb.set(1, g);
            rgb.set(2, b);
        } else {
            throw new IllegalArgumentException("I valori RGB devono essere tra 0 e 255");
        }
    }

    public String toCSV() {
        return this.nome + ";" + this.status + ";" + this.lum + ";" + this.rgb + ";" + "\n";
    }

    public void fromCSV(String s){
        StringTokenizer strtok = new StringTokenizer(s,";");
        while(strtok.hasMoreTokens()){
            setNome(strtok.nextToken());
            setStatus(Boolean.parseBoolean(strtok.nextToken()));
            setLum(Float.parseFloat(strtok.nextToken()));
            int rgb0 = (Integer.parseInt(strtok.nextToken(",")));
            int rgb1 = (Integer.parseInt(strtok.nextToken(",")));
            int rgb2 = (Integer.parseInt(strtok.nextToken(",")));
            ArrayList<Integer> rgb = new ArrayList<>(3);
            rgb.add(rgb0);
            rgb.add(rgb1);
            rgb.add(rgb2);
        }
    }


    public void setStatus(boolean status) {
        if(!status)
            this.status = true;
        else
            this.status = false;
    }

    public boolean getStatus() {
        return this.status;
    }

    public float getLum() {
        return this.lum;
    }

    public int getR() {
        return this.rgb.get(0);
    }
    public int getG() {
        return this.rgb.get(1);
    }

    public int getB() {
        return this.rgb.get(2);
    }

    public String getNome() {
        return this.nome;
    }
}
