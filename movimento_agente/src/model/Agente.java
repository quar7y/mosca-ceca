package model;
import java.util.*;
import model.scacchiera.*;

public class Agente{
    
    private int x;
    private int y;
    private String name;
    private Energia eng;
    private Seta seta;
    private int bandierine;
    private Scacchiera sca;

    public Agente(int x, int y, String name, Energia eng, Seta seta, Scacchiera sca) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.eng = eng;
        this.seta = seta;
        this.sca = sca;
    }

    public synchronized void pianta(){
        if((sca.pianta(this.x, this.y, this)) && (bandierine > 0)){
            bandierine--;
        }
    }

    public int craftBandiera(){
        if(seta.getQuantita() < 4){
            System.out.println("Non hai abbastanza seta");
            return -2;
        }
        while(seta.getQuantita() >= 4){
            this.bandierine++;
            seta.setQuantita(seta.getQuantita()-4);
        }
        return 0;
    }

    public synchronized ArrayList <Casella> allFree(){
        ArrayList <Casella> tmp = new ArrayList<>();        
        Casella neig[] = sca.getNeighborhood(this.x, this.y);
        for (Casella cas : neig) {
            if(cas.getInfo().contains("vuota")){
                tmp.add(cas); 
            }
        }
        return tmp;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Energia getEng() {
        return eng;
    }

    public void setEng(Energia eng) {
        this.eng = eng;
    }

    public Seta getSeta() {
        return seta;
    }

    public void setSeta(Seta seta) {
        this.seta = seta;
    }

    public Scacchiera getSca() {
        return sca;
    }

    public void setSca(Scacchiera sca) {
        this.sca = sca;
    }

}
