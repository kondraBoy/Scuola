package com.example.thread;

public class Operazioni extends Thread{
    private boolean operazione;
    private Cassaforte cassaforte;
    private double soldi;
    private HelloController controller;

    public Operazioni(boolean operazione, double soldi, Cassaforte cassaforte, HelloController controller){
        this.operazione = operazione;
        this.soldi = soldi;
        this.cassaforte = cassaforte;
        this.controller = controller;
    }

    @Override
    public void run(){
        synchronized (cassaforte){
            if(!operazione) {
                cassaforte.prelievo(soldi);
            }else{
                cassaforte.deposito(soldi);
            }
            controller.update(operazione, soldi, cassaforte.getSaldo());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean getOperazione(){
        return operazione;
    }

    public double getSoldi() {
        return soldi;
    }

}
