package model.thread;

import model.scacchiera.Energia;

public class ThEnergia extends Thread {
    private Energia energia;

    public ThEnergia(String name, Energia energia) {
        super(name);
        this.energia = energia;
    }

    @Override
    public void run() {
        
    }
}
