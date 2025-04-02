package com.example.thread;
public class Cassaforte{
    private double saldo;
    private double saldoMax;

    public Cassaforte(double saldo,double saldoMax){
        setSaldo(saldo);
        setSaldoMax(saldoMax);

    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo<0 || saldo > saldoMax)
            throw new IllegalArgumentException("Saldo minore di 0 o troppo grande");
        else
            this.saldo = saldo;
    }


    public void setSaldoMax(double saldoMax) {
        if(saldoMax <0)
            throw new IllegalArgumentException("Saldo massimo minore di 0");
        else
            this.saldoMax = saldoMax;
    }

    public void deposito(double soldi){
        setSaldo(getSaldo() + soldi);
    }

    public void prelievo(double soldi){
        setSaldo(getSaldo() - soldi);
    }

}


