package model.thread;

import model.scacchiera.Seta;

public class ThSeta extends Thread {
    public Seta seta;

    public ThSeta(String name, Seta seta) {
        super(name);
        this.seta = seta;
    }

    @Override
    public void run() {
        
    }
    
}
