package model.scacchiera;

public abstract class Risorsa extends Decorator{
    protected int quantita;

    public Risorsa(int quantita, Casella casella) {
        this.quantita = quantita;
        this.casella = casella;
    }

    public Risorsa(int quantita){
        this.quantita = quantita;
    }

    public Risorsa(Casella casella) {
        this.casella = casella;
        this.quantita = Integer.MAX_VALUE;
    }

    public abstract void ricarica(int q);

    public abstract void consuma(int q);
    
    @Override
    public abstract String getInfo();
    
    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
