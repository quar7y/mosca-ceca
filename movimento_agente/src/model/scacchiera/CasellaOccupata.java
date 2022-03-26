package model.scacchiera;

import model.Agente;

public class CasellaOccupata extends Decorator{

    private Agente agente;
    
    public CasellaOccupata(Agente agente, Casella casella) {
        this.agente = agente;
        this.casella = casella;
    }

    @Override
    public String getInfo() {
        return casella.getInfo().replace("vuota", "Occupata");
    }
    
}
