import model.Agente;
import model.scacchiera.*;
import view.Finestra;

public class App {

    public static void main(String[] args) throws Exception {
        Scacchiera s = new Scacchiera(100, 100);
        Agente agg = new Agente(0, 0, "Quartiero", new Energia(100), new Seta(100), s);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                s.setFinestra(new Finestra(s));
            }
        });
        s.posAg(agg);
        for(int i = 0; i < 99; i++){
            Thread.sleep(2000);
            s.move(agg.getX(), agg.getY()+1, agg);
        }
        //System.out.println(s.toString());
    }
}
