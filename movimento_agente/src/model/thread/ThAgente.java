package model.thread;

import model.Agente;

public class ThAgente extends Thread {
    private Agente agente;

    public ThAgente(String name, Agente agente) {
        super(name);
        this.agente = agente;
    }

    @Override
    public void run() {
        
    }
}
