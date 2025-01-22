package com.example.lampadinafx;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lampadina {
    private String nome;
    private boolean status;
    private int lum;
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

    public void setLum(int lum) {
        if(lum >= 1 && lum <= 5) {
            this.lum = lum;
        } else {
            throw new IllegalArgumentException("La luminosità deve essere tra 1 e 5");
        }
    }

    public void setRgb(ArrayList<Integer> rgb) {
        if(rgb.get(0) >= 0 && rgb.get(0) <= 255 && rgb.get(1)>= 0 && rgb.get(1) <= 255 && rgb.get(2) >= 0 && rgb.get(2) <= 255) {
            rgb.clear();
            this.rgb.add(0,rgb.get(0));
            this.rgb.add(1,rgb.get(1));
            this.rgb.add(2,rgb.get(2));
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
            setLum(Integer.parseInt(strtok.nextToken()));
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

    public int getLum() {
        return this.lum;
    }

    public ArrayList<Integer> getRgb() {
        return new ArrayList<>(this.rgb);
    }

    public String getNome() {
        return this.nome;
    }
}
