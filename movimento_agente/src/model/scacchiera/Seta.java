package model.scacchiera;

public class Seta extends Risorsa{

    public Seta(int quantita) {
        super(quantita);
    }

    public Seta(int quantita, Casella casella) {
        super(quantita, casella);
    }

    @Override
    public void ricarica(int q) {
        int tmp = getQuantita() + q;
        setQuantita(tmp);
    }

    @Override
    public void consuma(int q) {
        int tmp = getQuantita() - q;
        setQuantita(tmp); 
    }

    @Override
    public String getInfo() {
        return casella.getInfo() + ";Seta";
    }
}
