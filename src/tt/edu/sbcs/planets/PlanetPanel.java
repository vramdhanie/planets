package tt.edu.sbcs.planets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlanetPanel extends JPanel {

    Planet p;
    Timer timer;

    public PlanetPanel(){
        super();
        setBackground(Color.BLACK);
        p = new Planet(200, 30, 45);

        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyChar() == KeyEvent.VK_S){
                    timer.start();
                }

                if(e.getKeyChar() == KeyEvent.VK_D){
                    timer.stop();
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        p.draw((Graphics2D)g);
        //System.out.println("Repainting...");
    }
}
