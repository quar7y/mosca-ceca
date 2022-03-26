package model.scacchiera;

import java.util.*;

import model.Agente;
import view.Finestra;

public class Scacchiera {

    private Casella scac[][];
    private int lenx;
    private int leny;
    private String tab;
    private Finestra finestra;

    public Scacchiera(int lenx, int leny, Finestra finestra) {
        this.lenx = lenx;
        this.leny = leny;
        this.tab = "";
        this.finestra = finestra;
        generate();
    }

    public Scacchiera(int lenx, int leny) {
        this.lenx = lenx;
        this.leny = leny;
        this.tab = "";
        generate();
    }

    private void generate() {
        scac = new Casella[lenx][leny];
        for (int i = 0; i < lenx; i++) {
            for (int j = 0; j < leny; j++) {
                Random r = new Random();
                int rand = r.nextInt(100);
                if (rand < 60)
                    rand = 0;
                else if (rand < 90)
                    rand = 1;
                else
                    rand = 2;
                switch (rand) {
                    case 0:
                        scac[i][j] = new ConcreteCasella();
                        break;
                    case 1:
                        scac[i][j] = new Seta((int) (Math.random() * 9) + 1, new ConcreteCasella());
                        break;
                    case 2:
                        scac[i][j] = new Energia(new ConcreteCasella(), i, j);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void posAg(Agente agg) {
        scac[agg.getX()][agg.getY()] = new CasellaOccupata(agg, new ConcreteCasella());
        /*
         * boolean b = true;
         * while (b) {
         * Random r = new Random();
         * int x = r.nextInt(100);
         * int y = r.nextInt(100);
         * if(getCasella(x, y).getInfo().equals("vuota")){
         * scac[x][y] = new CasellaOccupata(agg, new ConcreteCasella());
         * agg.setX(x);
         * agg.setY(y);
         * b=false;
         * }
         * }
         */
    }

    /**
     * 
     * @param x
     * @param y
     * @return
     */
    public Casella getCasella(int x, int y) {
        return scac[x][y];
    }

    public void setCasella(int x, int y, Casella casella) {
        scac[x][y] = casella;
    }

    /**
     * 
     * @param x
     * @param y
     * @param agg
     */
    public void move(int x, int y, Agente agg) { // prende in input le cordinate della casella dove si sposta l'agente e
                                                 // l'agente stesso
        Casella old = getCasella(agg.getX(), agg.getY());
        Casella nuova = getCasella(x, y);
        if (old.getInfo().contains("Energia")) {
            setCasella(agg.getX(), agg.getY(), new Energia(new ConcreteCasella(), agg.getX(), agg.getY()));
        } else {
            setCasella(agg.getX(), agg.getY(), new ConcreteCasella());
        }
        setCasella(x, y, new CasellaOccupata(agg, nuova));

        agg.setX(x);
        agg.setY(y);
        finestra.getScacc().repaint();
    }

    public boolean pianta(int x, int y, Agente agg) {
        // bisogna aggiungere le condizioni che se la casella non è vuota non può
        // piantare
        scac[x][y] = new CasellaBandiera(new ConcreteCasella(), agg);
        return true;
    }

    public Casella[] getNeighborhood(int x, int y) {
        Casella tmp[];
        if ((x == 0) && (y == 0)) {
            tmp = new Casella[3];
            tmp[0] = getCasella(x, y + 1);
            tmp[1] = getCasella(x + 1, y + 1);
            tmp[2] = getCasella(x + 1, y);
        } else if ((x == lenx) && (y == leny)) {
            tmp = new Casella[3];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x, y - 1);
            tmp[2] = getCasella(x - 1, y - 1);
        } else if ((x == 0) && (y == leny)) {
            tmp = new Casella[3];
            tmp[0] = getCasella(x + 1, y);
            tmp[1] = getCasella(x + 1, y - 1);
            tmp[2] = getCasella(x, y - 1);
        } else if ((x == lenx) && (y == 0)) {
            tmp = new Casella[3];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x - 1, y + 1);
            tmp[2] = getCasella(x, y + 1);
        } else if (y == 0) {
            tmp = new Casella[5];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x - 1, y + 1);
            tmp[2] = getCasella(x, y + 1);
            tmp[3] = getCasella(x + 1, y + 1);
            tmp[4] = getCasella(x + 1, y);
        } else if (x == 0) {
            tmp = new Casella[5];
            tmp[0] = getCasella(x, y + 1);
            tmp[1] = getCasella(x + 1, y + 1);
            tmp[2] = getCasella(x + 1, y);
            tmp[3] = getCasella(x + 1, y - 1);
            tmp[4] = getCasella(x, y - 1);
        } else if (y == leny) {
            tmp = new Casella[5];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x + 1, y);
            tmp[2] = getCasella(x + 1, y - 1);
            tmp[3] = getCasella(x, y - 1);
            tmp[4] = getCasella(x - 1, y - 1);
        } else if (x == lenx) {
            tmp = new Casella[5];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x - 1, y + 1);
            tmp[2] = getCasella(x, y + 1);
            tmp[3] = getCasella(x, y - 1);
            tmp[4] = getCasella(x - 1, y - 1);
        } else {
            tmp = new Casella[8];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x - 1, y + 1);
            tmp[2] = getCasella(x, y + 1);
            tmp[3] = getCasella(x + 1, y + 1);
            tmp[4] = getCasella(x + 1, y);
            tmp[5] = getCasella(x + 1, y - 1);
            tmp[6] = getCasella(x, y - 1);
            tmp[7] = getCasella(x - 1, y - 1);
        }
        return tmp;
    }

    private void print() {
        for (int i = 0; i < lenx; i++) {
            for (int j = 0; j < leny; j++) {
                if (scac[i][j].getInfo().equals("vuota"))
                    tab += "|x|";
                else if (scac[i][j].getInfo().contains("Seta"))
                    tab += "|S|";
                else if (scac[i][j].getInfo().contains("Energia"))
                    tab += "|E|";
                else
                    tab += "|O|";

            }
            tab += " \n";
        }
    }

    @Override
    public String toString() {
        print();
        return tab;
    }

    public int getLenx() {
        return lenx;
    }

    public void setLenx(int lenx) {
        this.lenx = lenx;
    }

    public int getLeny() {
        return leny;
    }

    public void setLeny(int leny) {
        this.leny = leny;
    }

    public Finestra getFinestra() {
        return finestra;
    }

    public void setFinestra(Finestra finestra) {
        this.finestra = finestra;
    }
}
