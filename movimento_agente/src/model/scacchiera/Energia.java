package model.scacchiera;

public class Energia extends Risorsa{

    private int x;
    private int y;
 

    public Energia(int quantita) {
        super(quantita);
    }

    public Energia(int quantita, Casella casella) {
        super(quantita, casella);
    }

    public Energia(Casella casella, int x, int y) {
        super(casella);
        this.x = x;
        this.y = y;
    }

    @Override
    public void ricarica(int q) {
        setQuantita(getQuantita()+q);
        
    }

    @Override
    public void consuma(int q) {
        setQuantita(getQuantita()-q); 
    }
    
    @Override
    public String getInfo() {
        return casella.getInfo() + ";Energia";
    }  

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
