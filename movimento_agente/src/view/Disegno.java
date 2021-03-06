package view;

import javax.swing.*;

import model.scacchiera.*;
import java.awt.*;

public class Disegno extends JPanel{
    private int h;
    private int w;
    private Scacchiera sca;

    public Disegno(int h, int w, Scacchiera sca) {
        this.h = h;
        this.w = w;
        this.sca = sca;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon img;
        int x = 0;
        for(int i = 0; i < (sca.getLenx()*h); i+=h){
            int y =0;
            for(int j = 0; j < (sca.getLeny()*w); j+=w){
                g.setColor(Color.BLACK);
                g.fillRect(i, j, h, w);
                if(sca.getCasella(x, y).getInfo().equals("vuota")){
                    g.setColor(Color.WHITE);
                    g.fillRect(i, j, h-1, w-1);
                }else if(sca.getCasella(x, y).getInfo().contains("Occupata")){
                    img = new ImageIcon(".\\src\\view\\agente1.jpg");
                    g.drawImage( img.getImage(), i, j, h-1, w-1, null);
                }else if(sca.getCasella(x, y).getInfo().contains("Seta")){
                    img = new ImageIcon(".\\src\\view\\seta1.png");
                    g.drawImage( img.getImage(), i, j, h-1, w-1, null);    
                }else if(sca.getCasella(x, y).getInfo().contains("Energia")){
                    img = new ImageIcon(".\\src\\view\\energia1.png");
                    g.drawImage( img.getImage(), i, j, h-1, w-1, null);    
                }
                y++;
            }
            x++;
        }
    }
}
